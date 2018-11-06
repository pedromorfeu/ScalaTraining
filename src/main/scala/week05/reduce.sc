// Complete the following definitions of the basic functions
// map and length on lists, such that their implementation
// uses foldRight:
def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]()) (f(_) :: _)

mapFun(List(1,2,3), ((x:Int) => x + 1))

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0) ((_, acc) => acc+1)

lengthFun(List(1,2,3))

