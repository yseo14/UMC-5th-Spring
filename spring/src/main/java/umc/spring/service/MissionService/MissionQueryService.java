package umc.spring.service.MissionService;

import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MissionQueryService {

    Optional<MemberMission> findMemberMission(Long memberId, Long MissionId);
}
