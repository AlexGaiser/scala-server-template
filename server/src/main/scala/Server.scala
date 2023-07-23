import com.google.inject.Module
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter
import controllers.ExampleController
import modules.Modules
import modules.server.CamelCaseJacksonModule

import scala.concurrent.ExecutionContext.Implicits.global

object ServerMain extends Server

class Server extends HttpServer {
  override val modules = Modules()

  override def configureHttp(router: HttpRouter): Unit = {
    router.add[ExampleController]
  }

  override def jacksonModule: Module = new CamelCaseJacksonModule()
}


