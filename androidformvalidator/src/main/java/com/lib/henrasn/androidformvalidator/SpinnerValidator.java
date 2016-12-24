package com.lib.henrasn.androidformvalidator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by henrasn on 12/20/2016.
 */

public class SpinnerValidator extends MaterialSpinner {

    private boolean required;

    public SpinnerValidator(Context context) {
        super(context);
    }

    public SpinnerValidator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SpinnerValidator, 0, 0);

        try {
            required = typedArray.getBoolean(R.styleable.SpinnerValidator_spinner_required, false);
        } finally {
            typedArray.recycle();
        }
    }

    public SpinnerValidator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isValid() {
        if (required) if (!itemSelectedCheck()) return false;
        return true;
    }

    private boolean itemSelectedCheck() {
        if (getSelectedItemPosition() == 0) {
            return setErrorMessage();
        }
        return true;
    }

    private boolean setErrorMessage() {
        TextView textView;
        textView = (TextView) getSelectedView();
        textView.setText("Please choose one");
        textView.setError("");
        return false;
    }
}
