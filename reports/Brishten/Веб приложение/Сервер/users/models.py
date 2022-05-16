from django.db import models
from django.contrib.auth.models import AbstractBaseUser

# Create your models here.

class User(AbstractBaseUser):
    login = models.CharField(max_length=120, unique=True)
    password = models.CharField(max_length=120)
    image = models.TextField()


class Article(models.Model):
    login = models.CharField(max_length=120)
    title = models.CharField(max_length=120)
    content = models.TextField()
    image = models.TextField()
    description = models.CharField(max_length=150)
    kind = models.CharField(max_length=30)
    avatar = models.TextField()

class Check_Article(models.Model):
    login = models.CharField(max_length=120)
    title = models.CharField(max_length=120)
    content = models.TextField()
    image = models.TextField()
    description = models.CharField(max_length=150)
    kind = models.CharField(max_length=30)
    avatar = models.TextField()


class UserFile(models.Model):
    login = models.CharField(max_length=120)
    file_name = models.CharField(max_length=120)


class UserBan(models.Model):
    login = models.CharField(max_length=120)
    date = models.CharField(max_length=120)


class UserMessage(models.Model):
    login = models.CharField(max_length=120)
    message = models.CharField(max_length=120)
    date = models.CharField(max_length=120)
    title = models.CharField(max_length=120)


class UserFollowers(models.Model):
    author = models.CharField(max_length=120)
    follower = models.CharField(max_length=120)