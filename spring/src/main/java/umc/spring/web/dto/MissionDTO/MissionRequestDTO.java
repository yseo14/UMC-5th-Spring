package umc.spring.web.dto.MissionDTO;

import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.IsChallenging;

import java.time.LocalDateTime;


public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDTO {
        String content;
        LocalDateTime dueDate;
        Integer reward;
    }


    @Getter
    @Validated
    public static class ChallengeMissionDTO {
        MissionStatus missionStatus;
        Long memberId;
        Long missionId;
    }

}
