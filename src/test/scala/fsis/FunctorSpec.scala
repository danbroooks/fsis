package fsis

import org.scalatest._

class FunctorSpec extends FreeSpec with Matchers {

  "listFunctor" - {
    "provides map for lists" in {
      implicitly[Functor[List]].map(List(1, 2, 3))(_ + 10) should be(List(11, 12, 13))
    }
  }

  "optionFunctor" - {
    "provides map for options" in {
      implicitly[Functor[Option]].map(Some(3))(_ + 10) should be(Some(13))
    }
  }

  "function1Functor" - {
    "provides map for unary functions" in {
      implicitly[Functor[Int => ?]].map(_ + 1)(_ + 3)(5) should be(9)
    }
  }
}
