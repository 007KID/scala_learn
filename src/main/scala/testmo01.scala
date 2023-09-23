
import com.mongodb.spark.MongoSpark
import org.apache.spark.{SparkConf, SparkContext}
import com.mongodb.spark.config._
import org.apache.spark.sql._
object testmo01 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
      .setAppName("ProcessEmployee")
      .setMaster("local[*]")
    val sc = new SparkContext(sparkConf)
    val user = SparkSession.builder
      .config("spark.mongodb.input.uri",
        "mongodb://127.0.0.1:27017/school_info.test")
      .config("spark.mongodb.output.uri",
        "mongodb://127.0.0.1:27017/school_info.test").getOrCreate()


//    val   df=user.read.format("mongodb://127.0.0.1:27017").option("database","school_info").option("collection","test").load()
//    df.show()
    val df= MongoSpark.load(user)
    df.printSchema()
sc.stop()
  }
}
