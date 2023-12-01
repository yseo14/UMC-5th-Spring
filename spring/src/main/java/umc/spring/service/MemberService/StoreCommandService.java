package umc.spring.service.MemberService;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store saveStore(Long regionId, StoreRequestDTO.saveDto request);
}
