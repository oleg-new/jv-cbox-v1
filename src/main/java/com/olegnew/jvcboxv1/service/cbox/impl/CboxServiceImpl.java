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
        return updateById(1L, fullInformation, true);
    }

    @Override
    public Optional<Cbox> findCboxByStreetAndHouse(String street, String house) {
        return cboxRepository.findCboxByStreetAndHouse(street, house);
    }

    @Override
    public FullInformation getFullInformation(Long id, boolean hasOperatorRole) {
        FullInformation fullInformation = new FullInformation();
        Cbox cbox = cboxRepository.findById(id).get();
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
    public FullInformation updateById(Long id, FullInformation fullInformation,
                                      boolean newNewDevice) {
        boolean rebootRequired = newNewDevice;

        Cbox cbox = new Cbox();
        if (!newNewDevice) {
            cbox = cboxRepository.findById(id).get();
        } else {
            Cbox defaultCbox = cboxRepository.findById(1L).get();
            cbox.setIpAddress(defaultCbox.getIpAddress());
            cbox.setSnmpCommunity(defaultCbox.getSnmpCommunity());
        }
        snmpAgentV1.setFullInformationOnTheDevice(cbox, fullInformation,
                        DefaultDevice.getInstance().getListOfDefaultValues());
        if (fullInformation.getHouse() != null) {
            cbox.setHouse(fullInformation.getHouse());
        }
        if (fullInformation.getStreet() != null) {
            cbox.setStreet(fullInformation.getStreet());
        }
        if (fullInformation.getReceivedInformation().containsKey("SysIPaddress")
                || fullInformation.getReceivedInformation().containsKey("SysIPmask")
                || fullInformation.getReceivedInformation().containsKey("SysGateIPaddress")
                || fullInformation.getReceivedInformation().containsKey("SysTrapIPaddress")) {
            rebootRequired = true;
        }
        if (rebootRequired) {
            rebootDevice(cbox);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (fullInformation.getReceivedInformation().containsKey("SysIPaddress")) {
            cbox.setIpAddress(fullInformation.getReceivedInformation().get("SysIPaddress"));
        }
        cboxRepository.save(cbox);

        return getFullInformation(cbox.getId(), true);
    }

    @Override
    public void delete(Long id) {
        HashMap<String, String> receivedInformation = new HashMap<>();
        receivedInformation.put("SysIPaddress","192.168.0.10");
        receivedInformation.put("SysIPmask", "255.255.255.0");
        receivedInformation.put("SysGateIPaddress", "192.168.0.1");
        receivedInformation.put("SysTrapIPaddress", "192.168.0.1");
        receivedInformation.put("SysSnmpRdComm", "public");
        receivedInformation.put("SysSnmpWrComm", "public");
        receivedInformation.put("SysSnmpTrapComm", "public");
        FullInformation defaultInformation = new FullInformation();
        defaultInformation.setReceivedInformation(receivedInformation);
        Cbox cbox = cboxRepository.findById(id).get();
        snmpAgentV1.setFullInformationOnTheDevice(cbox, defaultInformation,
                DefaultDevice.getInstance().getListOfDefaultValues());
        rebootDevice(cbox);
        cboxRepository.delete(cbox);
    }

    @Override
    public void rebootDevice(Cbox cbox) {
        snmpAgentV1.rebootCbox(cbox.getIpAddress(), cbox.getSnmpCommunity());
    }
}
