package com.demo.managment.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="card_label",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"cardlabelid"})})
public class CardLabelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cardlabelid")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "cardid",
            referencedColumnName = "cardid",
            updatable = false,
            insertable = false)
    private CardEntity card;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "labelid",
            referencedColumnName = "labelid",
            updatable = false,
            insertable = false)
    private LabelEntity label;
}
