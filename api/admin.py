from django.contrib import admin
from .models import Pengguna, RiwayatSampah, EdukasiVideo, Reward

# Mendaftarkan model agar muncul di dashboard admin
admin.site.register(Pengguna)
admin.site.register(RiwayatSampah)
admin.site.register(EdukasiVideo)
admin.site.register(Reward)
