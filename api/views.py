from django.shortcuts import render

from rest_framework import viewsets
from rest_framework.decorators import api_view
from rest_framework.response import Response
from .models import Pengguna, RiwayatSampah, EdukasiVideo, Reward
from .serializers import PenggunaSerializer, RiwayatSampahSerializer, EdukasiVideoSerializer, RewardSerializer

# View untuk mengekspos semua data dengan mudah (GET, POST, PUT, DELETE)
class PenggunaViewSet(viewsets.ModelViewSet):
    queryset = Pengguna.objects.all()
    serializer_class = PenggunaSerializer

class RiwayatSampahViewSet(viewsets.ModelViewSet):
    queryset = RiwayatSampah.objects.all()
    serializer_class = RiwayatSampahSerializer

class EdukasiVideoViewSet(viewsets.ModelViewSet):
    queryset = EdukasiVideo.objects.all()
    serializer_class = EdukasiVideoSerializer

class RewardViewSet(viewsets.ModelViewSet):
    queryset = Reward.objects.all()
    serializer_class = RewardSerializer

# View KHUSUS untuk fungsi Login dari Android
@api_view(['POST'])
def login_api(request):
    email = request.data.get('email')
    password = request.data.get('password')

    try:
        # Mencari pengguna yang email dan passwordnya cocok
        user = Pengguna.objects.get(email=email, password=password)
        return Response({
            'status': 'success',
            'user_id': user.id,
            'nama': user.nama
        })
    except Pengguna.DoesNotExist:
        # Jika tidak ketemu / salah password
        return Response({
            'status': 'failed',
            'message': 'Email atau Password Salah!'
        }, status=400)
