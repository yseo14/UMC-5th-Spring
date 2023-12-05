package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.IsChallenging;
import umc.spring.web.dto.MissionDTO.MissionRequestDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/store/mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponseDTO.CreateMissionResponseDTO> createMission(@PathVariable(name = "storeId") Long storeId, @RequestBody MissionRequestDTO.CreateMissionDTO request) {

        Mission mission = missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResultDTO(mission));
    }

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResponseDTO> challengeMission(@IsChallenging @RequestBody MissionRequestDTO.ChallengeMissionDTO request) {

        MemberMission memberMission = missionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionResultDTO(memberMission));
    }
}
