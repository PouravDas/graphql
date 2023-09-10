package com.test.graphql.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Book {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String title;

  @Column
  private String description;

  @Column
  private int pages;

  @Column
  private double price;
}
