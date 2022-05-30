package com.example.eksamen.service;

import com.example.eksamen.model.Team;
import com.example.eksamen.payload.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TeamService {

  ResponseEntity<ApiResponse> createTeam(Team team);

  ResponseEntity<ApiResponse> findTeam(Integer teamId);

  ResponseEntity<ApiResponse> findAllTeams(Pageable pageable);

  ResponseEntity<ApiResponse> updateTeam(Team party, Integer teamId);

  ResponseEntity<ApiResponse> deleteTeam(Integer teamId);
}
