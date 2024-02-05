package umc.spring.web.dto.StoreDTO;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {

    @Getter
    public static class StoreDTO {

        @NotBlank
        String name;
        
        @NotBlank
        String address;
    }

    @Getter
    @Builder
    public static class ReviewDTO{

        @NotBlank
        String title;

        @NotBlank
        String body;

        @NotNull
        Float score;

        MultipartFile reviewPicture;
    }


}
