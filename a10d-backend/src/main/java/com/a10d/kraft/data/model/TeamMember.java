package com.a10d.kraft.data.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class TeamMember extends DateAudit {

	@EmbeddedId
	private TeamMemberId id;
}
