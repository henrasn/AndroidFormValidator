package com.lib.henrasn.androidformvalidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henrasn on 12/21/2016.
 */

public class Validator {

    private Object[] fields;
    private List<Boolean> validationResult;

    private Validator(ValidatorBuilder builder) {
        this.fields = builder.fields;
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
        }
        return !validationResult.contains(false);
    }

    public static class ValidatorBuilder {
        Object[] fields;

        public ValidatorBuilder addField(Object[] fields) {
            this.fields = fields;
            return this;
        }

        public Validator build() {
            return new Validator(this);
        }
    }
}
