package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Validated
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    @Override
    public MemberMission challengeMission(Long memberId, Long missionId, MissionRequestDTO.ChallengeMissionDTO request) {

        MemberMission memberMission = MissionConverter.toMemberMission(request);

        memberMission.setMission(missionRepository.findById(missionId).get());
        memberMission.setMember(memberRepository.findById(memberId).get());

        return memberMissionRepository.save(memberMission);
    }
}
