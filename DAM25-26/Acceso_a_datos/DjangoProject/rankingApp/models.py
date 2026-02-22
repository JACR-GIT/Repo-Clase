from django.contrib.auth.base_user import BaseUserManager, AbstractBaseUser
from django.contrib.auth.models import PermissionsMixin
from django.core.validators import MinValueValidator, MaxValueValidator
from django.db import models
from django_mongodb_backend.fields import ArrayField
from django_mongodb_backend.models import EmbeddedModel


#python manage.py makemigrations
#python manage.py migrate

#Modelos carta
class Album(models.Model):
    code=models.IntegerField(unique=True, primary_key=True)
    title = models.CharField(max_length=200, blank=False, null=False)
    artist = ArrayField(models.CharField(max_length=100), null=False)
    release_date = models.CharField(max_length=100, null=True, blank=True)
    genres = ArrayField(models.CharField(max_length=100), null=False)
    numSongs = models.IntegerField(blank=False, default=0)
    category = ArrayField(models.CharField(), null=False)
    image = models.CharField(blank=False, null=False)

    class Meta:
        db_table = 'albunes'
        managed = False

    def __str__(self):
        return self.title

class Category(models.Model):
    code = models.IntegerField(null=True, unique=True)
    name = models.CharField(max_length=200)
    description = models.CharField(blank=True)
    logo = models.CharField(max_length=900)

    class Meta:
        db_table = 'categories'
        managed = False

    def __str__(self):
        return self.name

class Review(models.Model):
    codeAlbum = models.IntegerField(null=False)
    user = models.CharField(max_length=200)
    rating = models.IntegerField(default=0, validators=[MinValueValidator(0), MaxValueValidator(5)])
    review = models.TextField()
    reviewDate = models.DateTimeField(auto_now_add=True)

    class Meta:
        db_table = 'reviews'
        managed = False

    def __str__(self):
        return self.user + " " + str(self.rating)

class Ranking(models.Model):
    code = models.IntegerField(null=False, unique=True)
    user = models.CharField(max_length=200)
    categoryCode = models.IntegerField(null=False)
    rankingData = models.JSONField(null=True, blank=True)

    class Meta:
        db_table = 'ranking'
        managed = False

    def __str__(self):
        return self.user + " " + str(self.categoryCode)


class UserManager(BaseUserManager):
    def create_user(self, mail, username, role, password=None):
        if not mail or not username or not role:
            raise ValueError("Debes rellenar los campos requeridos (mail, username, role)")
        mail = self.normalize_email(mail)
        user = self.model(mail=mail, username=username, role=role)
        user.set_password(password)
        user.save(using=self._db)
        return user

    def create_superuser(self, mail, username, role='admin', password=None):
        user = self.create_user(mail, username, role, password)
        user.is_superuser = True
        user.is_staff = True
        user.save(using=self._db)
        return user



class User(AbstractBaseUser, PermissionsMixin):
    ROLES = (
        ('admin', 'Administrador'),
        ('cliente', 'Cliente'),
    )

    mail = models.EmailField(unique=True)
    username = models.CharField(max_length=100, unique=True)
    role = models.CharField(max_length=20, choices=ROLES, default='cliente')
    is_active = models.BooleanField(default=True)
    is_staff = models.BooleanField(default=False)

    objects = UserManager()

    USERNAME_FIELD = 'username'
    REQUIRED_FIELDS = ['mail',  'role']

    def __str__(self):
        return self.username