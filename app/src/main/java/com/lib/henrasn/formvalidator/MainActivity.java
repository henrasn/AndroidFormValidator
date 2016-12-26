package com.lib.henrasn.formvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.lib.henrasn.androidformvalidator.EditTextValidator;
import com.lib.henrasn.androidformvalidator.SpinnerValidator;
import com.lib.henrasn.androidformvalidator.Validator;

public class MainActivity extends AppCompatActivity {

    EditTextValidator empty;
    EditTextValidator email;
    EditTextValidator min;
    EditTextValidator max;
    String[] value = {"a", "a", "a", "a", "a", "a", "a", "a"};
    SpinnerValidator spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        min = (EditTextValidator) findViewById(R.id.min);
        email = (EditTextValidator) findViewById(R.id.email);
        empty = (EditTextValidator) findViewById(R.id.empty);
        max = (EditTextValidator) findViewById(R.id.max);
        spinner = (SpinnerValidator) findViewById(R.id.spinner);
        Button button = (Button) findViewById(R.id.test_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, value);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Object[] objects = {empty,email,spinner};
                boolean b = new Validator(objects).validate();
                if (b){

                }
            }
        });
    }
}
