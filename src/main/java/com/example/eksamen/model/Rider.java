package com.example.eksamen.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Rider {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Integer riderId;

  private String name;

  private int totalTime;

  private int mountainPoint;

  private int sprintPoint;

  private int age;

  private String nationality;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;
}
