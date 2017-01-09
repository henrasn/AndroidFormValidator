# Android Form Validator

###### Validation for EditText and Spinner for any rule
>Spinner was using [material spinner](https://github.com/ganfra/MaterialSpinner)

###### Gradle
> compile 'com.lib.henrasn:androidformvalidator:0.0.1'

Adding view to xml layout
><com.lib.henrasn.androidformvalidator.EditTextValidator
>        app:error_message="this is message error"
>        app:required="true" />

add view to array of Object
>Obejct[] viewObject = {view1, view2, view3, ...}

execute validation
>boolean isvalid = new Validator(objects).validate();
