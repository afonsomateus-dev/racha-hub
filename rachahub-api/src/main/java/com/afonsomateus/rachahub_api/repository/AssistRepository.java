package com.afonsomateus.rachahub_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afonsomateus.rachahub_api.entity.Assist;

public interface AssistRepository extends JpaRepository<Assist, UUID> {}
