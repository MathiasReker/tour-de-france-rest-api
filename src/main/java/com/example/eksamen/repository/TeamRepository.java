package com.example.eksamen.repository;

import com.example.eksamen.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {

  Team findByTeamId(Integer teamId);
}
