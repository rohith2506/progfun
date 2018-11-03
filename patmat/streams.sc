val xs = Stream.cons(1, Stream.cons(2, Stream.empty))

val xs1 = Stream(1,2,3,4)


def streamRange(lo: Int, hi: Int): Stream[Int] = {
  print(lo + " ")
  if(lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))
}

streamRange(1, 10).take(3).toList


def from(n: Int): Stream[Int] = n #:: from(n + 1)


val nats = from(2)
val m4s = nats map (_ * 4)

def sieve(s: Stream[Int]): Stream[Int] =
  s.head #:: sieve(s.tail filter (_ % s.head != 0))

(sieve(nats) take 10000).toList