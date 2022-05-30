package com.example.eksamen.controller;

import com.example.eksamen.exception.ResourceNotFoundException;
import com.example.eksamen.model.Rider;
import com.example.eksamen.payload.ApiResponse;
import com.example.eksamen.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/riders")
public class RiderController {

  @Autowired private RiderService riderService;

  @GetMapping()
  public ResponseEntity<ApiResponse> findAllRiders(
      @RequestParam(required = false, defaultValue = "") String search,
      @RequestParam(required = false) Integer teamId,
      Pageable pageable) {

    if (null == teamId) {
      return riderService.findByNameLike(search, pageable);
    }

    return riderService.findByNameContainsAndTeamTeamId(search, teamId, pageable);
  }

  @GetMapping("/jerseys/{jerseyId}")
  public ResponseEntity<ApiResponse> findRiderByJersey(@PathVariable Integer jerseyId) {

    return switch (jerseyId) {
      case 1 -> riderService.findTopByOrderByTotalTimeAsc(); // yellow
      case 2 -> riderService.findTopByAgeLessThanOrderByTotalTimeAsc(26); // white
      case 3 -> riderService.findTopByOrderBySprintPointDesc(); // green
      case 4 -> riderService.findTopByOrderByMountainPointDesc(); // polka dot

      default -> throw new ResourceNotFoundException("Der blev ikke fundet nogen rytter.");
    };
  }

  @GetMapping("/{riderId}")
  public ResponseEntity<ApiResponse> findRider(@PathVariable("riderId") Integer riderId) {

    return riderService.findRider(riderId);
  }

  @DeleteMapping("/{riderId}")
  public ResponseEntity<ApiResponse> deleteRider(@PathVariable(name = "riderId") Integer riderId) {

    return riderService.deleteRider(riderId);
  }

  @PutMapping("/{riderId}")
  public ResponseEntity<ApiResponse> updateRider(
      @PathVariable(name = "riderId") Integer riderId, @RequestBody Rider rider) {

    return riderService.updateRider(riderId, rider);
  }
}
