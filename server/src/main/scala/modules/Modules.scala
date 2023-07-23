package modules

import com.google.inject.Module
import modules.executioncontext.ExecutionContextModule
import modules.providers.ExampleClientModule

import scala.concurrent.ExecutionContext

object Modules {

  def apply()(implicit ec: ExecutionContext): List[Module] = List(
    new ExecutionContextModule(),
    new ExampleClientModule(),
  )
}
