package consLists


trait List[T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
}

class cons[T](val head: T, val tail: List[T]) extends List[T] {
	def isEmpty = false
}

class Nil[T] extends List[T] {
	def isEmpty: Boolean = true
	def head: Nothing = throw new NoSuchElementException("Nil.head")
	def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object main {
	def nth[T](n: Int, xs: List[T]): T = {
		if(n == 0) xs.head
		else nth(n - 1, xs.tail)
	}
	val list = new cons(1, new cons(2, new cons(3, Nil)))
	nth(2, list)
}