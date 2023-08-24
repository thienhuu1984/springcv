package funix.huutt.springcv.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsNumberConstraintValidator
        implements ConstraintValidator<IsNumber, String> {


    @Override
    public void initialize(IsNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean isValid = true;

        try {
            Double.parseDouble(value);
        } catch (Exception e) {
            isValid =  false;
        }
        return isValid;
    }
}
