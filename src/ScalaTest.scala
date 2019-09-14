import java.io.{FileNotFoundException, FileReader, IOException}

import scala.io.{Source, StdIn}
import scala.util.matching.Regex

object ScalaTest {

  def addInt( a:Int, b:Int ) : Int = {
    var sum:Int = 0
    sum = a + b
    return sum
  }

  //定义一个方法
  //方法 m1 参数要求是一个函数，函数的参数必须是两个Int类型
  //返回值类型也是Int类型
  def m1(f:(Int,Int) => Int) : Int = {
    f(2,6)
  }

  //定义一个函数f1,参数是两个Int类型，返回值是一个Int类型
  val f1 = (x:Int,y:Int) => x + y
  //再定义一个函数f2
  val f2 = (m:Int,n:Int) => m * n

  // Scala中val定义函数，def定义方法

  def do_test_a: Unit = {
    //调用m1方法，并传入f1函数
    val r1 = m1(f1)

    println(r1)

    //调用m1方法，并传入f2函数
    val r2 = m1(f2)
    println(r2)
  }

  def ttt(f:Int => Int):Unit = {
    val r = f(10)
    println(r)
  }

  val f0 = (x : Int) => x * x

  //定义了一个方法
  def m0(x:Int) : Int = {
    //传递进来的参数乘以10
    x * 10
  }

  //将方法转换成函数，利用了神奇的下滑线
  val f3 = m0 _

  def do_test_b: Unit = {
    ttt(f3)

    //通过m0 _将方法转化成函数
    ttt(m0 _);

    //如果直接传递的是方法名称，scala相当于是把方法转成了函数
    ttt(m0)

    //通过x => m0(x)的方式将方法转化成函数,这个函数是一个匿名函数，等价：(x:Int) => m0(x)
    ttt(x => m0(x))
  }

  //闭包
  var factor = 3
  val multiplier = (i:Int) => i * factor

  def main(args: Array[String]): Unit = {

    println("Hello, world!")

    println("-------------------------------------------------------")

    do_test_1

    println("-------------------------------------------------------")

    do_test_2

    println("-------------------------------------------------------")

    do_test_3

    println("-------------------------------------------------------")

    do_test_4

    println("-------------------------------------------------------")

    def m(x: Int) = x + 3
    val f = (x: Int) => x + 3

    println("-------------------------------------------------------")

    println("Returned Value : " + addInt(5, 7))

    println("-------------------------------------------------------")

    do_test_a

    println("-------------------------------------------------------")

    do_test_b

    println("-------------------------------------------------------")

    println( "muliplier(1) value = " +  multiplier(1) )
    println( "muliplier(2) value = " +  multiplier(2) )

    println("-------------------------------------------------------")

    do_test_5

    println("-------------------------------------------------------")

    val palindrome = "www.runoob.com"
    val len = palindrome.length
    println("String Length is : " + len)

    println("-------------------------------------------------------")

    val str1 = "菜鸟教程官网："
    val str2 = "www.runoob.com"
    val str3 = "菜鸟教程的 Slogan 为："
    val str4 = "学的不仅是技术，更是梦想！"
    println(str1 + str2)
    println(str3.concat(str4))

    println("-------------------------------------------------------")

    var floatVar = 12.456
    var intVar = 2000
    var stringVar = "菜鸟教程!"
    var fs = printf("浮点型变量为 " +
      "%f, 整型变量为 %d, 字符串为 " +
      " %s", floatVar, intVar, stringVar)
    println(fs)

    println("-------------------------------------------------------")

    do_test_6

    println("-------------------------------------------------------")

    do_test_7

    println("-------------------------------------------------------")

    var myList1 = Array(1.9, 2.9, 3.4, 3.5)
    var myList2 = Array(8.9, 7.9, 0.4, 1.5)
    var myList3 =  Array.concat( myList1, myList2)
    // 输出所有数组元素
    for ( x <- myList3 ) {
      println( x )
    }

    println("-------------------------------------------------------")

    var myList4 = Array.range(10, 20, 2)
    var myList5 = Array.range(10,20)

    // 输出所有数组元素
    for ( x <- myList4 ) {
      print( " " + x )
    }
    println()
    for ( x <- myList5 ) {
      print( " " + x )
    }

    println("-------------------------------------------------------")

    // 定义整型 List
    val x1 = List(1,2,3,4)

    // 定义 Set
    val x2 = Set(1,3,5,7)

    // 定义 Map
    val x3 = Map("one" -> 1, "two" -> 2, "three" -> 3)

    // 创建两个不同类型元素的元组
    val x4 = (10, "Runoob")

    // 定义 Option
    val x5:Option[Int] = Some(5)

    println("-------------------------------------------------------")

    val it = Iterator("Baidu", "Google", "Runoob", "Taobao")
    while (it.hasNext){
      println(it.next())
    }

    println("-------------------------------------------------------")

    val ita = Iterator(20,40,2,50,69, 90)
    val itb = Iterator(20,40,2,50,69, 90)
    println("最大元素是：" + ita.max )
    println("最小元素是：" + itb.min )

    println("-------------------------------------------------------")

    val itc = Iterator(20,40,2,50,69, 90)
    val itd = Iterator(20,40,2,50,69, 90)

    println("ita.size 的值: " + itc.size )
    println("itb.length 的值: " + itd.length )

    println("-------------------------------------------------------")

    val pt = new Point(10, 20)
    // 移到一个新的位置
    pt.move(10, 10)

    println("-------------------------------------------------------")

    val loc: Location = new Location(10, 20, 15)
    // 移到一个新的位置
    loc.move(10, 10, 5)

    println("-------------------------------------------------------")

    println(do_test_8(3))


    println("-------------------------------------------------------")

    println(matchTest("two"))
    println(matchTest("test"))
    println(matchTest(1))
    println(matchTest(6))

    println("-------------------------------------------------------")

    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) =>
          println("Age: " + age + " year, name: " + name + "?")
      }
    }

    println("-------------------------------------------------------")

    val pattern = "Scala".r
    val str = "Scala is Scalable and cool"
    println(pattern findFirstIn str)

    println("-------------------------------------------------------")

    val pattern_2 = new Regex("(S|s)cala")  // 首字母可以是大写 S 或小写 s
    val str_2 = "Scala is scalable and cool"
    println((pattern_2 findAllIn str_2).mkString(","))   // 使用逗号 , 连接返回结果

    println("-------------------------------------------------------")

    val pattern_3 = new Regex("abl[ae]\\d+")
    val str_3 = "ablaw is able1 and cool"
    println((pattern_3 findAllIn str_3).mkString(","))

    println("-------------------------------------------------------")

    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException =>{
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    }

    println("-------------------------------------------------------")

    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }

    println("-------------------------------------------------------")

    println("Apply 方法 : " + apply("Zara", "gmail.com"))
    println("Unapply 方法 : " + unapply("Zara@gmail.com"))
    println("Unapply 方法 : " + unapply("Zara Ali"))

    println("-------------------------------------------------------")

    import java.io._
    val writer = new PrintWriter(new File("test.txt" ))
    writer.write("菜鸟教程")
    writer.close()

    println("-------------------------------------------------------")

    print("请输入菜鸟教程官网 : " )
    val line = StdIn.readLine()
    println("谢谢，你输入的是: " + line)

    println("-------------------------------------------------------")

    println("文件内容为:" )
    Source.fromFile("src/ScalaAppTest.scala" ).foreach{
      print
    }

    println("-------------------------------------------------------")
  }

  // 样例类
  case class Person(name: String, age: Int)


  // 注入方法 (可选)
  def apply(user: String, domain: String) = {
    user +"@"+ domain
  }

  // 提取方法（必选）
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2){
      Some(parts(0), parts(1))
    }else{
      None
    }
  }



  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }

  def do_test_1: Unit = {
    val a = 10
    val b = 20

    println("a == b = " + (a == b))
    println("a != b = " + (a != b))
    println("a > b = " + (a > b))
    println("a < b = " + (a < b))
    println("b >= a = " + (b >= a))
    println("b <= a = " + (b <= a))
  }

  def do_test_2: Unit = {
    val c = true
    val d = false

    println("a && b = " + (c && d))
    println("a || b = " + (c || d))
    println("!(a && b) = " + !(c && d))
  }

  def do_test_3: Unit = {
    val a = 60
    /* 60 = 0011 1100 */
    val b = 13
    /* 13 = 0000 1101 */
    var c = 0

    c = a & b /* 12 = 0000 1100 */
    println("a & b = " + c)

    c = a | b /* 61 = 0011 1101 */
    println("a | b = " + c)

    c = a ^ b /* 49 = 0011 0001 */
    println("a ^ b = " + c)

    c = ~a /* -61 = 1100 0011 */
    println("~a = " + c)

    c = a << 2 /* 240 = 1111 0000 */
    println("a << 2 = " + c)

    c = a >> 2 /* 15 = 1111 */
    println("a >> 2  = " + c)

    c = a >>> 2 /* 15 = 0000 1111 */
    println("a >>> 2 = " + c)
  }

  def do_test_4: Unit = {
    var a = 10
    val b = 20
    var c = 0

    c = a + b
    println("c = a + b  = " + c)

    c += a
    println("c += a  = " + c)

    c -= a
    println("c -= a = " + c)

    c *= a
    println("c *= a = " + c)

    a = 10
    c = 15
    c /= a
    println("c /= a  = " + c)

    a = 10
    c = 15
    c %= a
    println("c %= a  = " + c)

    c <<= 2
    println("c <<= 2  = " + c)

    c >>= 2
    println("c >>= 2  = " + c)

    c >>= a
    println("c >>= a  = " + c)

    c &= a
    println("c &= 2  = " + c)

    c ^= a
    println("c ^= a  = " + c)

    c |= a
    println("c |= a  = " + c)
  }


  def do_test_5: Unit = {
    val buf = new StringBuilder;
    buf += 'a'
    buf ++= "bcdef"
    buf ++= "ghijk"
    buf.append("lmnop")
    println( "buf is : " + buf.toString );
  }

  def do_test_6: Unit = {
    var myList = Array(1.9, 2.9, 3.4, 3.5)

    // 输出所有数组元素
    for ( x <- myList ) {
      println( x )
    }

    // 计算数组所有元素的总和
    var total = 0.0;
    for ( i <- 0 to (myList.length - 1)) {
      total += myList(i);
    }
    println("总和为 " + total);

    // 查找数组中的最大元素
    var max = myList(0);
    for ( i <- 1 to (myList.length - 1) ) {
      if (myList(i) > max) max = myList(i);
    }
    println("最大值为 " + max);
  }


  def do_test_7: Unit = {
    var myMatrix = Array.ofDim[Int](3,3)

    // 创建矩阵
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }

    // 打印二维阵列
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }
  }

  def do_test_8(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
}

class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println ("x 的坐标点 : " + x);
    println ("y 的坐标点 : " + y);
  }
}

class Location(override val xc: Int, override val yc: Int,
               val zc :Int) extends Point(xc, yc){
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
    x = x + dx
    y = y + dy
    z = z + dz
    println ("x 的坐标点 : " + x);
    println ("y 的坐标点 : " + y);
    println ("z 的坐标点 : " + z);
  }
}