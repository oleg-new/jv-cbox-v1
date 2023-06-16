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
    private Cbox cbox;

    @Override
    public List<Cbox> getAllCboxs() {
        return cboxRepository.findAll();
    }

    @Override
    public Optional<Cbox> getById(String id) {
        return cboxRepository.findById(Long.valueOf(id));
    }

    @Override
    public Cbox add(Cbox cbox) {
        return cboxRepository.save(cbox);
    }

    @Override
    public Optional<Cbox> findCboxByStreetAndHouse(String street, String house) {
        return cboxRepository.findCboxByStreetAndHouse(street, house);
    }

    @Override
    public FullInformation getFullInformation(String id) {
        cbox = cboxRepository.findById(Long.valueOf(id)).get();
        fullInformation.setId(cbox.getId());
        fullInformation.setHouse(cbox.getHouse());
        fullInformation.setStreet(cbox.getStreet());
        HashMap<String, String> target = snmpAgentV1.getTarget(cbox.getIpAddress(),
                DefaultDevice.getInstance().getListOfDefaultValues(),
                cbox.getSnmpCommunity());
        fullInformation.setReceivedInformation(target);
        return fullInformation;
    }
}
