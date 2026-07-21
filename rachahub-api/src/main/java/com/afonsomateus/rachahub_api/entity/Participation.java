package com.afonsomateus.rachahub_api.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
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
@Table(name = "participations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Participation {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	@JoinColumn(
		name = "match_id",
		nullable = false
	)
	private Match match;
	
	@ManyToOne
	@JoinColumn(
		name = "team_id",
		nullable = false
	)
	private Team team;
}
