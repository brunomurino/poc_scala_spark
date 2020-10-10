package entrypoint

import org.apache.spark.sql.SparkSession

import helpers.Helpers.{withSparkSession}
import impl.Impl.{implementation}

object Entrypoint {
  def main(args: Array[String]) {

    println("Hello")

    val sparkSessionBuilder =
      SparkSession.builder
      // .master("local[8]")
      .master("spark://spark-master:7077")
      .appName("Simple Application")
    
    withSparkSession(sparkSessionBuilder) { spark => implementation(spark) }

  }
}
