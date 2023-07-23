package modules.providers


import apis.JSONPlaceholderClient
import com.google.inject.{Provides, Singleton}
import com.twitter.inject.TwitterModule

import scala.concurrent.ExecutionContext

class ExampleClientModule extends TwitterModule {

  @Singleton
  @Provides
  def jsonPlaceholderClient()(implicit executionContext: ExecutionContext) = {
    new JSONPlaceholderClient()
  }
}
