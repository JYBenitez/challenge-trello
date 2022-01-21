package com.demo.managment.model;

import com.demo.managment.model.listener.AuditEntity;
import com.demo.managment.model.listener.AuditEntityListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditEntityListener.class})
@Data
@Entity
@Table(name="team_member",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"teammemberid"})})
public class TeamMemberEntity implements AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teammemberid")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastName;
    @Column(name="personalId")
    private String personalId;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "teamid",
            referencedColumnName = "teamid",
            updatable = false,
            insertable = false)
    private TeamEntity team;

    @Column(name="creationDate")
    private LocalDateTime creationDate;
    @Column(name="modificationDate")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;
}