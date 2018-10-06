object main {
  val f = new function1[Int, Int] {
    def apply(x: Int) = x * x
  }
  f.apply(7)
}