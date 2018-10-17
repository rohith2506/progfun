val nums = Vector(1, 2, 3)

val nums2 = Vector(3, 4, 5)

nums +: nums2

val r : Range = 1 until 5

val x : Range = 1 to 33 by -7

val S = "Hello World"

S exists (c => c.isUpper)

S forall (c => c.isUpper)


val x1 = List(1,2,3) zip S


S flatMap (c => List('.', c))


def ScalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  (xs zip ys).map(xy => xy._1 * xy._2).sum


ScalarProduct(Vector(1,2,3), Vector(3,4,5))


def isPrime(n: Int): Boolean =
  (2 until n) forall ( d => n % d != 0)

isPrime(32)



val n = 7

(1 until n) flatMap ( i => (1 until i) map ( j => ( i, j) ) ) filter (pair => isPrime(pair._1 + pair._2))



val ss = Set(1,2,3)

ss map (x => x * 2)

val sss = Set(List(1), List(2))

val dump = Vector.fill(4)('*').updated(2, 'X' ).mkString
"\n"

