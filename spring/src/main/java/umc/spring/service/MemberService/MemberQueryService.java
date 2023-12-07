package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {

    Page<Review> getMyReviewList(Long memberId, Integer page);

    Page<MemberMission> getChallengingMissionList(Long memberId, Integer page);
}
