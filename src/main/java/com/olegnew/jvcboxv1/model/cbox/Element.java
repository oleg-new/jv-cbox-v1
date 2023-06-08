package com.olegnew.jvcboxv1.model.cbox;

import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Element {
    //@Schema(description = "")
    private String oid;
    private String name;
    private boolean rewritable;
    private boolean usability;
}
