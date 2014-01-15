
package sample.api

case class Query(fields: Fields = List.empty[String]) extends MapRepresentable

private[sample] object Query {
  def apply(map: Map[String, Any]): Query = Query(fields = map("fields").asInstanceOf[List[String]])
}


