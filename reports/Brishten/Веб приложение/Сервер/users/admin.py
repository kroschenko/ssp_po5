from django.contrib import admin

from .models import User, Article, Check_Article, UserBan
# Register your models here.

admin.site.register(User)
admin.site.register(Article)
admin.site.register(Check_Article)
admin.site.register(UserBan)