package com.example.sampahku;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StatistikActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout btnTukarPoin;

    // navbarnya
    private LinearLayout navHome;
    private LinearLayout navReward;
    private LinearLayout navQr;
    private LinearLayout navStatistik;
    private LinearLayout navProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // tombol back, FUNGSI BASICALLY THE SAME WITH OTHERS LAH
        // singapore mode activated fr fr
        ImageView ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // tombol utk tukar poin, ambil dari beranda saja yukss
        btnTukarPoin = findViewById(R.id.btn_tukar_poin);
        btnTukarPoin.setOnClickListener(this);

        // navbar di bawah
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

        // set data aktivitas
        setupAktivitasItems();

        // highlight tab Statistik
        setActiveNav();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nav_home) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_reward) {
            startActivity(new Intent(StatistikActivity.this, RewardActivity.class));

        } else if (v.getId() == R.id.nav_qr) {
            startActivity(new Intent(StatistikActivity.this, QrActivity.class));

        } else if (v.getId() == R.id.nav_statistik) {
            Toast.makeText(this, "Statistik", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.nav_profil) {
            startActivity(new Intent(StatistikActivity.this, ProfilActivity.class));

        } else if (v.getId() == R.id.btn_tukar_poin) {
            startActivity(new Intent(StatistikActivity.this, RewardActivity.class));
        }
    }

    private void setupAktivitasItems() {
        // Item 1: default (Kain/Cacahan) sudah dari item_aktivitas.xml

        // Item 2: Botol Plastik
        View itemBotol = findViewById(R.id.item_stat_botol);
        ((TextView) itemBotol.findViewById(R.id.tv_nama_sampah)).setText("Botol Plastik");
        ((TextView) itemBotol.findViewById(R.id.tv_berat)).setText("0.50 kg");
        ((TextView) itemBotol.findViewById(R.id.tv_poin)).setText("+100 poin");
        ((TextView) itemBotol.findViewById(R.id.tv_tanggal_lokasi))
                .setText("18 April 2026 • Mesin A - Supermarket");

        // Item 3: Kertas Koran
        View itemKertas = findViewById(R.id.item_stat_kertas);
        ((TextView) itemKertas.findViewById(R.id.tv_nama_sampah)).setText("Kertas Koran");
        ((TextView) itemKertas.findViewById(R.id.tv_berat)).setText("0.5 kg");
        ((TextView) itemKertas.findViewById(R.id.tv_poin)).setText("+50 poin");
        ((TextView) itemKertas.findViewById(R.id.tv_tanggal_lokasi))
                .setText("20 April 2026 • Mesin C - Kampus");
    }


    // basically highlight tab di navbar agar statistik jadi hijau dan yang lainnya jadi abu2
    // (DONE) APPLY ALL THIS FIX TO ALL THE ACTIVITIES AS WELL
    // welp that's done
    private void setActiveNav() {
        setNavColor(R.id.nav_home,      R.color.gray_text,     Typeface.NORMAL);
        setNavColor(R.id.nav_reward,    R.color.gray_text,     Typeface.NORMAL);
        setNavColor(R.id.nav_statistik, R.color.green_primary, Typeface.BOLD);
        setNavColor(R.id.nav_profil,    R.color.gray_text,     Typeface.NORMAL);
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