package com.afonsomateus.rachahub_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afonsomateus.rachahub_api.entity.Goal;

public interface GoalRepository extends JpaRepository<Goal, UUID> {

}
