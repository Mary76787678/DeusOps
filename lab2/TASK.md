# Лабораторная работа №2
## Docker: докеризация приложения

### Цель лабораторной: 
собрать из исходного когда и запустить в докере рабочее приложение с базой данных (любое опенсорс - Java, python/django/flask, golang).

- [x] Образ должен быть легковесным
- [x] Использовать базовые легковестные образы - alpine
- [x] Вся конфигурация приложения должна быть через переменные окружения
- [x] Статика (зависимости) должна быть внешним томом `volume`
- [x] Создать файл `docker-compose` для старта и сборки
- [x] В `docker-compose` нужно использовать базу данных (postgresql,mysql,mongodb etc.)
- [x] При старте приложения должно быть учтено выполнение автоматических миграций
- [x] Контейнер должен запускаться от непривилегированного пользователя
- [x] После установки всех нужных утилит, должен очищаться кеш
> # Тут стоит отметить, что образ с `.jar` файлом весит 566 МБ - это много, но базовый `openjdk:17-alpine` образ весит ~518 МБ, так что весь ненужный кэш удалён (точнее, не создал, так как использовался подход с мульти-стейдж билдингом образа)