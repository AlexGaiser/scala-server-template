package controllers

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.util.Await
import providers.{ExampleProvider}

import javax.inject.Inject

case class ExampleController @Inject()(exampleProvider: ExampleProvider) extends Controller {
  get("/ping") { request: Request => "pong" }
  get("/example") {
    request:Request => exampleProvider.exampleValue()
  }
}
