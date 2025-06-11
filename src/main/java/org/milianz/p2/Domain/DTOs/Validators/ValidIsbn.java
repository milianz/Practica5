package org.milianz.p2.Domain.DTOs.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsbnValidatorImpl.class)
@Documented
public @interface ValidIsbn {
    String message() default "ISBN-13 inválido. Debe tener formato 978-X-XXXXXX-XXXXXX-X y dígito de control válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}