from distutils.log import error
from django.db import models
from datetime import datetime
import bcrypt
import re

class UserManager(models.Manager):
    def register_validator(self, postdata):
        email_check=re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        errors={}
        if len(postdata ['f_n']) < 2:
            errors['f_n']="First Name must be longer than 2 character!"
            
            
        if len(postdata['birthday']) != 0:
            birthday = datetime.strptime(postdata['birthday'], '%Y-%m-%d')
            now = datetime.strptime(
                datetime.now().strftime('%Y-%m-%d'), '%Y-%m-%d')
            diff = now - birthday    
            
        if len(postdata['l_n'])< 2:
            errors['l_n']="Last Name must be longer than 2 character!"   
            
        if not email_check.match(postdata['email']):      
            errors['email'] = "Email address should be valid!"
            
        if len(postdata['pw']) < 8:
            errors['pw'] = "Password must be at least 8 character!"   
            
        if postdata['pw'] != postdata['conf_pw']:
            errors['conf_pw'] = "Password and confirm password must be math!"  
            
        if len(postdata['birthday']) == 0:
            errors['birthday'] = 'Birthday is required'
        elif diff.days < (13*365):
            errors['birthday'] = 'You must be at least 13 years old'    
            
        return errors

    def login_validator(self, postData):
            errors = {}

            user = User.objects.filter(email=postData['email'])

            EMAIL_REGEX = re.compile(
                r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

            if len(postData['email']) == 0:
                errors['email'] = "Please enter an email address!"
            elif not EMAIL_REGEX.match(postData['email']):
                errors['email'] = "Invalid email or password"

            if len(postData['pw']) < 8:
                errors['pw'] = 'Password should be at least 8 characters'

            if user:
                if not bcrypt.checkpw(postData['pw'].encode(), user[0].password.encode()):
                    errors['auth'] = 'Invalid email or password'
            elif not user:
                errors['user'] = 'No account associated with this email'

            return errors
        




class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.CharField(max_length=255)
    birthday = models.DateField(null=True)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()
    
    
    def __str__(self):
        return f"<Show object: {self.first_name} {self.last_name}>"
    
