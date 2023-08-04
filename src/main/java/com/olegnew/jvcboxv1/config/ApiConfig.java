package com.olegnew.jvcboxv1.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API for managing devices \"Cbox\"",
                description = "oleg_new", version = "1.0.0",
                contact = @Contact(
                        name = "Poteleschenko Oleg",
                        email = "mark@struchkov.dev"
                )
        )
)
public class ApiConfig {
}
