package com.afonsomateus.rachahub_api.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_participation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerParticipation {
	@EmbeddedId
	private PlayerParticipationId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    private Player player;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("participationId")
    @JoinColumn(name = "participation_id")
	private Participation participation;
}
