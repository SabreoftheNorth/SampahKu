from rest_framework import serializers
from .models import Pengguna, RiwayatSampah, EdukasiVideo, Reward

class PenggunaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Pengguna
        fields = '__all__' # Mengambil semua kolom data

class RiwayatSampahSerializer(serializers.ModelSerializer):
    class Meta:
        model = RiwayatSampah
        fields = '__all__'

class EdukasiVideoSerializer(serializers.ModelSerializer):
    class Meta:
        model = EdukasiVideo
        fields = '__all__'

class RewardSerializer(serializers.ModelSerializer):
    class Meta:
        model = Reward
        fields = '__all__'