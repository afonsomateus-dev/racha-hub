package com.afonsomateus.rachahub_api.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.afonsomateus.rachahub_api.entity.TeamMatch;
import com.afonsomateus.rachahub_api.entity.TeamMatchId;

public interface TeamMatchRepository extends JpaRepository<TeamMatch, TeamMatchId> {

}
