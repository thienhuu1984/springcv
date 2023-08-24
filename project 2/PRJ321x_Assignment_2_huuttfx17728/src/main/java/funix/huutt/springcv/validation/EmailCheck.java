package funix.huutt.springcv.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailConstrainValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailCheck {

    public String message() default "Email bạn nhập sai định dạng.";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
