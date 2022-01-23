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
    @ManyToOne()
    @JoinColumn(name = "teammemberid")
    private TeamMemberEntity teamMember;
    @ManyToOne
    @JoinColumn(name = "cardid")
    private CardEntity card;
    @Column(name= "start_date")
    private LocalDate startDate;
    @Column(name= "due_date")
    private LocalDate dueDate;

    @Column(name= "creation_date")
    private LocalDateTime creationDate;
    @Column(name= "modification_date")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;

}
