// halaman register, inten dari halaman login
package com.example.sampahku;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editName;
    private EditText editEmail;
    private EditText editPassword;
    private EditText editConfirmPassword;
    private Button btnRegister;
    private Button btnGoogle;
    private Button btnApple;
    private TextView tvLogin;
    private ImageView ivTogglePassword;
    private ImageView ivToggleConfirmPassword;
    private CheckBox cbRemember;

    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // sama seperti di halaman login
        // menyembunyikan action bar ketika sudah sampai ke halaman
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // insialisasi view-view-nya, mirip dgn halaman login
        editName = findViewById(R.id.edt_name);
        editEmail = findViewById(R.id.edt_email);
        editPassword  = findViewById(R.id.edt_password);
        editConfirmPassword = findViewById(R.id.edt_confirm_password);
        btnRegister = findViewById(R.id.btn_register);
        btnGoogle  = findViewById(R.id.btn_google);
        btnApple = findViewById(R.id.btn_apple);
        tvLogin = findViewById(R.id.tv_login);
        ivTogglePassword = findViewById(R.id.iv_toggle_password);
        ivToggleConfirmPassword = findViewById(R.id.iv_toggle_confirm_password);
        cbRemember = findViewById(R.id.cb_remember);

        // setOnClickListener
        btnRegister.setOnClickListener(this);
        btnGoogle.setOnClickListener(this);
        btnApple.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        ivTogglePassword.setOnClickListener(this);
        ivToggleConfirmPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register) {
            handleRegister();

        } else if (v.getId() == R.id.btn_google) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.btn_apple) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.tv_login) {
            // inten untuk kembali ke halaman login (LoginActivity)
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.iv_toggle_password) {
            togglePasswordVisibility();

        } else if (v.getId() == R.id.iv_toggle_confirm_password) {
            toggleConfirmPasswordVisibility();
        }
    }

    // validasi dan proses registrasi akunnya
    private void handleRegister() {
        String name = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String confirmPassword = editConfirmPassword.getText().toString().trim();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(name)) {
            isEmptyFields = true;
            editName.setError(getString(R.string.error_name_empty));
        }

        if (TextUtils.isEmpty(email)) {
            isEmptyFields = true;
            editEmail.setError(getString(R.string.error_email_empty));
        }

        if (TextUtils.isEmpty(password)) {
            isEmptyFields = true;
            editPassword.setError(getString(R.string.error_password_empty));
        }

        if (TextUtils.isEmpty(confirmPassword)) {
            isEmptyFields = true;
            editConfirmPassword.setError(getString(R.string.error_confirm_password_empty));
        }

        if (!isEmptyFields) {
            // untuk mengecek 
            // apakah password dan konfirmasi password sudah cocok cocok
            if (!password.equals(confirmPassword)) {
                editConfirmPassword.setError(getString(R.string.error_password_mismatch));
                return;
            }

            // untuk menghubungkan ke backend ataupun database
            // (untuk nanti saja)
            Toast.makeText(this, getString(R.string.register_success), Toast.LENGTH_SHORT).show();

            // setelah registrasi sudah berhasil
            // maka menggunakan inten untuk kembali ke halaman login
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    // toggle password on/off
    // sama dgn yang ada di halaman login
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

    private void toggleConfirmPasswordVisibility() {
        if (isConfirmPasswordVisible) {
            editConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivToggleConfirmPassword.setImageResource(R.drawable.ic_eye_off);
            isConfirmPasswordVisible = false;
        } else {
            editConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivToggleConfirmPassword.setImageResource(R.drawable.ic_eye_on);
            isConfirmPasswordVisible = true;
        }
        editConfirmPassword.setSelection(editConfirmPassword.getText().length());
    }
}