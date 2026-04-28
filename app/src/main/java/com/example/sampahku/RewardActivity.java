package com.example.sampahku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RewardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivBack;

    // Bottom nav items
    private LinearLayout navHome;
    private LinearLayout navReward;
    private LinearLayout navQr;
    private LinearLayout navStatistik;
    private LinearLayout navProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Inisialisasi tombol back
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Inisialisasi bottom navigation
        navHome      = findViewById(R.id.nav_home);
        navReward    = findViewById(R.id.nav_reward);
        navQr        = findViewById(R.id.nav_qr);
        navStatistik = findViewById(R.id.nav_statistik);
        navProfil    = findViewById(R.id.nav_profil);

        navHome.setOnClickListener(this);
        navReward.setOnClickListener(this);
        navQr.setOnClickListener(this);
        navStatistik.setOnClickListener(this);
        navProfil.setOnClickListener(this);

        // Set data untuk item-item reward
        setupRewardItems();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nav_home) {
            // Kembali ke MainActivity (Home)
            finish();

        } else if (v.getId() == R.id.nav_reward) {
            // Sudah di Reward
            Toast.makeText(this, "Reward", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.nav_qr) {
            Intent intent = new Intent(RewardActivity.this, QrActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_statistik) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.nav_profil) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set data untuk semua item reward
     * (Karena pakai <include>, kita override datanya di sini)
     */
    private void setupRewardItems() {
        // ITEM HADIAH TERAKHIR - Gopay
        View itemLast = findViewById(R.id.item_last_reward);
        ((TextView) itemLast.findViewById(R.id.tv_reward_name)).setText("Gopay Coins Rp 10.000");
        ((TextView) itemLast.findViewById(R.id.tv_reward_desc)).setText("Tukarkan Voucher di Aplikasi Gopay");
        ((TextView) itemLast.findViewById(R.id.tv_reward_points)).setText("100 Poin");
        ((ImageView) itemLast.findViewById(R.id.iv_reward_logo)).setImageResource(R.drawable.logo_gopay);
        ((TextView) itemLast.findViewById(R.id.btn_tukar)).setText("Tukar Lagi");

        // REKOMENDASI 1 - Gopay
        View item1 = findViewById(R.id.item_reward_1);
        ((TextView) item1.findViewById(R.id.tv_reward_name)).setText("Gopay Coins Rp 10.000");
        ((TextView) item1.findViewById(R.id.tv_reward_desc)).setText("Tukarkan Voucher di Aplikasi Gopay");
        ((TextView) item1.findViewById(R.id.tv_reward_points)).setText("100 Poin");
        ((ImageView) item1.findViewById(R.id.iv_reward_logo)).setImageResource(R.drawable.logo_gopay);

        // REKOMENDASI 2 - Indomaret
        View item2 = findViewById(R.id.item_reward_2);
        ((TextView) item2.findViewById(R.id.tv_reward_name)).setText("Voucher Indomaret Rp 10.000");
        ((TextView) item2.findViewById(R.id.tv_reward_desc)).setText("Tukarkan Voucher di Indomaret Terdekat");
        ((TextView) item2.findViewById(R.id.tv_reward_points)).setText("100 Poin");
        ((ImageView) item2.findViewById(R.id.iv_reward_logo)).setImageResource(R.drawable.logo_indomaret);

        // REKOMENDASI 3 - Alfamart
        View item3 = findViewById(R.id.item_reward_3);
        ((TextView) item3.findViewById(R.id.tv_reward_name)).setText("Voucher Alfamart Rp 10.000");
        ((TextView) item3.findViewById(R.id.tv_reward_desc)).setText("Tukarkan Voucher di Alfamart Terdekat");
        ((TextView) item3.findViewById(R.id.tv_reward_points)).setText("100 Poin");
        ((ImageView) item3.findViewById(R.id.iv_reward_logo)).setImageResource(R.drawable.logo_alfamart);
    }
}