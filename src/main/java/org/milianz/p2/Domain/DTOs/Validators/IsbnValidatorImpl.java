package org.milianz.p2.Domain.DTOs.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IsbnValidatorImpl implements ConstraintValidator<ValidIsbn, String> {


    private static final Pattern ISBN_PATTERN = Pattern.compile(
            "^978-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1}$"
    );

    @Override
    public void initialize(ValidIsbn constraintAnnotation) {

    }

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext context) {
        if (isbn == null || isbn.trim().isEmpty()) {
            return false;
        }

        if (!ISBN_PATTERN.matcher(isbn).matches()) {
            return false;
        }

        return isValidCheckDigit(isbn);
    }


    private boolean isValidCheckDigit(String isbn) {
        try {
            String cleanIsbn = isbn.replaceAll("-", "");

            if (cleanIsbn.length() != 13) {
                return false;
            }

            int sum = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Character.getNumericValue(cleanIsbn.charAt(i));
                if (digit < 0 || digit > 9) {
                    return false;
                }
                sum += digit * (i % 2 == 0 ? 1 : 3);
            }


            int remainder = sum % 10;
            int checkDigit = remainder == 0 ? 0 : 10 - remainder;


            int lastDigit = Character.getNumericValue(cleanIsbn.charAt(12));

            return checkDigit == lastDigit;

        } catch (Exception e) {
            return false;
        }
    }
}