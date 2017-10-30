package fsis

import org.scalatest._

class FunctorSpec extends FreeSpec with Matchers {
  "listFunctor" - {
    "provides map for lists" in {
      Functor[List].map(List(1, 2, 3))(_ + 10) should be(List(11, 12, 13))
    }

    "can lift an operation into the context of a list" in {
      Functor[List].lift((_:Int) + 1)(List(1, 2, 3)) should be (List(2, 3, 4))
    }

    "can have its values replaced with as" in {
      Functor[List].as(List(1, 2, 3), 10) should be (List(10, 10, 10))
    }

    "can be voided" in {
      Functor[List].void(List(1, 2, 3)) should be (List((), (), ()))
    }
  }

  "optionFunctor" - {
    "provides map for options" in {
      Functor[Option].map(Some(3))(_ + 10) should be(Some(13))
    }

    "can lift an operation into the context of an option" in {
      Functor[Option].lift((_:Int) + 1)(Some(1)) should be (Some(2))
    }

    "can have its values replaced with as" in {
      Functor[Option].as(Some(1), 10) should be (Some(10))
    }

    "can be voided" in {
      Functor[Option].void(Some(40)) should be (Some(()))
    }
  }

  "function1Functor" - {
    "provides map for unary functions" in {
      Functor[Int => ?].map(_ + 1)(_ + 3)(5) should be(9)
    }

    "can lift an operation into the context of a unary function" in {
      Functor[Int => ?].lift((_: Int) + 1)((_: Int) + 1)(5) should be (7)
    }

    "can have its values replaced with as" in {
      Functor[Int => ?].as(_ + 1, 50)(70) should be (50)
    }

    "can be voided" in {
      Functor[Int => ?].void(_ + 10)(10) should be (())
    }
  }

  "compose" - {
    "functors can be composed together" in {
      (Functor[List] compose Functor[Option]).map(List(Some(10), None, Some(15)))(_ + 10) should be(List(Some(20), None, Some(25)))
    }
  }
}
