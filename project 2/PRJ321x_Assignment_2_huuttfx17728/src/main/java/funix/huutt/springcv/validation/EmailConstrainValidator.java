package funix.huutt.springcv.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailConstrainValidator
        implements ConstraintValidator<EmailCheck, String> {

    private String emailValid;

    @Override
    public void initialize(EmailCheck constraintAnnotation) {

        emailValid = "@";

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean result;

        if(value != null)
            result =  value.contains(emailValid);
        else
            result = true;



        return result;
    }
}
