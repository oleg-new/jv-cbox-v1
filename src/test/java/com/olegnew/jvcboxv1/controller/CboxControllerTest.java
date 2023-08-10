package com.olegnew.jvcboxv1.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olegnew.jvcboxv1.dto.CboxResponseDto;
import com.olegnew.jvcboxv1.dto.FullInformationRequestDto;
import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import com.olegnew.jvcboxv1.repository.CboxRepository;
import com.olegnew.jvcboxv1.service.cbox.CboxService;
import com.olegnew.jvcboxv1.service.cbox.impl.CboxServiceImpl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CboxController.class})
@ExtendWith(SpringExtension.class)
class CboxControllerTest {
    @Autowired
    private CboxController cboxController;

    @MockBean
    private CboxService cboxService;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link CboxController#getById(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetById() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.core.Authentication.getAuthorities()" because "authentication" is null
        //       at com.olegnew.jvcboxv1.controller.CboxController.getById(CboxController.java:85)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        CboxServiceImpl cboxService = new CboxServiceImpl(mock(CboxRepository.class));
        (new CboxController(cboxService, new ModelMapper())).getById(1L);
    }

    /**
     * Method under test: {@link CboxController#add(FullInformationRequestDto)}
     */
    @Test
    void testAdd() throws Exception {
        when(cboxService.add(Mockito.<FullInformation>any())).thenReturn(new FullInformation());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(null);

        FullInformationRequestDto fullInformationRequestDto = new FullInformationRequestDto();
        fullInformationRequestDto.setHouse("House");
        fullInformationRequestDto.setReceivedInformation(new HashMap<>());
        fullInformationRequestDto.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(fullInformationRequestDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/cbox/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(cboxController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CboxController#update(String, FullInformationRequestDto)}
     */


    /**
     * Method under test: {@link CboxController#delete(Long)}
     */
    @Test
    void testDelete() throws Exception {
        doNothing().when(cboxService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/cbox/{id}", 1L);
        MockMvcBuilders.standaloneSetup(cboxController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CboxController#delete(Long)}
     */
    @Test
    void testDelete2() throws Exception {
        doNothing().when(cboxService).delete(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/cbox/{id}", 1L);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(cboxController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link CboxController#getAllCbox()}
     */
    @Test
    void testGetAllCbox() throws Exception {
        when(cboxService.getAllCboxs()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/cbox/");
        MockMvcBuilders.standaloneSetup(cboxController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CboxController#getAllCbox()}
     */
    @Test
    void testGetAllCbox2() throws Exception {
        Cbox cbox = new Cbox();
        cbox.setHouse("?");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("?");
        cbox.setStreet("?");

        ArrayList<Cbox> cboxList = new ArrayList<>();
        cboxList.add(cbox);
        when(cboxService.getAllCboxs()).thenReturn(cboxList);

        CboxResponseDto cboxResponseDto = new CboxResponseDto();
        cboxResponseDto.setHouse("House");
        cboxResponseDto.setId(1L);
        cboxResponseDto.setIpAddress("42 Main St");
        cboxResponseDto.setStreet("Street");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CboxResponseDto>>any())).thenReturn(cboxResponseDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/cbox/");
        MockMvcBuilders.standaloneSetup(cboxController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"id\":1,\"street\":\"Street\",\"house\":\"House\",\"ipAddress\":\"42 Main St\"}]"));
    }

    /**
     * Method under test: {@link CboxController#getAllCbox()}
     */
    @Test
    void testGetAllCbox3() throws Exception {
        Cbox cbox = new Cbox();
        cbox.setHouse("?");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("?");
        cbox.setStreet("?");

        Cbox cbox2 = new Cbox();
        cbox2.setHouse("House");
        cbox2.setId(2L);
        cbox2.setIpAddress("17 High St");
        cbox2.setSnmpCommunity("Snmp Community");
        cbox2.setStreet("Street");

        ArrayList<Cbox> cboxList = new ArrayList<>();
        cboxList.add(cbox2);
        cboxList.add(cbox);
        when(cboxService.getAllCboxs()).thenReturn(cboxList);

        CboxResponseDto cboxResponseDto = new CboxResponseDto();
        cboxResponseDto.setHouse("House");
        cboxResponseDto.setId(1L);
        cboxResponseDto.setIpAddress("42 Main St");
        cboxResponseDto.setStreet("Street");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CboxResponseDto>>any())).thenReturn(cboxResponseDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/cbox/");
        MockMvcBuilders.standaloneSetup(cboxController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "[{\"id\":1,\"street\":\"Street\",\"house\":\"House\",\"ipAddress\":\"42 Main St\"},{\"id\":1,\"street\":\"Street\",\"house"
                                        + "\":\"House\",\"ipAddress\":\"42 Main St\"}]"));
    }

    /**
     * Method under test: {@link CboxController#reboot(Long)}
     */
    @Test
    void testReboot() throws Exception {
        Cbox cbox = new Cbox();
        cbox.setHouse("House");
        cbox.setId(1L);
        cbox.setIpAddress("42 Main St");
        cbox.setSnmpCommunity("Snmp Community");
        cbox.setStreet("Street");
        Optional<Cbox> ofResult = Optional.of(cbox);
        doNothing().when(cboxService).rebootDevice(Mockito.<Cbox>any());
        when(cboxService.getById(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/v1/cbox/reboot")
                .contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(1L));
        MockMvcBuilders.standaloneSetup(cboxController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Rebooting"));
    }
}

