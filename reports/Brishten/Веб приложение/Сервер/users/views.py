from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.response import Response
from django_filters import rest_framework as filters
from rest_framework import status
from rest_framework.renderers import JSONRenderer
from rest_framework.generics import (
    ListAPIView,
    CreateAPIView,
    DestroyAPIView,
    UpdateAPIView,
    RetrieveAPIView
)

from .models import (
    User, Article, UserFile, 
    Check_Article, UserBan, UserMessage,
    UserFollowers)
from .serializers import (
    UserSerializer, ArticleSerializer, 
    Check_ArticleSerializer, UserBanSerializer, 
    UserMessageSerializer, UserFollowersSerializer)
from django.http import HttpResponse, response
from .resources import PersonResource
import json, sqlite3, os
 
# Create your views here.

class UserViewSet(viewsets.ModelViewSet):
    serializer_class = UserSerializer
    queryset = User.objects.all()


class Check_ArticleViewSet(viewsets.ModelViewSet):
    serializer_class = Check_ArticleSerializer
    queryset = Check_Article.objects.all()


class UserBanViewSet(viewsets.ModelViewSet):
    serializer_class = UserBanSerializer
    queryset = UserBan.objects.all()


class UserMessageViewSet(viewsets.ModelViewSet):
    serializer_class = UserMessageSerializer
    queryset = UserMessage.objects.all()


class UserFollowersViewSet(viewsets.ModelViewSet):
    serializer_class = UserFollowersSerializer
    queryset = UserFollowers.objects.all()


class ArticleListView(ListAPIView):
    queryset = Article.objects.all()
    serializer_class = ArticleSerializer


class ArticleCreateView(CreateAPIView):
    queryset = Article.objects.all()
    serializer_class = ArticleSerializer


class ArticleDetailView(RetrieveAPIView):
    queryset = Article.objects.all()
    serializer_class = ArticleSerializer


class ArticleUpdateView(UpdateAPIView):
    queryset = Article.objects.all()
    serializer_class = ArticleSerializer


class ArticleDeleteView(DestroyAPIView):
    queryset = Article.objects.all()
    serializer_class = ArticleSerializer


def export(request):
    login = request.GET.get('login')
    try:
        UserFile.objects.get(login=login)
        return answer("NO")
        
    except UserFile.DoesNotExist:
        person_resource = PersonResource()
        queryset = Article.objects.filter(login=login)
        dataset = person_resource.export(queryset)
        response = HttpResponse(dataset.json, content_type='application/json')
        File_name = login + ".json"

        with open(File_name, "w") as file:
            file.write(dataset.json)

        UserFile.objects.create(login=login, file_name=File_name) # Чтобы знать какой файл открывать
        Article.objects.filter(login=login).delete() # Удаляем записи
        return response
    

def Import(request):
    login = request.GET.get('login')
    content = "OK"
    try:
        obj = UserFile.objects.get(login=login)
        file_name = obj.file_name
        print(file_name)

        with open(file_name) as json_file:
            data = json.load(json_file)
            for col in data:
                Article.objects.create(login=col['login'], title=col['title'], content=col['content'],
                image=col['image'], description=col['description'], kind=col['kind'], avatar=col['avatar'])

        UserFile.objects.filter(login=login).delete()
        os.remove(file_name)

    except UserFile.DoesNotExist:
        content = "NO"
    return answer(content)


def dump_DB(request):
    con = sqlite3.connect('db.sqlite3')
    bck = sqlite3.connect('../db.sqlite3')
    with bck:
        con.backup(bck)
    bck.close()
    con.close()
    return answer("Backup")


def load_DB(request):
    con = sqlite3.connect('../db.sqlite3')
    bck = sqlite3.connect('db.sqlite3')
    with bck:
        con.backup(bck)
    bck.close()
    con.close()
    return answer("Loading")


def answer(content):
    response = Response(
            {"Flag": content},
            content_type="application/json",
            status=status.HTTP_202_ACCEPTED,
        )
    response.accepted_renderer = JSONRenderer()
    response.accepted_media_type = "application/json"
    response.renderer_context = {}
    return response