package com.olegnew.jvcboxv1.controller;

import com.olegnew.jvcboxv1.model.cbox.Cbox;
import lombok.RequiredArgsConstructor;
import java.util.Collections;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cbox")
@RequiredArgsConstructor
public class CboxController {
    private final ModelMapper modelMapper;
    @GetMapping("/")
    public List<Cbox> getAllCbox() {
        return Collections.EMPTY_LIST;
    }
}
