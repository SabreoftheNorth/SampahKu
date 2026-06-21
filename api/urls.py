from django.urls import path, include
from rest_framework.routers import DefaultRouter
from .views import PenggunaViewSet, RiwayatSampahViewSet, EdukasiVideoViewSet, RewardViewSet, login_api

# Router otomatis membuatkan URL untuk data-data kita
router = DefaultRouter()
router.register(r'pengguna', PenggunaViewSet)
router.register(r'riwayat', RiwayatSampahViewSet)
router.register(r'edukasi', EdukasiVideoViewSet)
router.register(r'reward', RewardViewSet)

urlpatterns = [
    path('', include(router.urls)),
    path('login/', login_api, name='login_api'), # Jalur khusus login
]