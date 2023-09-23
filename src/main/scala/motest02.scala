import org.mongodb.scala._

object motest02 {

  def main(args: Array[String]): Unit = {
    val uri: String = "mongodb://127.0.0.1:27017/school_info.test?retryWrites=true&w=majority"
    System.setProperty("org.mongodb.async.type", "netty")
    val client: MongoClient = MongoClient(uri)
    val db: MongoDatabase = client.getDatabase("school_info")
  }



}
