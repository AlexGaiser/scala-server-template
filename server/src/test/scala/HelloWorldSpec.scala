import org.scalatest.flatspec.AnyFlatSpec
import specs.UnitTestSpec

class HelloWorldSpec extends UnitTestSpec {

  "An empty Set" should "have size 0" in {
    assert(Set().isEmpty)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set().head
    }
  }

  "True" should "be True" in {
    true shouldBe true
  }
}
