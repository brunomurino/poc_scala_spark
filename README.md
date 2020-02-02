# Project Spark

Python dependencies must also be installed on the spark cluster

Run `docker-compose up` to run everything.

Since the containers are named we can easily ssh into them by doing e.g.

```
docker exec -ti mysql_db bash
```

* To see the python script working, create a table on the database