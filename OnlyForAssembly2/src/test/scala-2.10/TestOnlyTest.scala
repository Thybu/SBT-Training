/**
  * Created by myousuff on 24.08.17.
  */

import org.scalatest._

class TestOnlyTest extends FunSuite with BeforeAndAfterEach with BeforeAndAfterAll {

   override def beforeEach(): Unit = {

    println("beforeEach")

  }


  override def afterEach() {

    println("afterEach")

  }


  override def beforeAll() {

    println("beforeAll")

  }


  override def afterAll() {

    println("afterAll")

  }


  test("test something") {

    println("inside the test")

    assert(1 === (3 - 2))

  }


  test("test something else") {

    println("inside the test")

    assert(2 > 1)

  }

}
