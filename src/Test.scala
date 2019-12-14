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
  }
}
