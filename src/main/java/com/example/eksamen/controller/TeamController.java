package com.example.eksamen.controller;

import com.example.eksamen.model.Rider;
import com.example.eksamen.model.Team;
import com.example.eksamen.payload.ApiResponse;
import com.example.eksamen.service.RiderService;
import com.example.eksamen.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/teams")
public class TeamController {

  @Autowired TeamService teamService;

  @Autowired RiderService riderService;

  @GetMapping()
  public ResponseEntity<ApiResponse> findAllRiders(Pageable pageable) {

    return teamService.findAllTeams(pageable);
  }

  @PostMapping("/{teamId}/riders")
  public ResponseEntity<ApiResponse> createRider(
      @RequestBody Rider rider, @PathVariable("teamId") Integer teamId) {

    return riderService.createRider(rider, teamId);
  }

  @GetMapping("/{teamId}")
  public ResponseEntity<ApiResponse> findTeam(@PathVariable("teamId") Integer riderId) {

    return teamService.findTeam(riderId);
  }

  @PostMapping()
  public ResponseEntity<ApiResponse> createRider(@RequestBody Team team) {
    return teamService.createTeam(team);
  }

  @PutMapping("/{teamId}")
  public ResponseEntity<ApiResponse> editTeam(
      @RequestBody Team team, @PathVariable("teamId") Integer teamId) {

    return teamService.updateTeam(team, teamId);
  }

  @DeleteMapping("/{teamId}")
  public ResponseEntity<ApiResponse> deleteTeam(@PathVariable("teamId") Integer teamId) {

    return teamService.deleteTeam(teamId);
  }
}
