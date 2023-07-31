package com.olegnew.jvcboxv1.service.cbox.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.model.cbox.Element;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import com.olegnew.jvcboxv1.repository.CboxRepository;
import com.olegnew.jvcboxv1.service.snmp.SnmpAgentV1;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {CboxServiceImpl.class, FullInformation.class})
@ExtendWith(SpringExtension.class)
class CboxServiceImplTest {
    @MockBean
    private CboxRepository cboxRepository;

    @Autowired
    private CboxServiceImpl cboxServiceImpl;

    @Autowired
    private FullInformation fullInformation;

    @MockBean
    private SnmpAgentV1 snmpAgentV1;

    /**
     * Method under test: {@link CboxServiceImpl#getAllCboxs()}
     */
    @Test
    void testGetAllCboxs() {
        ArrayList<Cbox> cboxList = new ArrayList<>();
        when(cboxRepository.findAll()).thenReturn(cboxList);
        List<Cbox> actualAllCboxs = cboxServiceImpl.getAllCboxs();
        assertSame(cboxList, actualAllCboxs);
        assertTrue(actualAllCboxs.isEmpty());
        verify(cboxRepository).findAll();
    }

    /**
     * Method under test: {@link CboxServiceImpl#getAllCboxs()}
     */
    @Test
    void testGetAllCboxs2() {
        when(cboxRepository.findAll()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.getAllCboxs());
        verify(cboxRepository).findAll();
    }

    /**
     * Method under test: {@link CboxServiceImpl#getById(String)}
     */
    @Test
    void testGetById() {
        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Cbox> actualById = cboxServiceImpl.getById("42");
        assertSame(ofResult, actualById);
        assertTrue(actualById.isPresent());
        verify(cboxRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#getById(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetById2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Id"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        //       at java.lang.Long.parseLong(Long.java:711)
        //       at java.lang.Long.valueOf(Long.java:1163)
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.getById(CboxServiceImpl.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        cboxServiceImpl.getById("Id");
    }

    /**
     * Method under test: {@link CboxServiceImpl#getById(String)}
     */
    @Test
    void testGetById3() {
        when(cboxRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.getById("42"));
        verify(cboxRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#add(FullInformation)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAdd() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Map.containsKey(Object)" because "that" is null
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.updateById(CboxServiceImpl.java:79)
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.add(CboxServiceImpl.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        cboxServiceImpl.add(fullInformation);
    }

    /**
     * Method under test: {@link CboxServiceImpl#add(FullInformation)}
     */
    @Test
    void testAdd2() {
        doThrow(new RuntimeException("SysIPaddress")).when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.add(fullInformation));
        verify(snmpAgentV1).setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                Mockito.<List<Element>>any());
        verify(cboxRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#add(FullInformation)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAdd3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.get()" because the return value of "com.olegnew.jvcboxv1.repository.CboxRepository.findById(Object)" is null
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.updateById(CboxServiceImpl.java:67)
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.add(CboxServiceImpl.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(null);
        cboxServiceImpl.add(fullInformation);
    }

    /**
     * Method under test: {@link CboxServiceImpl#findCboxByStreetAndHouse(String, String)}
     */
    @Test
    void testFindCboxByStreetAndHouse() {
        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findCboxByStreetAndHouse(Mockito.<String>any(), Mockito.<String>any())).thenReturn(ofResult);
        Optional<Cbox> actualFindCboxByStreetAndHouseResult = cboxServiceImpl.findCboxByStreetAndHouse("Street", "House");
        assertSame(ofResult, actualFindCboxByStreetAndHouseResult);
        assertTrue(actualFindCboxByStreetAndHouseResult.isPresent());
        verify(cboxRepository).findCboxByStreetAndHouse(Mockito.<String>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#findCboxByStreetAndHouse(String, String)}
     */
    @Test
    void testFindCboxByStreetAndHouse2() {
        when(cboxRepository.findCboxByStreetAndHouse(Mockito.<String>any(), Mockito.<String>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.findCboxByStreetAndHouse("Street", "House"));
        verify(cboxRepository).findCboxByStreetAndHouse(Mockito.<String>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#getFullInformation(Long, boolean)}
     */
    @Test
    void testGetFullInformation() {
        when(snmpAgentV1.getTarget(Mockito.<String>any(), Mockito.<List<Element>>any(), Mockito.<String>any(),
                anyBoolean())).thenReturn(new HashMap<>());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        FullInformation actualFullInformation = cboxServiceImpl.getFullInformation(1L, true);
        assertEquals("House", actualFullInformation.getHouse());
        assertEquals("Street", actualFullInformation.getStreet());
        assertTrue(actualFullInformation.getReceivedInformation().isEmpty());
        assertEquals(1L, actualFullInformation.getId().longValue());
        verify(snmpAgentV1).getTarget(Mockito.<String>any(), Mockito.<List<Element>>any(), Mockito.<String>any(),
                anyBoolean());
        verify(cboxRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#getFullInformation(Long, boolean)}
     */
    @Test
    void testGetFullInformation2() {
        when(snmpAgentV1.getTarget(Mockito.<String>any(), Mockito.<List<Element>>any(), Mockito.<String>any(),
                anyBoolean())).thenThrow(new RuntimeException("foo"));

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.getFullInformation(1L, true));
        verify(snmpAgentV1).getTarget(Mockito.<String>any(), Mockito.<List<Element>>any(), Mockito.<String>any(),
                anyBoolean());
        verify(cboxRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#getFullInformation(Long, boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetFullInformation3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.getFullInformation(CboxServiceImpl.java:47)
        //   See https://diff.blue/R013 to resolve this issue.

        when(snmpAgentV1.getTarget(Mockito.<String>any(), Mockito.<List<Element>>any(), Mockito.<String>any(),
                anyBoolean())).thenReturn(new HashMap<>());
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        cboxServiceImpl.getFullInformation(1L, true);
    }

    /**
     * Method under test: {@link CboxServiceImpl#updateById(Long, FullInformation, boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Map.containsKey(Object)" because "that" is null
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.updateById(CboxServiceImpl.java:79)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        cboxServiceImpl.updateById(1L, fullInformation, true);
    }

    /**
     * Method under test: {@link CboxServiceImpl#updateById(Long, FullInformation, boolean)}
     */
    @Test
    void testUpdateById2() {
        doThrow(new RuntimeException("SysIPaddress")).when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.updateById(1L, fullInformation, true));
        verify(snmpAgentV1).setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                Mockito.<List<Element>>any());
        verify(cboxRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#updateById(Long, FullInformation, boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateById3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.get()" because the return value of "com.olegnew.jvcboxv1.repository.CboxRepository.findById(Object)" is null
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.updateById(CboxServiceImpl.java:67)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(null);
        cboxServiceImpl.updateById(1L, fullInformation, true);
    }

    /**
     * Method under test: {@link CboxServiceImpl#updateById(Long, FullInformation, boolean)}
     */
    @Test
    void testUpdateById4() {
        doThrow(new RuntimeException("SysIPaddress")).when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.updateById(1L, fullInformation, false));
        verify(snmpAgentV1).setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                Mockito.<List<Element>>any());
        verify(cboxRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#updateById(Long, FullInformation, boolean)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateById5() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.updateById(CboxServiceImpl.java:65)
        //   See https://diff.blue/R013 to resolve this issue.

        doThrow(new RuntimeException("SysIPaddress")).when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        cboxServiceImpl.updateById(1L, fullInformation, false);
    }

    /**
     * Method under test: {@link CboxServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        doNothing().when(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());
        doNothing().when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        doNothing().when(cboxRepository).delete(Mockito.<Cbox>any());
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        cboxServiceImpl.delete(1L);
        verify(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());
        verify(snmpAgentV1).setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                Mockito.<List<Element>>any());
        verify(cboxRepository).findById(Mockito.<Long>any());
        verify(cboxRepository).delete(Mockito.<Cbox>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#delete(Long)}
     */
    @Test
    void testDelete2() {
        doNothing().when(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());
        doNothing().when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        doThrow(new RuntimeException("SysIPaddress")).when(cboxRepository).delete(Mockito.<Cbox>any());
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.delete(1L));
        verify(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());
        verify(snmpAgentV1).setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                Mockito.<List<Element>>any());
        verify(cboxRepository).findById(Mockito.<Long>any());
        verify(cboxRepository).delete(Mockito.<Cbox>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#delete(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDelete3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl.delete(CboxServiceImpl.java:113)
        //   See https://diff.blue/R013 to resolve this issue.

        doNothing().when(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());
        doNothing().when(snmpAgentV1)
                .setFullInformationOnTheDevice(Mockito.<Cbox>any(), Mockito.<FullInformation>any(),
                        Mockito.<List<Element>>any());
        doNothing().when(cboxRepository).delete(Mockito.<Cbox>any());
        when(cboxRepository.findById(Mockito.<Long>any())).thenReturn(Optional.empty());
        cboxServiceImpl.delete(1L);
    }

    /**
     * Method under test: {@link CboxServiceImpl#rebootDevice(Cbox)}
     */
    @Test
    void testRebootDevice() {
        doNothing().when(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        cboxServiceImpl.rebootDevice(cbox);
        verify(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());
    }

    /**
     * Method under test: {@link CboxServiceImpl#rebootDevice(Cbox)}
     */
    @Test
    void testRebootDevice2() {
        doThrow(new RuntimeException("foo")).when(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());

        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        assertThrows(RuntimeException.class, () -> cboxServiceImpl.rebootDevice(cbox));
        verify(snmpAgentV1).rebootCbox(Mockito.<String>any(), Mockito.<String>any());
    }
}

