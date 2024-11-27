package com.a10d.kraft.data.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TeamMember extends DateAudit {

	@EmbeddedId
	private TeamMemberId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("teamId")
	private Team team;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private User user;
	@Enumerated(EnumType.STRING)
	private TeamRole teamRole;
	
	public TeamMember(User user,Team team,TeamRole teamRole) {
		this.user = user;
		this.team = team;
		this.teamRole = teamRole;
		this.id = new TeamMemberId(team.getId(),user.getId());
	}
}
