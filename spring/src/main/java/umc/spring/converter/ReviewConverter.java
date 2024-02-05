package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.web.dto.StoreDTO.StoreResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewImage toReviewImage(String imageUrl, Review review) {
        return ReviewImage.builder()
                .imageUrl(imageUrl)
                .review(review)
                .build();
    }

    public static StoreResponseDTO.DeleteReviewImageDTO toDeleteReviewImageDTO(Review review) {
        return StoreResponseDTO.DeleteReviewImageDTO.builder()
                .reviewId(review.getId())
                .deletedAt(LocalDateTime.now())
                .build();
    }

}
