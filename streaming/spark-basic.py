# spark-basic.py
import os
from pyspark import SparkConf
from pyspark import SparkContext
import numpy as np
os.environ["PYSPARK_PYTHON"] = "/usr/bin/python3"
os.environ["PYSPARK_DRIVER_PYTHON"] = "/usr/bin/python3"

conf = SparkConf()
conf.setMaster('spark://spark-master:7077')
conf.setAppName('spark-basic')
sc = SparkContext(conf=conf)


def mod(x):
    return (x, np.mod(x, 2))


rdd = sc.parallelize(range(1000)).map(mod).take(10)
print(rdd)
