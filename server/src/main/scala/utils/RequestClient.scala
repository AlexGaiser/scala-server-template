package utils

import com.twitter.util.Future
import sttp.client3._
import sttp.client3.akkahttp._
import sttp.client3.json4s._

import java.net.URL
import scala.concurrent.ExecutionContext

trait HttpClient {
  def get[T](url: URL): Future[T]
}

case class SttpClient()(implicit executionContext: ExecutionContext) {
  val backend = AkkaHttpBackend()

  def get[T](url: URL)(implicit ev: scala.reflect.Manifest[T]): Future[T] = {
    val request = basicRequest.get(uri"${url.toString}").responseGetRight
    val response = FutureUtils.RichScalaFuture(request.send(backend)).asTwitter
    for {
      r <- response
    } yield {
      JsonUtil.fromJson[T](r.body)
    }
  }
}

case class RequestClient() {


}