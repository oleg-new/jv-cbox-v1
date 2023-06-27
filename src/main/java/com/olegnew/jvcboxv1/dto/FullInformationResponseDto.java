package com.olegnew.jvcboxv1.dto;

import java.util.HashMap;
import lombok.Data;

@Data
public class FullInformationResponseDto {
    private Long id;
    private String street;
    private String house;
    private HashMap<String, String> receivedInformation;
}
