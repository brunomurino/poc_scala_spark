# spark-basic.py
import os
from pyspark import SparkConf, SparkContext, SQLContext

os.environ["PYSPARK_PYTHON"] = "/usr/bin/python3"
os.environ["PYSPARK_DRIVER_PYTHON"] = "/usr/bin/python3"

conf = SparkConf()
conf.setMaster('spark://spark-master:7077')
conf.setAppName('spark-basic')
conf.set("spark.jars", "/usr/share/java/mariadb-java-client-2.5.4.jar")
sc = SparkContext(conf=conf)

sqlContext = SQLContext(sc)

df = sqlContext.read \
    .format("jdbc") \
    .option("url", "jdbc:mysql://mysql:3306") \
    .option("driver", "org.mariadb.jdbc.Driver") \
    .option("dbtable", "testing_db.bm") \
    .option("user", "bruno") \
    .option("password", "password") \
    .load()

df.show()

sc.stop()
