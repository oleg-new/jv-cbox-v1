package com.olegnew.jvcboxv1.dto;

import java.util.HashMap;
import lombok.Data;

@Data
public class FullInformationRequestDto {
    private String street;
    private String house;
    private HashMap<String, String> receivedInformation;
}
