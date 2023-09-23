import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.util.Random

object test03 {
  def main(args: Array[String]): Unit = {
    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("sparkstreaming")

    val ssc = new StreamingContext(sparkconf, Seconds(3))
    val messageDS = ssc.receiverStream(new myrecever())
    messageDS.print()
    ssc.start()
    ssc.awaitTermination()
  }
  class  myrecever extends  Receiver[String](StorageLevel.MEMORY_ONLY){
    private var flg=true
    override def onStart(): Unit = {
      new Thread(new Runnable {
        override def run(): Unit = {
          while (flg) {

            val message = "采集的数据是:" + new Random().nextInt(10)
            store(message)
            Thread.sleep(500)

          }
        }
      }).start()

    }

    override def onStop(): Unit = {
      flg=false
    }


  }

}
