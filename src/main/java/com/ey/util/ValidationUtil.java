package com.ey.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static final String PASSWD_PATTERN = "^(?=(.*\\d){2})(?=.*[a-zA-z]).{4,8}$";

    public static boolean patternToMatch(String objToEvaluate, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(objToEvaluate)
                .matches();
    }

    public static boolean isValidEmail(String email){

        return patternToMatch(email, EMAIL_PATTERN);
    }

    public static boolean isValidPassword(String passwd){

        return patternToMatch(passwd, PASSWD_PATTERN);
    }
}
