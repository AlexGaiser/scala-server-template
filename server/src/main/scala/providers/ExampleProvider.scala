package providers

import com.twitter.util.Future
import models.jsonplaceholder.User
import modules.providers.ExampleClientModule

import javax.inject.Inject
import scala.concurrent.ExecutionContext


case class ExampleProvider @Inject()(exampleClient: ExampleClientModule)(implicit executionContext: ExecutionContext) {
  def exampleValue(): Future[User] = {
    exampleClient.jsonPlaceholderClient().getUserById(1)
  }
}

