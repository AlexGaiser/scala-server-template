package modules.executioncontext

import com.google.inject.Provides
import com.twitter.inject.TwitterModule

import javax.inject.Singleton
import scala.concurrent.ExecutionContext

class ExecutionContextModule(implicit executionContext: ExecutionContext) extends TwitterModule {
  @Provides
  @Singleton
  def defaultContext: ExecutionContext = executionContext
}
