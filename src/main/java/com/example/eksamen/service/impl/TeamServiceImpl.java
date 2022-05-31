package com.example.eksamen.service.impl;

import com.example.eksamen.exception.ResourceNotFoundException;
import com.example.eksamen.model.Team;
import com.example.eksamen.payload.ApiResponse;
import com.example.eksamen.repository.TeamRepository;
import com.example.eksamen.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

  @Autowired TeamRepository teamRepository;

  @Override
  public ResponseEntity<ApiResponse> findAllTeams(Pageable pageable) {

    Page<Team> teams = teamRepository.findAll(pageable);

    return new ResponseEntity<>(
        new ApiResponse(true, "Der blev fundet hold", teams),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findTeam(Integer teamId) {

    Team team = teamRepository.findByTeamId(teamId);

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelholdet blev fundet", team), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> createTeam(Team team) {

    Team teamResponse = teamRepository.save(team);

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelholdet blev oprettet", teamResponse), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<ApiResponse> updateTeam(Team teamRequest, Integer teamId) {

    Team team =
        teamRepository
            .findById(teamId)
            .orElseThrow(() -> new ResourceNotFoundException("Cykelholdet blev ikke fundet."));
    team.setName(teamRequest.getName());

    Team teamResponse = teamRepository.save(team);

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelholdet blev opdateret.", teamResponse), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> deleteTeam(Integer teamId) {

    teamRepository.deleteById(teamId);

    return new ResponseEntity<>(new ApiResponse(true, "Cykelholdet blev slettet."), HttpStatus.OK);
  }
}
