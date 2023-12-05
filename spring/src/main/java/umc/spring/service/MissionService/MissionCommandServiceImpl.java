package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Validated
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission createMission(Long storeId, MissionRequestDTO.CreateMissionDTO request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(storeId).get();
        mission.setStore(store);
        return missionRepository.save(mission);
    }

    @Override
    public MemberMission challengeMission(MissionRequestDTO.ChallengeMissionDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow();
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow();

        return memberMissionRepository.save(MissionConverter.toMemberMission(request, member, mission));

    }
}
