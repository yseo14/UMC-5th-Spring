package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    @Override
    public Optional<MemberMission> findMemberMission(Long memberId, Long MissionId) {

        return memberMissionRepository.findByMemberIdAndMissionId(memberId, MissionId);
    }

}
