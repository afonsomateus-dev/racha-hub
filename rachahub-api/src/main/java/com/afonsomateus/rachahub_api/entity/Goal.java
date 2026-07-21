package com.afonsomateus.rachahub_api.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "goals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Goal {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "player_id",
		nullable = false
	)
	private Player player; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "match_id",
		nullable = false
	)
	private Match match;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "team_id",
		nullable = false
	)
	private Team team;
}
