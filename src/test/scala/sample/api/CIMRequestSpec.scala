
package sample.api

import sample.SpecBase
import org.specs2.execute.Result

class CIMRequestSpec extends SpecBase {
  val Version = "1.0"
  val testHeader = Map("header1" -> "val1")
  val query = Query(List("f1", "f2"))

  private def check(map: Map[String, Any], op: String, targetName: String = "target"): Result = {
    map.contains("version") must be_==(true)
    map("version") must be_==(Version)
    map.contains("request-header") must be_==(true)
    map("request-header").isInstanceOf[Map[_,_]] must be_==(true)
  }

  "A CIM requests " should {
    "contains CreateCIM which is convertable to Map[String, Any]" in {
      val create = CreateCIM(Version, testHeader)
      val map = create.toMap
      check(map, "CREATE")
    }
  }

}
