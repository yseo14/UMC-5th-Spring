package umc.spring.service.StoreService;

import org.springframework.web.multipart.MultipartFile;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;

public interface StoreCommandService {

    Store saveStore(Long regionId, StoreRequestDTO.StoreDTO request);

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request, MultipartFile reviewImage);
}
