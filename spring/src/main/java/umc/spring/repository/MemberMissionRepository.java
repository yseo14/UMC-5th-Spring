package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

   Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long MissionId);

   Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);

   @Query("SELECT mm FROM MemberMission mm WHERE mm.missionStatus = 'Progress' AND mm.member = :member")
   Page<MemberMission> findProgressMissionsByMember(@Param("member") Member member,PageRequest pageRequest);

}
