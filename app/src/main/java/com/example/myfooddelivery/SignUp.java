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
    }
    private void Init(){
        regName = findViewById(R.id.reg_name);
        regUserName = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhoneNumber = findViewById(R.id.reg_phone_number);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);
    }
    private boolean validateName(){
        String val = regName.getEditText().getText().toString();
        if (val.isEmpty()){
            regName.setError("Поле не может быть пустым");
        }
        else
        {

        }
    }

    public void onClickReg(View view) {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        // Get all the values
        String name = regName.getEditText().getText().toString();
        String username = regUserName.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNumber = regPhoneNumber.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        UserHelper helper = new UserHelper(name, username, email, phoneNumber, password);
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(username) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(phoneNumber) && !TextUtils.isEmpty(password))
        {
            reference.push().setValue(helper);
            Toast.makeText(this, "Есть пустое поле", Toast.LENGTH_SHORT).show();
        }

        reference.setValue(helper);

    }
}
