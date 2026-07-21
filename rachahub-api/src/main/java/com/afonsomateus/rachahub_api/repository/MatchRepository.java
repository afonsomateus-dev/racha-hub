package com.afonsomateus.rachahub_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afonsomateus.rachahub_api.entity.Match;

public interface MatchRepository extends JpaRepository<Match, UUID> {}
