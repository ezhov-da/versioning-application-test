# Тестирование версионирования Nexus Maven Repository и организации модульности Maven

1. Стянуть образ [https://hub.docker.com/r/sonatype/nexus3](https://hub.docker.com/r/sonatype/nexus3)
    ```
    docker pull sonatype/nexus3
    ```
1. Запустить образ
    ```
    docker run -d -p 8081:8081 --name nexus sonatype/nexus3
    ```
   
1. Перейти в репозиторий [http://localhost:8081/#browse/browse](http://localhost:8081/#browse/browse)

1. Авторизоваться используя 
    > ЛОГИН: admin \
    ПАРОЛЬ: выполнить \
    ```docker exec -it nexus /bin/bash``` \
    ```cat /nexus-data/admin.password```
	
1. Добавить авторизацию в файл ~/.m2/setting.xml
    ```
    <servers>
        <server>
            <id>maven.docker.internal.repo</id>
            <username>admin</username>
            <password>_пароль с предыдущего шага_></password>
        </server>
    </servers>
    ```
1. Собрать проект
    ```
    mvn clean package
    ```
1. Сделать deploy
    ```
    mvn clean deploy
    ```

__//TODO: сделать так, чтоб работал модуль client-web-src__