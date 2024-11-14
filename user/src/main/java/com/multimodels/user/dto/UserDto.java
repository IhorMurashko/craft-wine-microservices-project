package com.multimodels.user.dto;

import com.multimodels.user.validator.UserFieldConstraints;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record UserDto(


        @NotBlank(message = "Email field can't be blank")
        @Email(regexp = UserFieldConstraints.USER_EMAIL_PATTER_CONSTRAINT,
                message = UserFieldConstraints.USER_EMAIL_PATTERN_EXCEPTION_MESSAGE)
        String email,

        @Size(min = UserFieldConstraints.USER_PASSWORD_MIN_SIZE_CONSTRAINT,
                max = UserFieldConstraints.USER_PASSWORD_MAX_SIZE_CONSTRAINT,
                message = UserFieldConstraints.USER_PASSWORD_SIZE_EXCEPTION_MESSAGE)
        @NotBlank
        String password,

        @Pattern(regexp = UserFieldConstraints.USER_NAME_PATTER_CONSTRAINT,
                message = UserFieldConstraints.USER_FIRSTNAME_PATTERN_EXCEPTION_MESSAGE)
        String firstName,

        @Pattern(regexp = UserFieldConstraints.USER_NAME_PATTER_CONSTRAINT,
                message = UserFieldConstraints.USER_LASTNAME_PATTERN_EXCEPTION_MESSAGE)
        String lastName,

        @Pattern(regexp = UserFieldConstraints.USER_PHONE_NUMBER_PATTER_CONSTRAINT,
                message = UserFieldConstraints.USER_PHONE_NUMBER_EXCEPTION_MESSAGE)
        String phoneNumber
) {
}
