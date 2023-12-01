package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    @Override
    public Store saveStore(Long regionId, StoreRequestDTO.saveDto request) {

        Store store = StoreConverter.toStore(request);
        store.setRegion(regionRepository.findById(regionId).get());
        return storeRepository.save(store);
    }
}
