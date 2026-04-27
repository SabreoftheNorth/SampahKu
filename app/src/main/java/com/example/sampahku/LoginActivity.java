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

    private EditText editEmail;
    private EditText editPassword;
    private Button btnLogin;
    private Button btnGoogle;
    private Button btnApple;
    private TextView tvFgtPassword;
    private TextView tvRegister;
    private ImageView ivTogglePassword;

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
        btnGoogle = findViewById(R.id.btn_google);
        btnApple = findViewById(R.id.btn_apple);
        tvFgtPassword = findViewById(R.id.tv_forgot_password);
        tvRegister = findViewById(R.id.tv_register);
        ivTogglePassword = findViewById(R.id.iv_toggle_password);

        // set listener, menggunakan 'setOnClickListener'
        btnLogin.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        btnApple.setOnClickListener(this);
        tvFgtPassword.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        ivTogglePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            handleLogin();

        } else if (v.getId() == R.id.btn_google) {
            // TODO: Implementasi login Google
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.btn_apple) {
            // TODO: Implementasi login Apple
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.tv_forgot_password) {
            // TODO: Navigasi ke halaman lupa password
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.tv_register) {
            // menggunakan inten untuk pindah ke halaman Register (secara eksplisit)
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.iv_toggle_password) {
            togglePasswordVisibility();
        }
    }

    // untuk menangani proses login
    // validasi input juga
    private void handleLogin() {
        String email = editEmail.getText().toString().trim();
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
            // TODO: hubungkan ke banckend
            // untuk saat ini, langsung pindah ke MainActivity saja
            Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    // toggle password on/off
    // implementasinya sama di halaman register
    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // menyembunyikan password
            editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivTogglePassword.setImageResource(R.drawable.ic_eye_off);
            isPasswordVisible = false;
        } else {
            // menampilkan passwordnya
            editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivTogglePassword.setImageResource(R.drawable.ic_eye_on);
            isPasswordVisible = true;
        }
        // digunakan untuk memindahkan kursor ke akhir teks
        editPassword.setSelection(editPassword.getText().length());
    }
}