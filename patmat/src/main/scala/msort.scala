object main {
  def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
    val n = xs.length / 2
    if(n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => {
          if(lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
        }
      }
      val (first, second) = xs splitAt n
      merge(msort(first)(lt), msort(second)(lt))
    }
  }
  
  def main(args: Array[String]): Unit = {
    val nums = List(-4, 0, 5, 3, 4)
    val snums = msort(nums)((x: Int, y: Int) => x < y)
    println(snums)
  }
}
