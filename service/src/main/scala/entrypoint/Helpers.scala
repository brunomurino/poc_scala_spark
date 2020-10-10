package helpers

import org.apache.spark.sql.SparkSession

object Helpers {

  def withSparkSession
    (sparkSessionBuilder: SparkSession.Builder)
    (op: SparkSession => Unit)
    {
    val spark = sparkSessionBuilder.getOrCreate()
    try {
      op(spark)
    } finally {
      spark.stop()
    }
  }

}