package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.CheckPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

@Component
@RequiredArgsConstructor
public class PageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        Integer page = value;
        if (page <= 0) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_VALID.getMessage().toString()).addConstraintViolation();
            return false;
        }

        return true;
    }

//    public static void minusOneToPage(Object obj) throws IllegalAccessException{
//        Class<?> clazz = obj.getClass();
//
//        for (Field field : clazz.getDeclaredFields()) {
//            CheckPage annotation = field.getAnnotation(CheckPage.class);
//            if (annotation != null && field.getType() == Integer.class) {
//                field.setAccessible(true);
//                Integer value = (Integer) field.get(obj);
//                if (value != null) {
//                    field.set(obj, value - 1);
//                }
//            }
//        }
//    }
}
