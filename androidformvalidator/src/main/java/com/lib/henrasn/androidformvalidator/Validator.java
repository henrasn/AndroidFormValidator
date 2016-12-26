package com.lib.henrasn.androidformvalidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henrasn on 12/21/2016.
 */

public class Validator {

    private Object[] fields;
    private List<Boolean> validationResult;

    public Validator(Object[] fields) {
        this.fields = fields;
        this.validationResult = new ArrayList<>();
    }

    public boolean validate() {
        if (fields.length > 0) {
            for (Object view : fields) {
                if (view instanceof EditTextValidator) {
                    validationResult.add(((EditTextValidator) view).isValid());
                } else if (view instanceof SpinnerValidator) {
                    validationResult.add(((SpinnerValidator) view).isValid());
                }
            }
        }else{
            return false;
        }
        return !validationResult.contains(false);
    }
}
