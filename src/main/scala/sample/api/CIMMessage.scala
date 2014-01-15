
package sample.api

trait CIMMessage {
  def messageType: String
  def version: String
}

trait CIMRequest extends CIMMessage {
  def requestHeader: Headers
}

case class CreateCIM(version: String, requestHeader: Headers = Map.empty[String, String], override val messageType: String = "REQUEST") extends CIMRequest with MapRepresentable

private[sample] object CreateCIM {
  def apply(map: Map[String, Any]): CreateCIM = CreateCIM(version = map("version").toString, requestHeader = toStringStringMap(map("request-header")))
}

