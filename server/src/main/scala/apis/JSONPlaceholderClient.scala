package apis

import com.twitter.finagle.{Http, Service, http}
import com.twitter.finatra.jackson.modules.ScalaObjectMapperModule
import com.twitter.util.Future
import com.twitter.util.jackson.ScalaObjectMapper
import models.jsonplaceholder.User
import utils.SttpClient

import java.net.URL
import scala.concurrent.ExecutionContext

object JSONPlaceholderClient {
  val baseUrl: String =  "https://jsonplaceholder.typicode.com"
}

class JSONPlaceholderClient()(implicit executionContext: ExecutionContext) {

  import JSONPlaceholderClient._

  def getUserById(id: Int): Future[User] = {
    val url = new URL(s"$baseUrl/users/$id")
    SttpClient().get[User](url)
  }
}

