package com.example.eksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Integer teamId;

  @Column(unique = true)
  private String name;

  @JsonBackReference
  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Rider> riders;
}
