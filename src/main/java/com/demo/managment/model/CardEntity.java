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

        TASK("TASK"),
        BUG("BUG"),
        ISSUE("ISUUE");

        private final String val;

        Type(String val) {
            this.val = val;
        }

        public Type getByName(String name){
            return Type.valueOf(name.toUpperCase());
        }

        public String getVal() {
            return val;
        }

        @Override
        public String toString() {
            return val;
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

    @Column(name="labels")
    private String labels;

    @Column(name="list")
    private String list;

    @Column(name= "creation_date")
    private LocalDateTime creationDate;
    @Column(name= "modification_date")
    private LocalDateTime modificationDate;
    @Column(name="user")
    private String user;
}