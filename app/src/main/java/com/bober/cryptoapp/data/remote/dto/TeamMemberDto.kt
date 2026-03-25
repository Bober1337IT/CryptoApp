package com.bober.cryptoapp.data.remote.dto

import com.bober.cryptoapp.domain.model.TeamMember

data class TeamMemberDto(
    val id: String,
    val name: String,
    val position: String
)

fun TeamMemberDto.toTeamMember(): TeamMember{
    return TeamMember(
        id = id,
        name = name,
        position = position
    )
}