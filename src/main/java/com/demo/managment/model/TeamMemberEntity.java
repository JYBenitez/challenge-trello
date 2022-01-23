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
    @Column(name= "last_name")
    private String lastName;
    @Column(name= "personal_id")
    private String personalId;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "teamid",
            referencedColumnName = "teamid",
            updatable = true,
            insertable = true)
    private TeamEntity team;

    @Column(name= "creation_date")
    private LocalDateTime creationDate;
    @Column(name= "modification_date")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;
}