package com.example.eksamen.service.impl;

import com.example.eksamen.exception.ResourceNotFoundException;
import com.example.eksamen.model.Rider;
import com.example.eksamen.model.Team;
import com.example.eksamen.payload.ApiResponse;
import com.example.eksamen.repository.RiderRepository;
import com.example.eksamen.repository.TeamRepository;
import com.example.eksamen.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RiderServiceImpl implements RiderService {

  @Autowired RiderRepository riderRepository;

  @Autowired TeamRepository teamRepository;

  @Override
  public ResponseEntity<ApiResponse> deleteRider(Integer riderId) {

    try {
      riderRepository.deleteById(riderId);

      return new ResponseEntity<>(
          new ApiResponse(Boolean.TRUE, "Cykelrytter med ID %d blev slettet.".formatted(riderId)),
          HttpStatus.OK);
    } catch (Exception err) {
      return new ResponseEntity<>(
          new ApiResponse(
              Boolean.FALSE, "Det lykkedes ikke at slette rytter med ID %d.".formatted(riderId)),
          HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseEntity<ApiResponse> createRider(Rider rider, Integer teamId) {

    Team team = teamRepository.findByTeamId(teamId);

    if (null == team) {
      throw new ResourceNotFoundException(
          "Cykelholdet med ID %d eksisterer ikke.".formatted(teamId));
    }

    rider.setTeam(team);

    Rider newRider = riderRepository.save(rider);

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelrytteren blev oprettet.", newRider), HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<ApiResponse> updateRider(Integer riderId, Rider riderRequest) {

    Rider rider =
        riderRepository
            .findById(riderId)
            .orElseThrow(() -> new ResourceNotFoundException("Cykelrytteren blev ikke fundet."));

    rider.setName(riderRequest.getName());
    rider.setAge(riderRequest.getAge());
    rider.setTotalTime(riderRequest.getTotalTime());
    rider.setMountainPoint(riderRequest.getMountainPoint());
    rider.setSprintPoint(riderRequest.getSprintPoint());
    rider.setNationality(riderRequest.getNationality());

    Rider updatedRider = riderRepository.save(rider);

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelrytteren blev opdateret.", updatedRider), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findAllRiders(Pageable pageable) {

    Page<Rider> riders = riderRepository.findAll(pageable);

    return new ResponseEntity<>(
        new ApiResponse(true, "Listen af cykelryttere blev hentet.", riders), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findByNameLike(String name, Pageable pageable) {

    Page<Rider> riders = riderRepository.findByNameContains(name, pageable);

    if (riders.isEmpty()) {
      return new ResponseEntity<>(
          new ApiResponse(
              false, "Der blev fundet %d cykelryttere.".formatted(riders.getSize()), riders),
          HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(
        new ApiResponse(
            true, "Der blev fundet %d cykelryttere.".formatted(riders.getSize()), riders),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findAllByTeamId(Integer teamId, Pageable pageable) {

    Page<Rider> riders = riderRepository.findAllByTeamTeamId(teamId, pageable);

    return new ResponseEntity<>(
        new ApiResponse(
            true, "Der blev fundet %d cykelryttere.".formatted(riders.getSize()), riders),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findRider(Integer riderId) {

    Rider rider = riderRepository.findByRiderId(riderId);

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelrytteren blev fundet.", rider), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findTopByOrderByTotalTimeAsc() {

    Rider rider = riderRepository.findTopByOrderByTotalTimeAsc();

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelrytteren blev fundet.", rider), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findTopByOrderBySprintPointDesc() {

    Rider rider = riderRepository.findTopByOrderBySprintPointDesc();

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelrytteren blev fundet.", rider), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findTopByOrderByMountainPointDesc() {

    Rider rider = riderRepository.findTopByOrderByMountainPointDesc();

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelrytteren blev fundet.", rider), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findByNameContainsAndTeamTeamId(
      String name, Integer teamId, Pageable pageable) {

    Page<Rider> riders = riderRepository.findByNameContainsAndTeamTeamId(name, teamId, pageable);

    return new ResponseEntity<>(
        new ApiResponse(
            true, "Der blev fundet %d cykelryttere.".formatted(riders.getSize()), riders),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ApiResponse> findTopByAgeLessThanOrderByTotalTimeAsc(Integer age) {

    Rider rider = riderRepository.findTopByAgeLessThanOrderByTotalTimeAsc(age);

    return new ResponseEntity<>(
        new ApiResponse(true, "Cykelrytteren blev fundet.", rider), HttpStatus.OK);
  }
}
