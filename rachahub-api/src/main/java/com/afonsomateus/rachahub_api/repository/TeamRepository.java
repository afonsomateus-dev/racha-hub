package com.afonsomateus.rachahub_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afonsomateus.rachahub_api.entity.Team;

public interface TeamRepository extends JpaRepository<Team, UUID> {

}
