package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class MissionConverter {


    public static MissionResponseDTO.ChallengeMissionResponseDTO toChallengeMissionDTO(MemberMission memberMission) {
        return MissionResponseDTO.ChallengeMissionResponseDTO.builder()
                .id(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MissionRequestDTO.ChallengeMissionDTO request, Member member, Mission mission) {
        return MemberMission.builder()
                .missionStatus(request.getMissionStatus())
                .member(member)
                .mission(mission)
                .build();
    }
}
