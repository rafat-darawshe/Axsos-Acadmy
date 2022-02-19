from distutils.log import error
from django.db import models
import re

class UserManager(models.Manager):
    def validator(self, postdata):
        email_check=re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        errors={}
        if len(postdata ['f_n']) < 2:
            errors['f_n']="First Name must be longer than 2 character!"
            
        if len(postdata['l_n'])< 2:
            errors['l_n']="Last Name must be longer than 2 character!"   
            
        if not email_check.match(postdata['email']):      
            errors['email'] = "Email address should be valid!"
            
        if len(postdata['pw']) < 8:
            errors['pw'] = "Password must be at least 8 character!"   
            
        if postdata['pw'] != postdata['conf_pw']:
            errors['conf_pw'] = "Password and confirm password must be math!"  
            
        return errors




class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()
    
