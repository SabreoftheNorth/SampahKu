package com.example.sampahku;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("api/login/")
    Call<LoginResponse> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    // Mendaftarkan user baru (Register)
    @FormUrlEncoded
    @POST("api/pengguna/")
    Call<ProfilResponse> registerUser(
            @Field("nama") String nama,
            @Field("email") String email,
            @Field("password") String password,
            @Field("no_telepon") String noTelepon,
            @Field("alamat") String alamat,
            @Field("total_poin") int totalPoin
    );

    // Mengambil profil user dengan ID 1 (Contoh)
    @GET("api/pengguna/1/")
    Call<ProfilResponse> getProfil();

    // Mengambil daftar riwayat (menghasilkan List/Array)
    @GET("api/riwayat/")
    Call<List<RiwayatResponse>> getRiwayat();

    // Mengambil daftar video edukasi
    @GET("api/edukasi/")
    Call<List<EdukasiResponse>> getEdukasi();

    // Mengambil daftar reward
    @GET("api/reward/")
    Call<List<RewardResponse>> getReward();

    // Mengubah data profil secara spesifik menggunakan PATCH
    @FormUrlEncoded
    @PATCH("api/pengguna/{id}/")
    Call<ProfilResponse> updateProfil(
            @Path("id") int id,          // ID pengguna yang ingin diubah
            @Field("nama") String nama,
            @Field("no_telepon") String noTelepon,
            @Field("alamat") String alamat
    );


}