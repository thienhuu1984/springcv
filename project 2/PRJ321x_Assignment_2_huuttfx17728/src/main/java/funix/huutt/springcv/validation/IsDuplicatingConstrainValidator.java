package funix.huutt.springcv.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class IsDuplicatingConstrainValidator
        implements ConstraintValidator<IsDuplicating, Object> {

    private String value;
    private String valueMatch;

    @Override
    public void initialize(IsDuplicating constraint) {
        this.value = constraint.value();
        this.valueMatch = constraint.fieldMatch();



    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(obj)
                .getPropertyValue(this.value);
        Object fieldValueMatch = new BeanWrapperImpl(obj)
                .getPropertyValue(this.valueMatch);

        if(fieldValue != null) {
            return fieldValue.equals(fieldValueMatch);
        } else
            return fieldValueMatch == null;
    }
}
