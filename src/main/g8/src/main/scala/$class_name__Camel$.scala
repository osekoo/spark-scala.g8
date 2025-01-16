import org.apache.spark.sql.SparkSession

object $class_name;
format = "Camel" $ {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("Word Count")
      .getOrCreate() // create a Spark session

    spark.sparkContext.setLogLevel("ERROR")  // set the log level to ERROR (possible values: ALL, DEBUG, ERROR, FATAL, INFO, OFF, TRACE, WARN)

    val size = args(0).toInt // number of lines to generate
    wordCount(spark, size) // call the wordCount function

    spark.stop() // stop the Spark session
  }

  private def wordCount(spark: SparkSession, size: Int): Unit = {
    val fruits = Seq("apple", "banana", "carrot", "orange", "kiwi", "melon", "pineapple") // list of fruits
    val colors = Seq("red", "yellow", "orange", "green", "brown", "blue", "purple") // list of colors
    // pick between 5 and 15 colored fruits randomly as one item of a seq and repeat them 1000 times to create a dataset
    val data = (1 to size).map(_ => (1 to scala.util.Random.nextInt(10) + 5).map(_ => s"\${colors(scala.util.Random.nextInt(colors.length))} \${fruits(scala.util.Random.nextInt(fruits.length))}").mkString(", "))

    // print the first 10 items of the dataset
    println("\n============================ Dataset ============================")
    data.take(10).foreach(println)
    println("=================================================================\n")

    // create an RDD from the dataset
    val rdd = spark.sparkContext.parallelize(data)
    val wordCounts = rdd
      .flatMap(line => line.split("[ ,]")) // split each line into words
      .filter(word => word.nonEmpty) // filter out empty words
      .map(word => (word, 1)) // create a tuple of (word, 1)
      .reduceByKey((a, b) => a + b) // sum the counts
      .sortBy(a => a._2, ascending = false) // sort by count in descending order

    println("\n============================ Word count result ============================")
    wordCounts.collect().foreach(println) // print the result
    println("===========================================================================\n")

  }
}
