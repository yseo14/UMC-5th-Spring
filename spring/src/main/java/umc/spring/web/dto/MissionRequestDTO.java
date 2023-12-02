package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.enums.MissionStatus;

public class MissionRequestDTO {

    @Getter
    public static class ChallengeMissionDTO {
        MissionStatus missionStatus;
    }

}
