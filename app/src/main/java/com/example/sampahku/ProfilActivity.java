package com.example.sampahku;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity implements View.OnClickListener {

    // Bottom nav
    private LinearLayout navHome;
    private LinearLayout navReward;
    private LinearLayout navQr;
    private LinearLayout navStatistik;
    private LinearLayout navProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Tombol back
        ImageView ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Tombol edit profil
        ImageView ivEdit = findViewById(R.id.iv_edit);
        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfilActivity.this,
                        getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
            }
        });

        // Bottom nav
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

        // Setup data profil dan menu
        setupProfilData();
        setupMenuItems();
        setActiveNav();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nav_home) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_reward) {
            Intent intent = new Intent(ProfilActivity.this, RewardActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_qr) {
            Intent intent = new Intent(ProfilActivity.this, QrActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_statistik) {
            Intent intent = new Intent(ProfilActivity.this, StatistikActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_profil) {
            Toast.makeText(this, "Profil", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set data baris-baris info profil
     */
    private void setupProfilData() {
        View itemNama = findViewById(R.id.item_nama_pengguna);
        ((TextView) itemNama.findViewById(R.id.tv_label)).setText("Nama Pengguna :");
        ((TextView) itemNama.findViewById(R.id.tv_value)).setText("Rakha");

        View itemEmail = findViewById(R.id.item_email);
        ((TextView) itemEmail.findViewById(R.id.tv_label)).setText("Email :");
        ((TextView) itemEmail.findViewById(R.id.tv_value)).setText("rakaatha@gmail.com");

        View itemTelepon = findViewById(R.id.item_telepon);
        ((TextView) itemTelepon.findViewById(R.id.tv_label)).setText("No. Telepon :");
        ((TextView) itemTelepon.findViewById(R.id.tv_value)).setText("-");

        View itemAlamat = findViewById(R.id.item_alamat);
        ((TextView) itemAlamat.findViewById(R.id.tv_label)).setText("Alamat :");
        ((TextView) itemAlamat.findViewById(R.id.tv_value)).setText("-");
    }

    /**
     * Set label dan ikon setiap item menu
     */
    private void setupMenuItems() {
        setMenuItem(R.id.menu_pin,      R.drawable.ic_pin,    "Atur Pin Penukaran Reward");
        setMenuItem(R.id.menu_password, R.drawable.ic_lock,   "Ubah Password");
        setMenuItem(R.id.menu_privasi,  R.drawable.ic_shield, "Pengaturan Privasi");
        setMenuItem(R.id.menu_bahasa,   R.drawable.ic_globe,  "Bahasa");
        setMenuItem(R.id.menu_bantuan,  R.drawable.ic_help,   "Bantuan");
        setMenuItem(R.id.menu_keluar,   R.drawable.ic_logout, "Keluar");

        // Khusus tombol Keluar — kembali ke LoginActivity dan clear back stack
        RelativeLayout menuKeluar = findViewById(R.id.menu_keluar);
        menuKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        // Menu lain: coming soon
        int[] menuIds = {
                R.id.menu_pin, R.id.menu_password,
                R.id.menu_privasi, R.id.menu_bahasa, R.id.menu_bantuan
        };
        for (int id : menuIds) {
            RelativeLayout menu = findViewById(id);
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ProfilActivity.this,
                            getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * Helper untuk set icon dan label setiap item menu
     */
    private void setMenuItem(int menuId, int iconRes, String label) {
        View menu = findViewById(menuId);
        ((ImageView) menu.findViewById(R.id.iv_menu_icon)).setImageResource(iconRes);
        ((TextView) menu.findViewById(R.id.tv_menu_label)).setText(label);
    }

    /**
     * Highlight tab Profil, reset semua tab lain ke abu-abu
     */
    private void setActiveNav() {
        setNavColor(R.id.nav_home, R.color.gray_text, Typeface.NORMAL);
        setNavColor(R.id.nav_reward, R.color.gray_text, Typeface.NORMAL);
        setNavColor(R.id.nav_statistik, R.color.gray_text, Typeface.NORMAL);
        setNavColor(R.id.nav_profil, R.color.green_primary, Typeface.BOLD);
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