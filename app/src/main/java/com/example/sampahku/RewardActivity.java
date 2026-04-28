package com.example.sampahku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Typeface; // apa perlu ya?

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri; //agar bisa intent implicit

public class RewardActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivBack;

    // list navbar isinya
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

        // inisialisasi tombol back
        // masih bermasalah sih...
        // NVM.. FIXED!
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // inisialisasi bottom navigation bar
        navHome = findViewById(R.id.nav_home);
        navReward = findViewById(R.id.nav_reward);
        navQr = findViewById(R.id.nav_qr);
        navStatistik = findViewById(R.id.nav_statistik);
        navProfil = findViewById(R.id.nav_profil);

        navHome.setOnClickListener(this);
        navReward.setOnClickListener(this);
        navQr.setOnClickListener(this);
        navStatistik.setOnClickListener(this);
        navProfil.setOnClickListener(this);

        // set data untuk item-item rewardnya
        setupRewardItems();
        setActiveNav(); // untuk navbar ganti warna ketika di halaman reward
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nav_home) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_reward) {
            // sudah di Reward, jadi ya...
            Toast.makeText(this, "Reward", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.nav_qr) {
            startActivity(new Intent(RewardActivity.this, QrActivity.class));

        } else if (v.getId() == R.id.nav_statistik) {
            startActivity(new Intent(RewardActivity.this, StatistikActivity.class));

        } else if (v.getId() == R.id.nav_profil) {
            startActivity(new Intent(RewardActivity.this, ProfilActivity.class));
        }
    }

    // ini utk melakukan set data untuk semua item reward
    // (tapi karena udh pakai <include>, kita override datanya di sini)
    private void setupRewardItems() {
        // ITEM HADIAH TERAKHIR - Gopay
        View itemLast = findViewById(R.id.item_last_reward);
        ((TextView) itemLast.findViewById(R.id.tv_reward_name)).setText("Gopay Coins Rp 10.000");
        ((TextView) itemLast.findViewById(R.id.tv_reward_desc)).setText("Tukarkan Voucher di Aplikasi Gopay");
        ((TextView) itemLast.findViewById(R.id.tv_reward_points)).setText("100 Poin");
        ((ImageView) itemLast.findViewById(R.id.iv_reward_logo)).setImageResource(R.drawable.logo_gopay);
        ((TextView) itemLast.findViewById(R.id.btn_tukar)).setText("Tukar Lagi");
        itemLast.findViewById(R.id.btn_tukar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukaGopay();
            }
        });

        // REKOMENDASI 1 - Gopay
        View item1 = findViewById(R.id.item_reward_1);
        ((TextView) item1.findViewById(R.id.tv_reward_name)).setText("Gopay Coins Rp 10.000");
        ((TextView) item1.findViewById(R.id.tv_reward_desc)).setText("Tukarkan Voucher di Aplikasi Gopay");
        ((TextView) item1.findViewById(R.id.tv_reward_points)).setText("100 Poin");
        ((ImageView) item1.findViewById(R.id.iv_reward_logo)).setImageResource(R.drawable.logo_gopay);
        item1.findViewById(R.id.btn_tukar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukaGopay();
            }
        });

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

    /*
     * jadi ini bentuk implicit intent untuk membuka aplikasi GoPay.
     * "aplikasi" padahal cuma websitenya saja
     * kalau terinstall ya, akan langsung kebuka app-nya.
     */
    private void bukaGopay() {
        // coba buka app GoPay langsung via deep link (kalau ada)
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("gojek://gopay"));

        // cek apa ada app yang bisa handle intent ini
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent); // maka buka app GoPay
        } else {
            // fallback: buka browser ke website GoPay
            Intent browser = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://gopay.co.id"));
            startActivity(browser);
        }
    }

    private void setActiveNav() {
        setNavColor(R.id.nav_home, R.color.gray_text, Typeface.NORMAL);
        setNavColor(R.id.nav_reward, R.color.green_primary, Typeface.BOLD);
        setNavColor(R.id.nav_statistik, R.color.gray_text, Typeface.NORMAL);
        setNavColor(R.id.nav_profil, R.color.gray_text, Typeface.NORMAL);
    }

    private void setNavColor(int navId, int colorRes, int typefaceStyle) {
        LinearLayout tab = findViewById(navId);
        if (tab == null) return;
        for (int i = 0; i < tab.getChildCount(); i++) {
            View child = tab.getChildAt(i);
            if (child instanceof ImageView) {
                ((ImageView) child).setColorFilter(
                        getResources().getColor(colorRes, getTheme()));
            } else if (child instanceof TextView) {
                ((TextView) child).setTextColor(
                        getResources().getColor(colorRes, getTheme()));
                ((TextView) child).setTypeface(null, typefaceStyle);
            }
        }
    }
}