package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

    def factorial(n: Int): Int = {
      def loop(acc: Int, n: Int): Int =
        if(n == 0) acc
        else loop(acc * n, n - 1)
      loop(1, n)
    }
  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      factorial(r) / (factorial(r-c) * factorial(c))
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def func(chars: List[Char], brackets: Int): Boolean =
        if(chars.isEmpty) {
          brackets == 0
        }
        else {
          val char = chars.head
          val openOrClose =
            if (char == '(') brackets + 1
            else if (char == ')') brackets - 1
            else brackets
          if (openOrClose >= 0) func(chars.tail, openOrClose)
          else false
        }
      func(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money == 0) 1
      else if(money >= 0 && !coins.isEmpty)
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else 0
    }
  }
