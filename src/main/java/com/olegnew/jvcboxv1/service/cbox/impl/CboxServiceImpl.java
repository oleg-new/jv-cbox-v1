package com.olegnew.jvcboxv1.service.cbox.impl;

import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.model.cbox.DefaultDevice;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import com.olegnew.jvcboxv1.repository.CboxRepository;
import com.olegnew.jvcboxv1.service.cbox.CboxService;
import com.olegnew.jvcboxv1.service.snmp.SnmpAgentV1;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CboxServiceImpl implements CboxService {
    private final CboxRepository cboxRepository;
    private final FullInformation fullInformation;
    @Autowired
    private SnmpAgentV1 snmpAgentV1;

    @Override
    public List<Cbox> getAllCboxs() {
        return cboxRepository.findAll();
    }

    @Override
    public Optional<Cbox> getById(String id) {
        return cboxRepository.findById(Long.valueOf(id));
    }

    @Override
    public FullInformation add(FullInformation fullInformation) {
        Cbox newCbox = new Cbox();
        newCbox.setStreet(fullInformation.getStreet());
        newCbox.setHouse(fullInformation.getHouse());
        newCbox.setIpAddress(fullInformation.getReceivedInformation().get("SysIPaddress"));
        newCbox.setSnmpCommunity(fullInformation.getReceivedInformation().get("SysSnmpWrComm"));
        Cbox savedCbox = cboxRepository.save(newCbox);
        return updateById(savedCbox.getId(), fullInformation);
    }

    @Override
    public Optional<Cbox> findCboxByStreetAndHouse(String street, String house) {
        return cboxRepository.findCboxByStreetAndHouse(street, house);
    }

    @Override
    public FullInformation getFullInformation(Long id, boolean hasOperatorRole) {
        Cbox cbox;
        cbox = cboxRepository.findById(id).get();
        fullInformation.setId(cbox.getId());
        fullInformation.setHouse(cbox.getHouse());
        fullInformation.setStreet(cbox.getStreet());
        HashMap<String, String> target = snmpAgentV1.getTarget(cbox.getIpAddress(),
                DefaultDevice.getInstance().getListOfDefaultValues(),
                cbox.getSnmpCommunity(), hasOperatorRole);
        fullInformation.setReceivedInformation(target);
        return fullInformation;
    }

    @Override
    public FullInformation updateById(Long id, FullInformation fullInformation) {
        boolean rebootRequired = false;
        String currentAddress;
        Cbox cbox = cboxRepository.findById(id).get();
        if (fullInformation.getHouse() != null) {
            cbox.setHouse(fullInformation.getHouse());
        }
        if (fullInformation.getStreet() != null) {
            cbox.setStreet(fullInformation.getStreet());
        }
        if (fullInformation.getReceivedInformation().containsKey("SysIPaddress")) {
            currentAddress = cbox.getIpAddress();
            cbox.setIpAddress(fullInformation.getReceivedInformation().get("SysIPaddress"));
            rebootRequired = true;
        } else {
            fullInformation.getReceivedInformation().put("SysIPaddress", cbox.getIpAddress());
        }
        if (fullInformation.getReceivedInformation().containsKey("SysSnmpRdComm")) {
            cbox.setSnmpCommunity(fullInformation.getReceivedInformation().get("SysSnmpRdComm"));
        } else {
            fullInformation.getReceivedInformation().put("SysSnmpRdComm", cbox.getSnmpCommunity());
        }
        snmpAgentV1
                .setFullInformationOnTheDevice(fullInformation,
                DefaultDevice.getInstance().getListOfDefaultValues());
        rebootDevice(cbox.getId());
        cboxRepository.save(cbox);

        return getFullInformation(id, true);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean needToReboot(Long id, FullInformation fullInformation) {

        return false;
    }

    @Override
    public void rebootDevice(Long id) {
        Cbox cbox = cboxRepository.getById(id);
        snmpAgentV1.rebootCbox(cbox.getIpAddress(), cbox.getSnmpCommunity());
    }

}
