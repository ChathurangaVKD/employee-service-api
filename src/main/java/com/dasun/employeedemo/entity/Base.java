package com.dasun.employeedemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {

    @Transient
    private static final long serialVersionUID = -1L;

    @ApiModelProperty(required = false, hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @JsonIgnore
    @ApiModelProperty(required = false, hidden = true)
    @Column(name = "MODIFIED_ON")
    @LastModifiedDate
    Date modifiedOn;

    @JsonIgnore
    @ApiModelProperty(required = false, hidden = true)
    @Column(name = "CREATED_ON")
    @CreatedDate
    Date createdOn;

    @JsonIgnore
    @ApiModelProperty(required = false, hidden = true)
    @Column(name = "VERSION")
    @Version
    Long version;
}
