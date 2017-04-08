package fsis

import org.scalatest._

class FunctorSpec extends FreeSpec with Matchers {

  "listFunctor" - {
    "provides map for lists" in {
      Functor.listFunctor.map(List(1, 2, 3))(_ + 10) should be(List(11, 12, 13))
    }
  }

  "optionFunctor" - {
    "provides map for options" in {
      Functor.optionFunctor.map(Some(3))(_ + 10) should be(Some(13))
    }
  }
}
