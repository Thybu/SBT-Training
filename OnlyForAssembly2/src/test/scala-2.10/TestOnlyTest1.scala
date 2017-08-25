/**
  * Created by myousuff on 24.08.17.
  */

import org.scalatest._

class TestOnlyTest1 extends FunSuite with BeforeAndAfterEach with BeforeAndAfterAll {

  override def beforeEach(): Unit = {

    println("beforeEach1")

  }


  override def afterEach() {

    println("afterEach1")

  }


  override def beforeAll() {

    println("beforeAll1")

  }


  override def afterAll() {

    println("afterAll1")

  }


  test("test something1") {

    println("inside the test1")

    assert(1 === (3 - 2))

  }


  test("test something else1") {

    println("inside the test1")

    assert(2 > 1)

  }

}
