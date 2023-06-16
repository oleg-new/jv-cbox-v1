package com.olegnew.jvcboxv1.controller;

import com.olegnew.jvcboxv1.dto.CboxResponseDto;
import com.olegnew.jvcboxv1.dto.FullInformationDto;
import com.olegnew.jvcboxv1.model.cbox.Cbox;
import com.olegnew.jvcboxv1.service.cbox.CboxService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public FullInformationDto getById(@PathVariable String id) {
        return modelMapper.map(cboxService.getFullInformation(id), FullInformationDto.class);
    }
}
