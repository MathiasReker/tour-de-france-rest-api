package com.example.eksamen.service.impl;

import com.example.eksamen.model.Team;
import com.example.eksamen.repository.TeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PartyServiceImplTest {

  @Autowired
  TeamRepository teamRepository;

  @Test
  void testIfObjectCanBeMappedFromDatabase() {

    // Arrange
    String name = "ALAPHILIPPE Julian"; // TODO
    Team team = new Team();
    team.setName(name);

    // Act
    Team newTeam = teamRepository.save(team);

    // Assert
    Assertions.assertEquals(newTeam.getName(), name);

    // Teardown
    teamRepository.delete(newTeam);
  }

  @Test
  void testIfTeamIsSavedInTheDatabase() {

    // Arrange
    List<Team> teams = teamRepository.findAll();
    Team team = new Team();
    team.setName("TEST123"); // TODO

    // Act
    teamRepository.save(team);

    // Assert
    List<Team> newTeam = teamRepository.findAll();
    Assertions.assertEquals(1, newTeam.size() - teams.size());

    // Teardown
    teamRepository.delete(team);
  }
}
