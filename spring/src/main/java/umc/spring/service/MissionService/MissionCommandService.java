package umc.spring.service.MissionService;

import org.springframework.validation.annotation.Validated;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.validation.annotation.IsChallenging;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDTO request);
}
