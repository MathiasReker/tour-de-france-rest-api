package com.example.eksamen.repository;

import com.example.eksamen.model.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Integer> {

  Page<Rider> findAll(Pageable pageable);

  Page<Rider> findByNameContains(String name, Pageable pageable);

  Page<Rider> findAllByTeamTeamId(Integer teamId, Pageable pageable);

  Page<Rider> findByNameContainsAndTeamTeamId(String name, Integer teamId, Pageable pageable);

  Rider findByRiderId(Integer rider);

  Rider findTopByOrderByTotalTimeAsc();

  Rider findTopByAgeLessThanOrderByTotalTimeAsc(Integer age);

  Rider findTopByOrderBySprintPointDesc();

  Rider findTopByOrderByMountainPointDesc();
}
