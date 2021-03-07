package com.example.myfooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //Variables
    TextInputLayout regName, regUserName, regEmail, regPhoneNumber, regPassword;
    Button regBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Init();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");
    }

    private void Init() {
        regName = findViewById(R.id.reg_name);
        regUserName = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNumber = findViewById(R.id.reg_phone_number);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);
    }

    private boolean validateName() {
        String val = regName.getEditText().getText().toString();
        if (val.isEmpty()) {
            regName.setError("Поле не может быть пустым");
            return false;
        } else {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String val = regUserName.getEditText().getText().toString();
        String noWhiteSpace = "^[^\\s].+[^\\s]$";
        if (val.isEmpty()) {
            regUserName.setError("Поле не может быть пустым");
            return false;
        } else if (val.length() >= 15) {
            regUserName.setError("Имя пользователя слишком длинное");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            regUserName.setError("Пробелы не допускаются");
            return false;
        } else {
            regUserName.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        if (val.isEmpty()) {
            regEmail.setError("Поле не может быть пустым");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Неверный адрес электронной почты");
            return false;
        } else {
            regEmail.setError(null);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = regPhoneNumber.getEditText().getText().toString();
        if (val.isEmpty()) {
            regPhoneNumber.setError("Поле не может быть пустым");
            return false;
        } else {
            regPhoneNumber.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString();
        String passwordVal ="/^[0-9]+$/";
        if (val.isEmpty()) {
            regPassword.setError("Поле не может быть пустым");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassword.setError("Пароль слишком лёгкий");
            return false;
        } else {
            regPassword.setError(null);
            return true;
        }
    }

    public void onClickReg(View view) {

        if (!validateName() | !validateUsername() | !validateEmail() | !validatePhoneNumber() |  !validatePassword() ) {

        }

        // Get all the values
        String name = regName.getEditText().getText().toString();
        String username = regUserName.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNumber = regPhoneNumber.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        UserHelper helper = new UserHelper(name, username, email, phoneNumber, password);
       /* if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(username) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(phoneNumber) && !TextUtils.isEmpty(password)) {
            reference.push().setValue(helper);
            Toast.makeText(this, "Есть пустое поле", Toast.LENGTH_SHORT).show();
        }

        reference.setValue(helper);*/

    }
}
