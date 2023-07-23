package modules.server

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.twitter.finatra.jackson.modules.ScalaObjectMapperModule

class CamelCaseJacksonModule extends ScalaObjectMapperModule {

  override val propertyNamingStrategy: PropertyNamingStrategy =
    PropertyNamingStrategy.LOWER_CAMEL_CASE
}