
from import_export import resources
from .models import Article

class PersonResource(resources.ModelResource):
    class Meta:
        model = Article

