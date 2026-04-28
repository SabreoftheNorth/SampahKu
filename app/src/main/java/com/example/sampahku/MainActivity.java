package com.example.sampahku;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent; // untuk import fungsi Intent

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //navbar yang dibuat menurut desain figma
    // memakai linearlayout
    private LinearLayout navHome;
    private LinearLayout navReward;
    private LinearLayout navQr;
    private LinearLayout navStatistik;
    private LinearLayout navProfil;

    //linear layout lagi namun untuk tombol "TUkar poin"
    private LinearLayout tblTukarPoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //initialisasi item-item yang ada di navbar di bawah layar nanti
        // ditambah tombol tukar poinnya
        navHome = findViewById(R.id.nav_home);
        navReward = findViewById(R.id.nav_reward);
        navQr = findViewById(R.id.nav_qr);
        navStatistik = findViewById(R.id.nav_statistik);
        navProfil = findViewById(R.id.nav_profil);

        tblTukarPoin = findViewById(R.id.btn_tukar_poin);

        //setOnClickListener
        navHome.setOnClickListener(this);
        navReward.setOnClickListener(this);
        navQr.setOnClickListener(this);
        navStatistik.setOnClickListener(this);
        navProfil.setOnClickListener(this);
        tblTukarPoin.setOnClickListener(this);

        //set data-data utk item aktivitas
        // karena memakai <include> maka saya perlu set
        // secara manual
        setupAktivitasItems();
        setupEdukasiItems();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nav_home) {
            // Ini hanya memastikan apakah tombol home bekerja
            // aslinya sdh di home
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            // menggunakan inten untuk menuju ke halaman Reward
        } else if (v.getId() == R.id.nav_reward) {
            Intent intent = new Intent(MainActivity.this, RewardActivity.class);
            startActivity(intent);

            //menggunakan inten untuk menuju ke halaman scan QR
        } else if (v.getId() == R.id.nav_qr) {
            Intent intent = new Intent(MainActivity.this, QrActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.nav_statistik) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.nav_profil) {
            Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();

        } // else if (v.getId() == R.id.tbl_tukar_poin) {
            // Toast.makeText(this, getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
       // }
    }

    //ini utk set data untuk 3 aktivitas yang baru
    // karena memakai <include> seperti sebelumnya, maka perlu
    // override datanya di sini:
    private void setupAktivitasItems() {
        //Item 1: Kain/Cacahan
        // item 2: Botol Plastik
        // item 3: kertas koran
        View itemBotol = findViewById(R.id.item_botol);
        ((TextView) itemBotol.findViewById(R.id.tv_nama_sampah)).setText("Botol Plastik");
        ((TextView) itemBotol.findViewById(R.id.tv_berat)).setText("0.50 kg");
        ((TextView) itemBotol.findViewById(R.id.tv_poin)).setText("+100 poin");
        ((TextView) itemBotol.findViewById(R.id.tv_tanggal_lokasi))
                .setText("18 April 2026 • Mesin A - Supermarket");
        View itemKertas = findViewById(R.id.item_kertas);
        ((TextView) itemKertas.findViewById(R.id.tv_nama_sampah)).setText("Kertas Koran");
        ((TextView) itemKertas.findViewById(R.id.tv_berat)).setText("0.5 kg");
        ((TextView) itemKertas.findViewById(R.id.tv_poin)).setText("+50 poin");
        ((TextView) itemKertas.findViewById(R.id.tv_tanggal_lokasi))
                .setText("20 April 2026 • Mesin C - Kampus");
    }

    //set data untuk 3 item edukasinya
    private void setupEdukasiItems() {
        //item 1 sudah default
        // sedangkan item 2:
        View item2 = findViewById(R.id.item_edukasi_2);
        ((TextView) item2.findViewById(R.id.tv_judul_edukasi)).setText("Cara Menyimpan Minyak Bekas");
        ((TextView) item2.findViewById(R.id.tv_desc_edukasi))
                .setText("Simpan minyak bekas di tempat yang tidak lembab");

        // Item 3
        View item3 = findViewById(R.id.item_edukasi_3);
        ((TextView) item3.findViewById(R.id.tv_judul_edukasi)).setText("Cara memilah sampah plastik");
        ((TextView) item3.findViewById(R.id.tv_desc_edukasi))
                .setText("Pisahkan sesuai jenis agar poin maksimal");
    }
}