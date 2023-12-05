package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.IsChallenging;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<IsChallenging, MissionRequestDTO.ChallengeMissionDTO> {

    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDTO.ChallengeMissionDTO value, ConstraintValidatorContext context) {
        Optional<MemberMission> target = missionQueryService.findMemberMission(value.getMemberId(), value.getMissionId());

        if (target.isPresent()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }

}