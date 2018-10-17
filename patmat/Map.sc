val maps = Map("Switzerland" -> "Bern", "US" -> "Washington")

def capitalOfCountry(country: String) = maps.get(country) match {
  case Some(capital) => capital
  case None  => "Missing Data"
}

capitalOfCountry("US")


capitalOfCountry("Andorra")


val fruit = List("apple", "pear", "orange", "pine apple")

fruit.groupBy(_.head)



class Poly(terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0.withDefaultValue(0.0)

  def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))

  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }

  override def toString: String =
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield (coeff +  "x^" + exp)) mkString "+"
}

val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 4 -> 6.2)
val p2 = new Poly(0 -> 3.0, 3 -> 7.0)

p1 + p2

