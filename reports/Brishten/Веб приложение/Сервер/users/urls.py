from rest_framework.routers import DefaultRouter
from django.urls import path

from .views import Import, export, dump_DB, load_DB
from .views import (
    UserViewSet,
    Check_ArticleViewSet,
    UserBanViewSet,
    UserMessageViewSet,
    UserFollowersViewSet,
    ArticleListView,
    ArticleCreateView,
    ArticleDetailView,
    ArticleUpdateView,
    ArticleDeleteView,
)


router = DefaultRouter()
router.register(r'users', UserViewSet)
router.register(r'checklist', Check_ArticleViewSet)
router.register(r'userban', UserBanViewSet)
router.register(r'message', UserMessageViewSet)
router.register(r'follow', UserFollowersViewSet), 

urlpatterns = [
    path('list/', ArticleListView.as_view()),
    path('create/', ArticleCreateView.as_view()),
    path('list/<pk>/', ArticleDetailView.as_view()),
    path('list/<pk>/update/', ArticleUpdateView.as_view()),
    path('list/<pk>/delete/', ArticleDeleteView.as_view()),

    path('export/', export),
    path('import/', Import),
    path('dump/', dump_DB),
    path('load/', load_DB),
]

urlpatterns += router.urls