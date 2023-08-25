package funix.huutt.springcv.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsDuplicatingConstrainValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDuplicating {

    String message() default "Email bạn nhập sai định dạng.";
    String value();
    String fieldMatch();

    @Target({ ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        IsDuplicating[] values();
    }

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
