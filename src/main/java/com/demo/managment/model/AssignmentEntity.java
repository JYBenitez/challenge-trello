package com.demo.managment.model;

import com.demo.managment.model.listener.AuditEntity;
import com.demo.managment.model.listener.AuditEntityListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditEntityListener.class})
@Data
@Entity
@Table(name="assignment",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"assignmentid"})})
public class AssignmentEntity implements AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="assignmentid")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "teammemberid",
            referencedColumnName = "teammemberid",
            updatable = false,
            insertable = false)
    private TeamMemberEntity teamMember;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cardid",
            referencedColumnName = "cardid",
            updatable = false,
            insertable = false)
    private CardEntity card;
    @Column(name="startDate")
    private LocalDate startDate;
    @Column(name="dueDate")
    private LocalDate dueDate;

    @Column(name="creationDate")
    private LocalDateTime creationDate;
    @Column(name="modificationDate")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;

}
