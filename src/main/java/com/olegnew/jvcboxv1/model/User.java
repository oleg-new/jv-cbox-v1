package com.olegnew.jvcboxv1.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(example = "1")
    private Long id;
    @ApiModelProperty(example = "Mars")
    private String name;
    @ApiModelProperty(example = "very complex password")
    private String password;
    private boolean locked;
    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}

