# Demo Initial Spring Boot 2.7.0



[https://github.com/mbachmann/demo-initial-2022-teko](****)

Use a Mac, Linux, WSL2 or git bash console.




<br/>

##  Create a Docker Container, Run and Publish to Docker

Create first a jar with the build instruction. The create a container. Replace **uportal** with your **dockerhub id**.

<br/>

```

$  docker build -t uportal/demo-initial .
$  docker run -p 8080:8080 --rm -it  uportal/demo-initial
```

<br/>

Ctrl c will stop and delete the container.

<br/>

Replace **uportal** with your **dockerhub id**.

<br/>

```
$  docker login
$  docker login --username uportal --password 
$  docker push uportal/demo-initial
```
<br/>

login to deployment platform with a container infrastructure:

<br/>

Replace **uportal** with your **dockerhub id**.

<br/>

```
$  docker pull uportal/demo-initial
```

<br/>

##  docker-compose

Start the files with:

<br/>

Start with log output in the console

```
$  docker-compose -f docker-compose.yml up
```

<br/>

Start in detached mode

```
$  docker-compose -f docker-compose.yml up -d
```

<br/>

Delete containers:

```
$  docker-compose -f docker-compose.yml rm
```

<br/>
