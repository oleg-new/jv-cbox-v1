package com.olegnew.jvcboxv1.service.cbox;

import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import java.util.List;
import java.util.Optional;

public interface CboxService {
    List<Cbox> getAllCboxs();

    Optional<Cbox> getById(String id);

    FullInformation add(FullInformation fullInformation);

    Optional<Cbox> findCboxByStreetAndHouse(String street, String house);

    FullInformation getFullInformation(String id, boolean hasOperatorRole);

    FullInformation updateById(String id, FullInformation fullInformation);

    void delete(Long id);

    void rebootDevice(String ipAddress);
}
