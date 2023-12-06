package umc.spring.web.dto.StoreDTO;

import lombok.Getter;

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
    public static class ReviewDTO{

        @NotBlank
        String title;

        @NotBlank
        String body;

        @NotNull
        Float score;
    }


}
