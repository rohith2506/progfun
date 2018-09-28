object rationals {
  val x = new Rational(1, 2)
  val y = new Rational(3, 4)
  val z = new Rational(5)

  x.add(y).toString
  x.sub(y).toString
  x.add(z).toString

  class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be non zero")

    private def gcd(a: Int, b: Int): Int =
      if(b == 0) a
      else gcd(b, a%b)

    private val g = gcd(x, y)

    def numer = x / g
    def denom = y / g

    def add(that: Rational): Rational = {
      return new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )
    }

    def this(x: Int) = this(x, 1)

    def less(that: Rational) =
      numer * that.denom < denom * that.numer

    def max(that: Rational) =
      if(this.less(that)) that else this

    def neg: Rational =
      new Rational(-numer, denom)

    def sub(that: Rational): Rational =
      add(that.neg)

    override def toString =
      numer + "/" + denom

  }
}

