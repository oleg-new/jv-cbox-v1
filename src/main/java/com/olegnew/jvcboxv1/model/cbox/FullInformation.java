package com.olegnew.jvcboxv1.model.cbox;

import java.util.HashMap;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FullInformation {
    private Long id;
    private String street;
    private String house;
    private HashMap<String, String> receivedInformation;
}
