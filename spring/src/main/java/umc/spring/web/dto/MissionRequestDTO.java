package umc.spring.web.dto;

import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.IsChallenging;


public class MissionRequestDTO {

    @Getter
    @IsChallenging
    @Validated
    public static class ChallengeMissionDTO {
        MissionStatus missionStatus;
        Long memberId;
        Long missionId;
    }

}
