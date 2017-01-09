# Android Form Validator

###### Validation for EditText and Spinner for any rule
>Spinner was using [material spinner](https://github.com/ganfra/MaterialSpinner)

###### Gradle
<pre><code> compile 'com.lib.henrasn:androidformvalidator:0.0.1'</code></pre>

Adding view to xml layout
```xml
<com.lib.henrasn.androidformvalidator.EditTextValidator
  app:error_message="this is message error"
  app:required="true" />
```

add view to array of Object
<pre><code>Obejct[] viewObjects = {view1, view2, view3, ...}</code></pre>

execute validation
<pre><code>boolean isvalid = new Validator(viewObjects).validate();</code></pre>
