package com.demo.managment.model;

import com.demo.managment.model.listener.AuditEntity;
import com.demo.managment.model.listener.AuditEntityListener;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(value = {AuditEntityListener.class})
@Data
@Entity
@Table(name="card",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"cardid"})})
public class CardEntity implements AuditEntity {
    public CardEntity() {
    }

    public enum Type {

        TASK("T"),
        BUG("B"),
        ISSUE("I");

        public final String val;

        private Type(String val) {
            this.val = val;
        }

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cardid")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private CardEntity.Type type;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cardid",
            referencedColumnName = "cardid",
            updatable = false,
            insertable = false)
    private List<CardLabelEntity> labels;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cardid")
    private AssignmentEntity assignment;

    @Column(name="creationDate")
    private LocalDateTime creationDate;
    @Column(name="modificationDate")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;
}