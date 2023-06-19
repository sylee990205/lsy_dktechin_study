# 230615 docker exercise 01

1. 다음 내용으로 html 파일 my.html을 생성한다.

2. 다음 내용을 반영하여 Dockerfile 을 생성한다.
   - nginx 이미지로 base 이미지를 생성한다.
   - 현재 디렉토리 위치를 /usr/share/nginx/html 로 변경한다.
   - images 디렉토리를 생성한다.
   - docker.png(호스트 머신) 를 images 폴더에 동일한 파일명으로 복사한다.
   - my.html(호스트 머신) 을 현재 디렉토리에 복사한다.
   - 80번 포트 번호로 리스닝하게 설정한다.
   - nginx 서버를 기동시킨다. 이때 파라미터로 –g 와 daemon off; 를 설정한다.
```docker
FROM nginx
WORKDIR /usr/share/nginx/html
RUN ["mkdir", "images"]
COPY docker.png ./images
COPY my.html ./
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]
```

3. 2번에서 완성된 Dockerfile을 가지고 도커 이미지 new_xxxnginx 를 생성한다.
4. 9000 포트번호로 컨테이너를 기동시키고 my.html 을 요청해 본다
![img](/exercise/Docker%20exercise/230615/4.PNG)
