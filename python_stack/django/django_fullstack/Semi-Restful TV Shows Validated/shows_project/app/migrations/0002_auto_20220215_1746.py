# Generated by Django 2.2.4 on 2022-02-15 15:46

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('app', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='show',
            name='date',
            field=models.DateField(),
        ),
    ]