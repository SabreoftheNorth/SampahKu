package com.example.sampahku;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String VALID_EMAIL = "rakha@user.com";
    private static final String VALID_PASSWORD = "user123";

    private EditText editEmail;
    private EditText editPassword;
    private Button btnLogin;
    private TextView tvFgtPassword;
    private TextView tvRegister;
    private ImageView ivTogglePassword;
    private ImageView ivGoogle;
    private ImageView ivApple;

    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // hide action bar ketika sudah masuk aplikasi
        // agar rapi
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // inisialisasi view-view yang ada
        editEmail = findViewById(R.id.edt_email);
        editPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        tvFgtPassword = findViewById(R.id.tv_forgot_password);
        tvRegister = findViewById(R.id.tv_register);
        ivTogglePassword = findViewById(R.id.iv_toggle_password);
        ivGoogle = findViewById(R.id.iv_google);
        ivApple = findViewById(R.id.iv_apple);

        // set listener, menggunakan 'setOnClickListener'
        btnLogin.setOnClickListener(this);
        tvFgtPassword.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        ivTogglePassword.setOnClickListener(this);
        ivGoogle.setOnClickListener(this);
        ivApple.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            handleLogin();
        } else if (v.getId() == R.id.iv_google) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.iv_apple) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.tv_forgot_password) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.tv_register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.iv_toggle_password) {
            togglePasswordVisibility();
        }
    }

    // untuk menangani proses login
    // validasi input juga
    private void handleLogin() {
        String email    = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        boolean isEmptyFields = false;
        if (TextUtils.isEmpty(email)) {
            isEmptyFields = true;
            editEmail.setError(getString(R.string.error_email_empty));
        }
        if (TextUtils.isEmpty(password)) {
            isEmptyFields = true;
            editPassword.setError(getString(R.string.error_password_empty));
        }
        if (!isEmptyFields) {
            // Cek kredensial
            if (email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD)) {
                Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, getString(R.string.error_login_invalid), Toast.LENGTH_SHORT).show();
            }
        }
    }

    // toggle password on/off
    // implementasinya sama di halaman register
    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivTogglePassword.setImageResource(R.drawable.ic_eye_off);
            isPasswordVisible = false;
        } else {
            editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivTogglePassword.setImageResource(R.drawable.ic_eye_on);
            isPasswordVisible = true;
        }
        editPassword.setSelection(editPassword.getText().length());
    }
}