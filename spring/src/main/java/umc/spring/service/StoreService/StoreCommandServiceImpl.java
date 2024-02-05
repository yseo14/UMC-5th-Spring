package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import umc.spring.aws.s3.AmazonS3Manager;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Review;
import umc.spring.domain.ReviewImage;
import umc.spring.domain.Store;
import umc.spring.domain.Uuid;
import umc.spring.repository.*;
import umc.spring.web.dto.StoreDTO.StoreRequestDTO;
import umc.spring.web.dto.StoreDTO.StoreResponseDTO;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final AmazonS3Manager s3Manager;
    private final UuidRepository uuidRepository;

    private final ReviewImageRepository reviewImageRepository;


    @Override
    public Store saveStore(Long regionId, StoreRequestDTO.StoreDTO request) {

        Store store = StoreConverter.toStore(request);
        store.setRegion(regionRepository.findById(regionId).get());
        return storeRepository.save(store);
    }

    @Override
    public Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request, MultipartFile reviewImage) {

        Review review = StoreConverter.toReview(request);

        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());

        String pictureUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(savedUuid), reviewImage);

        review.setStore(storeRepository.findById(storeId).get());
        review.setMember(memberRepository.findById(memberId).get());


        reviewImageRepository.save(ReviewConverter.toReviewImage(pictureUrl,review));
        return reviewRepository.save(review);
    }

    @Override
    public StoreResponseDTO.DeleteReviewImageDTO deleteReviewImage(Long memberId, Long reviewId) throws IOException {

        ReviewImage reviewImage = reviewImageRepository.findByReviewId(reviewId);
        s3Manager.deleteFile(reviewImage.getImageUrl());
        reviewImageRepository.delete(reviewImage);
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new IllegalArgumentException("리뷰가 존재하지 않습니다."));

        return ReviewConverter.toDeleteReviewImageDTO(review);
    }
}
