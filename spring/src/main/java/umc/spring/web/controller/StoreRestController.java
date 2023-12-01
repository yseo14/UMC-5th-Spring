package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.MemberService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("region/{regionId}/store")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDTO.saveResultDTO> save(@RequestBody @Valid StoreRequestDTO.saveDto request,
                                                            @PathVariable(name = "regionId") Long regionId) {
        Store store = storeCommandService.saveStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toSaveResultDTO(store));
    }
}
