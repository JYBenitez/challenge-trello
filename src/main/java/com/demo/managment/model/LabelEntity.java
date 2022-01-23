package com.demo.managment.model;

import com.demo.managment.model.listener.AuditEntity;
import com.demo.managment.model.listener.AuditEntityListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditEntityListener.class})
@Data
@Entity
@Table(name="label",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"labelid"})})
public class LabelEntity implements AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="labelid")
    private Integer id;
    @Column(name="description")
    private String description;

    @Column(name= "creation_date")
    private LocalDateTime creationDate;
    @Column(name= "modification_date")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;

}
