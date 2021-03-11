package com.abouerp.zsc.register.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Abouerp
 */
@Setter
@Getter
@Accessors(chain = true)
@Table
@Entity
public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String mobile;
    @Column(unique = true)
    private String email;
    private String sex;
    private String md5;

    private String description;
    private String nickName;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
    private String createBy;
    private String updateBy;
    @CreationTimestamp
    private Instant createTime;
    @UpdateTimestamp
    private Instant updateTime;
}
