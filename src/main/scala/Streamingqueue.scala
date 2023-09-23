import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

object Streamingqueue {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("sparkstreaming")

    val ssc = new StreamingContext(sparkconf, Seconds(3))
    val rddQueue = new mutable.Queue[RDD[Int]]()
    val  inputStream=ssc.queueStream(rddQueue,oneAtATime = false)
    val mappedStream =inputStream.map((_,1))
    val reduceStream =mappedStream.reduceByKey(_+_)
    reduceStream.print()
    ssc.start()
    for (i <- 1 to 5){
      rddQueue+=ssc.sparkContext.makeRDD(1 to 30,10)
      Thread.sleep(2000)
    }
    ssc.awaitTermination()
  }
}
