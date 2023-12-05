package umc.spring.domain;


import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.MemberMission;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(nullable = false, length = 50)
    private String content;

    @Column(nullable = false)
    private Integer reward;

    @Column(nullable = false)
    private LocalDateTime dueDate;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    public void setStore(Store store) {
        if (store != null) {
            store.getMissionsList().remove(this);
        }
        this.store = store;
        store.getMissionsList().add(this);
    }
}
