trait Expr

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr

object main {
  def show(e: Expr): String = e match {
    case Number(n) => n.toString()
    case Sum(l, r) => show(l) + " + " + show(r)
  }

  def main(args: Array[String]): Unit = {
    val x = show(Sum(Number(1), Number(2)))
    println(x)
  }
}