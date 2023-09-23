import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object streamingtest {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("sparkstreaming")

    val ssc = new StreamingContext(sparkconf, Seconds(3))
    val lines = ssc.socketTextStream("localhost", 9000)
    val words=lines.flatMap(_.split(" "))
    val wordtoOne = words.map((_, 1))
    val word_count=wordtoOne.reduceByKey(_+_)
    word_count.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
