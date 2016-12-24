package com.lib.henrasn.androidformvalidator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henrasn on 12/17/2016.
 */

public class EditTextValidator extends EditText {

//    private static final String TAG = Validator.class.getSimpleName();

    //TODO add more variable
    private boolean required;
    private boolean email;
    private int minLength;
    private int maxLength;
    private String errorMessage;
    private Context context;
    private List<Object> validationItem = new ArrayList<>();
    private TypedArray typedArray;

    public EditTextValidator(Context context) {
        super(context);
    }

    public EditTextValidator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.EditTextValidator, 0, 0);

        //TODO add more attr
        try {
            required = typedArray.getBoolean(R.styleable.EditTextValidator_required, false);
            email = typedArray.getBoolean(R.styleable.EditTextValidator_email_validate, false);
            minLength = typedArray.getInt(R.styleable.EditTextValidator_min_length_validate, -1);
            maxLength = typedArray.getInt(R.styleable.EditTextValidator_max_length_validate, -1);
            errorMessage = typedArray.getString(R.styleable.EditTextValidator_error_message);
        } finally {
            typedArray.recycle();
        }
    }

    public EditTextValidator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // TODO add more checking and checking method (if needed)
    public boolean isValid() {
        if (email) if (!checkEmail()) return false;
        if (required) if (!emptyCheck()) return false;
        if (minLength > -1) if (!minLengthCheck()) return false;
        if (maxLength > -1) if (!maxLengthCheck()) return false;
        return true;
    }

    private boolean maxLengthCheck() {
        if (getText().toString().length() <= maxLength) {
            return true;
        } else {
            return setErrorMessage("must be at less " + maxLength + " characters");
        }
    }

    private boolean minLengthCheck() {
        if (getText().toString().length() >= minLength) {
            return true;
        } else {
            return setErrorMessage("must be at least " + minLength + " characters");
        }
    }

    private boolean emptyCheck() {
        if (getText().toString().isEmpty()) {
            return setErrorMessage(getContext().getString(R.string.is_required));
        } else {
            return true;
        }
    }

    private boolean checkEmail() {
        if (new ValidationRule().isEmail(getText().toString())) {
            return true;
        } else {
            return setErrorMessage(getContext().getString(R.string.email_not_valid));
        }
    }

    private boolean setErrorMessage(String message) {
        if (errorMessage == null) {
            String prefixField = "";
            try {
                prefixField = getHint().toString();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } finally {
                setError(prefixField + message);
            }
            return false;
        }
        setError(errorMessage);
        return false;
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }
}
