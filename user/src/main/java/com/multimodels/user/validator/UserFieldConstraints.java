package com.multimodels.user.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserFieldConstraints {

    public static final String USER_EMAIL_PATTER_CONSTRAINT = ".+@.+\\..+";
    public static final String USER_EMAIL_PATTERN_EXCEPTION_MESSAGE = "Email pattern is not correct";

    public static final int USER_PASSWORD_MIN_SIZE_CONSTRAINT = 4;
    public static final int USER_PASSWORD_MAX_SIZE_CONSTRAINT = 35;
    public static final String USER_PASSWORD_SIZE_EXCEPTION_MESSAGE = "Password should be minimum 4 characters and maximum 35";

    public static final String USER_NAME_PATTER_CONSTRAINT = "^\\p{L}{2,}$";
    public static final String USER_FIRSTNAME_PATTERN_EXCEPTION_MESSAGE = "First name should start with a letter and have at least two characters";
    public static final String USER_LASTNAME_PATTERN_EXCEPTION_MESSAGE = "Last name should start with a letter and have at least two characters";


    public static final String USER_PHONE_NUMBER_PATTER_CONSTRAINT = "^\\d{12}$";
    public static final String USER_PHONE_NUMBER_EXCEPTION_MESSAGE = "Phone number should have 12 digits";


}

