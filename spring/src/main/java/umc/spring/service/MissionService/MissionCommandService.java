package umc.spring.service.MissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

public interface MissionCommandService {

    MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDTO request);
}
