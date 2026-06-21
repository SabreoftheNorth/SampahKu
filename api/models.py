from django.db import models

# 1. Tabel Pengguna
class Pengguna(models.Model):
    nama = models.CharField(max_length=100)
    email = models.EmailField(unique=True)
    password = models.CharField(max_length=255)
    no_telepon = models.CharField(max_length=20, default="-", blank=True)
    alamat = models.TextField(default="-", blank=True)
    total_poin = models.IntegerField(default=0)

    def __str__(self):
        return self.nama

# 2. Tabel Riwayat Setor Sampah
class RiwayatSampah(models.Model):
    user = models.ForeignKey(Pengguna, on_delete=models.CASCADE)
    nama_sampah = models.CharField(max_length=50)
    berat = models.DecimalField(max_digits=5, decimal_places=2) # Contoh: 0.50
    poin_didapat = models.IntegerField()
    tanggal_lokasi = models.CharField(max_length=255)

    def __str__(self):
        return f"{self.nama_sampah} ({self.user.nama})"

# 3. Tabel Video Edukasi
class EdukasiVideo(models.Model):
    video_id_youtube = models.CharField(max_length=50)
    judul = models.CharField(max_length=150)
    deskripsi = models.TextField()

    def __str__(self):
        return self.judul

# 4. Tabel Daftar Reward
class Reward(models.Model):
    nama_reward = models.CharField(max_length=100)
    deskripsi = models.TextField()
    poin_dibutuhkan = models.IntegerField()
    logo_resource_name = models.CharField(max_length=50)

    def __str__(self):
        return self.nama_reward