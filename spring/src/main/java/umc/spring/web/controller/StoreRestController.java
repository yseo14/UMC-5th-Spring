package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.dto.StoreDTO.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/region/{regionId}")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/store")
    public ApiResponse<StoreResponseDTO.saveStoreResultDTO> saveStore(@RequestBody @Valid StoreRequestDTO.StoreDTO request,
                                                                      @PathVariable(name = "regionId") Long regionId) {
        Store store = storeCommandService.saveStore(regionId, request);
        return ApiResponse.onSuccess(StoreConverter.toSaveStoreResultDTO(store));
    }

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                            @ExistStores @PathVariable(name="storeId")  Long storeId,
                                                                            @RequestParam(name="memberId")  Long memberId){
        Review review = storeCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }
}
