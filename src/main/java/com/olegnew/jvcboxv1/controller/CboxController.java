package com.olegnew.jvcboxv1.controller;

import com.olegnew.jvcboxv1.dto.CboxResponseDto;
import com.olegnew.jvcboxv1.dto.FullInformationRequestDto;
import com.olegnew.jvcboxv1.dto.FullInformationResponseDto;
import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.model.cbox.FullInformation;
import com.olegnew.jvcboxv1.service.cbox.CboxService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cbox")
@RequiredArgsConstructor
public class CboxController {
    private final CboxService cboxService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public List<CboxResponseDto> getAllCbox() {
        List<Cbox> cboxes = cboxService.getAllCboxs();
        List<CboxResponseDto> cboxResponseDtoList = cboxes.stream()
                .map(u -> modelMapper.map(u, CboxResponseDto.class))
                .collect(Collectors.toList());
        return cboxResponseDtoList;
    }

    @GetMapping("/{id}")
    public FullInformationResponseDto getById(@PathVariable String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // only the OERATOR can get information about the "community"
        boolean hasOperatorRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_OPERATOR"));
        System.out.println(hasOperatorRole);
        return modelMapper.map(cboxService.getFullInformation(Long.parseLong(id), hasOperatorRole),
                FullInformationResponseDto.class);
    }

    @PostMapping("/add")
    public FullInformationResponseDto add(@RequestBody FullInformationRequestDto
                                                      fullInformationRequestDto) {
        FullInformation fullInformation = modelMapper.map(fullInformationRequestDto,
                FullInformation.class);
        return modelMapper.map(cboxService.add(fullInformation),FullInformationResponseDto.class);
    }

    @PostMapping("/reboot")
    public String reboot(@RequestBody String id) {
        Cbox cbox = cboxService.getById(id).get();
        cboxService.rebootDevice(cbox);
        return "Rebooting";
    }

    @PatchMapping("/update/{id}")
    public FullInformationResponseDto update(@Valid @PathVariable String id,
                                             @RequestBody FullInformationRequestDto
                                                     fullInformationRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // only the OERATOR can get information about the "community"
        boolean hasOperatorRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_OPERATOR"));
        cboxService.updateById(Long.parseLong(id), modelMapper.map(fullInformationRequestDto,
                FullInformation.class), false);
        return modelMapper.map(cboxService.getFullInformation(Long.parseLong(id), hasOperatorRole),
                FullInformationResponseDto.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cboxService.delete(id);
    }
}
