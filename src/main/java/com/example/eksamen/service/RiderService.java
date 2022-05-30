package com.example.eksamen.service;

import com.example.eksamen.model.Rider;
import com.example.eksamen.payload.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface RiderService {
  ResponseEntity<ApiResponse> createRider(Rider rider, Integer teamId);

  ResponseEntity<ApiResponse> findRider(Integer riderId);

  ResponseEntity<ApiResponse> findAllRiders(Pageable pageable);

  ResponseEntity<ApiResponse> findAllByTeamId(Integer teamId, Pageable pageable);

  ResponseEntity<ApiResponse> findByNameLike(String name, Pageable pageable);

  ResponseEntity<ApiResponse> findTopByOrderByTotalTimeAsc();

  ResponseEntity<ApiResponse> findTopByAgeLessThanOrderByTotalTimeAsc(Integer age);

  ResponseEntity<ApiResponse> findTopByOrderBySprintPointDesc();

  ResponseEntity<ApiResponse> findTopByOrderByMountainPointDesc();

  ResponseEntity<ApiResponse> findByNameContainsAndTeamTeamId(
      String name, Integer teamId, Pageable pageable);

  ResponseEntity<ApiResponse> updateRider(Integer riderId, Rider rider);

  ResponseEntity<ApiResponse> deleteRider(Integer riderId);
}
