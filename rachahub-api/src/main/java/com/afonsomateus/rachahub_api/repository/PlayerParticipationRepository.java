package com.afonsomateus.rachahub_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afonsomateus.rachahub_api.entity.PlayerParticipation;
import com.afonsomateus.rachahub_api.entity.PlayerParticipationId;

public interface PlayerParticipationRepository extends JpaRepository<PlayerParticipation, PlayerParticipationId> {}
