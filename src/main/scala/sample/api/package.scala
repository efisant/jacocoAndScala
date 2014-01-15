
package sample

package object api {
  type Headers = Map[String, String]
  type MessageBody = Map[String, Any]
  type Fields = List[String]

  implicit def toScalaMap(map: Any): Map[String, Any] =
    if (map.isInstanceOf[scala.collection.mutable.Map[_, _]])
      map.asInstanceOf[scala.collection.mutable.Map[String, Any]].toMap
    else map.asInstanceOf[Map[String, Any]]

  def toStringStringMap(map: Any): Map[String, String] =
    if (map.isInstanceOf[scala.collection.mutable.Map[_, _]])
      map.asInstanceOf[scala.collection.mutable.Map[String, String]].toMap
    else map.asInstanceOf[Map[String, String]]
}
