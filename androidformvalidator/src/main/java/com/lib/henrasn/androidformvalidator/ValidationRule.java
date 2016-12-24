package com.lib.henrasn.androidformvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by henrasn on 12/17/2016.
 */

//TODO add more rule
public class ValidationRule {
    private static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern emailPattern;
    private Matcher matcher;

    public boolean isEmail(String value) {
        emailPattern = Pattern.compile(EMAIL_PATTERN);
        matcher = emailPattern.matcher(value);
        return matcher.matches();
    }
}
