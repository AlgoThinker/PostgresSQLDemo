package com.postgresdemo.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class Product {

    @Id
    private int id;
    private String name;
    @Column(name="description")
    private String desc;
    private Double price;

}
