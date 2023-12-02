package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.IsChallenging;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<IsChallenging, MemberMission> {

    private final MissionQueryService missionQueryService;


    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMission value, ConstraintValidatorContext context) {
//        Optional<Store> target = storeQueryService.findStore(value);    //optional: null이 올 수 있는 값을 감싸는 wrapper 클래스(NPE 방지)
        Long memberId = value.getMember().getId();
        Long missionId = value.getMission().getId();

        Optional<MemberMission> target = missionQueryService.findMemberMission(memberId, missionId);

        if (!target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}