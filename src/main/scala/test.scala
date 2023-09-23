import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming._
object test {
  def main(args: Array[String]): Unit = {
//    Logger.getLogger("org").setLevel(Level.OFF)
//    Logger.getLogger("akka").setLevel(Level.OFF)
    new SparkConf().setAppName("ttt")

     val conf=new SparkConf().setAppName("test").setMaster("local[*]")
     val sc=new SparkContext(conf)
//    sc.textFile("D:/Mycode/scala_learn/file/log1.txt").foreach(x=>print(x))
     val ssc=  new StreamingContext(sc,Seconds(20))
    val lines=ssc.textFileStream("file:///D:/Mycode/scala_learn/file/log1.txt")
    lines.foreachRDD(x=>println)
    val words=lines.flatMap(_.split(" "))
    words.print()
    val wordcount=words.map(x=>(x,1)).reduceByKey(_+_)
    wordcount.print()
    ssc.start()
    ssc.awaitTermination()






  }

}
