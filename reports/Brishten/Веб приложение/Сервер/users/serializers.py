from rest_framework import serializers
from .models import User, Article, UserBan, Check_Article, UserMessage, UserFollowers


class UserSerializer(serializers.ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'login', 'password', 'image']


class ArticleSerializer(serializers.ModelSerializer):
    class Meta:
        model = Article
        fields = ['id', 'login', 'title', 'content', 'description', 'kind', 'image', 'avatar']


class Check_ArticleSerializer(serializers.ModelSerializer):
    class Meta:
        model = Check_Article
        fields = ['id', 'login', 'title', 'content', 'description', 'kind', 'image', 'avatar']


class UserBanSerializer(serializers.ModelSerializer):
    class Meta:
        model = UserBan
        fields = ['id', 'login', 'date']


class UserMessageSerializer(serializers.ModelSerializer):
    class Meta:
        model = UserMessage
        fields = ['id', 'login', 'message', 'date', 'title']


class UserFollowersSerializer(serializers.ModelSerializer):
    class Meta:
        model = UserFollowers
        fields = ['id', 'author', 'follower']
