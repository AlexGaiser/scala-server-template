package utils

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.twitter.finatra.jackson.modules.ScalaObjectMapperModule
import com.twitter.util.jackson.ScalaObjectMapper


object JsonUtil {
  val serializer: ScalaObjectMapper = (new ScalaObjectMapperModule).camelCaseObjectMapper
  serializer.registerModule(DefaultScalaModule)
  println(serializer.propertyNamingStrategy)

  def toJson(value: Map[Symbol, Any]): String = {
    toJson(value map { case (k, v) => k.name -> v })
  }

  def toJson(value: Any): String = {
    serializer.writeValueAsString(value)
  }

  def toMap[V](json: String)(implicit m: Manifest[V]) = fromJson[Map[String, V]](json)

  def fromJson[T](json: String)(implicit m: Manifest[T]): T = {
    serializer.parse[T](json)
  }
}