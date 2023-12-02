package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/store/mission")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}")
    public ApiResponse<MissionResponseDTO.ChallengeMissionResponseDTO> challengeMission(@RequestBody MissionRequestDTO.ChallengeMissionDTO request,
                                                                                        @PathVariable Long missionId,
                                                                                        @RequestParam Long memberId) {

        MemberMission memberMission = missionCommandService.challengeMission(memberId, missionId, request);
        return ApiResponse.onSuccess(MissionConverter.toChallengeMissionDTO(memberMission));
    }


}
