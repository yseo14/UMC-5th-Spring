package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;

public class ReviewConverter {
    public static ReviewImage toReviewImage(String imageUrl, Review review) {
        return ReviewImage.builder()
                .imageUrl(imageUrl)
                .review(review)
                .build();
    }
}
