import scala.collection.mutable.ArrayBuffer
import scala.math._

object Test {

  def main(args: Array[String]): Unit = {

    val speech =
      """Four score and
        |seven years ago
        |our fathers""".stripMargin.replaceAll("\n", " ")
    println(speech)

    var num = 1.+(2)
    println(num)

    println(sqrt(2))

    println("Hello".distinct)

    println("Hello"(4))
    println("Hello".apply(4))

    val nums = new ArrayBuffer[Int]()
    nums += 1
    nums += (1, 2, 3, 5)
    nums.foreach(print(_))

    for (i <- 0 until nums.length) {
      println(nums(i))
    }

    val result = for (i <- 0 until nums.length) yield i * 2
    println(result)

    var aaa = getMiddle(Array("Mary", "had", "a", "little", "lamb"))
    println(aaa)
  }

  def getMiddle[T](a: Array[T]) = a (a.length / 2)
}
