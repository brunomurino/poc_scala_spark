package impl

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Impl {

  def implementation(spark: SparkSession) {
    val logFile = "/root/service/resources/pp-complete.csv"

    val sc = spark.sparkContext

    val raw_df = spark.read
      .format("csv")
      .option("header", "false")
      .load(logFile)
      .toDF(
        "transaction_id",
        "price",
        "date_of_transfer",
        "postcode",
        "property_type",
        "old_new",
        "duration",
        "paon",
        "saon",
        "street",
        "locality",
        "town_city",
        "district",
        "county",
        "ppd_category_type",
        "record_status",
      )

    val df = raw_df.withColumn("date_of_transfer", col("date_of_transfer").cast("timestamp"))

    val df2 = df
      .withColumn("year", year(col("date_of_transfer")))
      .withColumn("price", col("price").cast("Int"))

    df2
      .groupBy("year")
      .agg(
        (sum("price")/1e9).alias("total_price"),
        (count("*")).alias("number_of_transactions"),
      )
      .orderBy(col("year").desc)
      .show()
  }

}