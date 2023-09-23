import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object test04_sock {
//  def main(args: Array[String]): Unit = {
//    val sparkconf = new SparkConf().setMaster("local[*]").setAppName("sparkstreaming")
//
//    val ssc = new StreamingContext(sparkconf, Seconds(3))
//    val kafkaPara:Map[String,Object]=Map(
//      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG->"localhost:9092",
//      ConsumerConfig.GROUP_ID_CONFIG->"test",
//      "key.deserializer" ->
//        "org.apache.kafka.common.serialization.StringDeserializer",
//      "value.deserializer" ->
//        "org.apache.kafka.common.serialization.StringDeserializer"
//      )
//    val kafakaDataDS = KafkaUtils.createDirectStream[String, String](
//      ssc,
//      LocationStrategies.PreferConsistent,
//      ConsumerStrategies.Subscribe[String, String](Set("test"), kafkaPara)
//
//    )
////    kafakaDataDS.map(_.value()).print()
//
//
//    ssc.start()
//    ssc.awaitTermination()
//  }

}
