package com.demo.managment.model;

import com.demo.managment.model.listener.AuditEntity;
import com.demo.managment.model.listener.AuditEntityListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditEntityListener.class})
@Data
@Entity
@Table(name="flow_state",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"flowstateid"})})
public class FlowStateEntity implements AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="flowstateid")
    private Integer id;
    @Column(name="description")
    private String description;

    @Column(name="creationDate")
    private LocalDateTime creationDate;
    @Column(name="modificationDate")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;

}
