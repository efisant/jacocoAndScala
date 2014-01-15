
package sample.api

private[sample] trait MapRepresentable {
  self: Product =>

  private def getCCParams(cc: Product) : Map[String, Any] = {
    def retrieveValue(value: Any): Any = value match {
      case p: Product if !p.isInstanceOf[List[_]] => getCCParams(p)
      case _ => value
    }
    def convertCamelCaseToDash(name: String) = "[A-Z\\d]".r.replaceAllIn(name, {m => "-" + m.group(0).toLowerCase})

    val values = cc.productIterator
    cc.getClass.getDeclaredFields.map(field => convertCamelCaseToDash(field.getName) -> retrieveValue(values.next)).toMap
  }

  def toMap[T]: Map[String, Any] = getCCParams(self) //macro Macros.toMap_impl[T]
}
