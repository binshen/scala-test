object WordCount {

  def main(args: Array[String]): Unit = {
    val list: List[String] = List("hello world hello world hello spark", "hehe spark hehe hadoop", "hi spark hi hadoop")
    //1.数据切分
    //第一种方法
    val splitdata: List[Array[String]] = list.map(x => x.split(" "))
    val words1: List[String] = splitdata.flatten
    println("第一种切分方法：" + words1)

    //第二种方法
    val words: List[String] = list.flatMap(x => x.split(" "))
    println("第二种切分方法：" + words)

    //2.组装（单词，1）这种形式
    val wordsAndOne = words.map(x => (x, 1))
    println("组装：" + wordsAndOne)

    //分组，按照单词来分组，生成对应的map
    val groupdata: Map[String, List[(String, Int)]] = wordsAndOne.groupBy(word => word._1)
    println("分组：" + groupdata)

    val result: Map[String, Int] = groupdata.map(tp => {
      //一段代码搞定不来，就来{}
      //获取每个单词对应的集合
      val list: List[(String, Int)] = tp._2
      //将每个单词对应的次数取出来
      val counts: List[Int] = list.map(t => t._2)
      (tp._1, counts.sum)
    })
    println("结果：" + result)
    val res: List[(String, Int)] = result.toList.sortBy(_._2).reverse
    println("排序最终结果-第一种方法：")
    //第一种方法
    res.foreach(t => {
      println(t._1 + "," + t._2)
    })
    //第二种方法
    println("排序最终结果-第二种方法：")
    res.foreach((tp: (String, Int)) => println(tp))
    //第三种方法
    println("排序最终结果-第三种方法：")
    res.foreach(tp => println(tp))
    //在函数中，如果参数只使用一次，那么可以用_来代替
    //第四种方法
    println("排序最终结果-第四种方法：")
    res.foreach(println(_))
    //第五种方法
    println("排序最终结果-第五种方法：")
    res.foreach(println)
  }
}
