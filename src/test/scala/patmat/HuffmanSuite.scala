package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {

  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
      assert(weight(t2) === 9)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t1) === List('a', 'b'))
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("make code tree") {
    val sampleTree = makeCodeTree(makeCodeTree(Leaf('x', 1), Leaf('e', 1)), Leaf('t', 2))
    println(sampleTree.chars + " " + sampleTree.weight)

    assert(sampleTree.chars === List('x', 'e', 't'))
    assert(sampleTree.weight === 4)
  }

  test("times") {
    assert(times(List()) === List())
    assert(times(List('a')) === List(('a',1)))
    assert(times(List('a','b','a')) === List(('a',2),('b',1)))
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("singleton") {
    new TestTrees {
      assert(singleton(List(t1)))
      assert(singleton(List(t1, t2)) === false)
    }
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))

    val leaflist2 = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4), Leaf('z', 6))
    assert(combine(leaflist2) === List(
      Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3),
      Fork(Leaf('x', 4), Leaf('z', 6), List('x', 'z'), 10)
    ))
  }

  test("until of some tree") {
    new TestTrees {
      assert(until(singleton, combine)(List(t1, Leaf('d', 4))) == List(t2))
    }
  }

  test("create a code tree") {
    println(createCodeTree(string2Chars("a")))
    println(createCodeTree(string2Chars("ab")))
    println(createCodeTree(string2Chars("aba")))
    println(createCodeTree(string2Chars("abaab")))
    println(createCodeTree(string2Chars("abacab")))
  }

  test("decode some bits") {
    new TestTrees {
      assert(decode(t1, List()) == List())
      assert(decode(t1, List(0)) == List('a'))
      assert(decode(t1, List(1)) == List('b'))
      assert(decode(t2, List(1)) == List('d'))
      assert(decode(t2, List(0, 1)) == List('b'))
      assert(decode(t2, List(0, 0)) == List('a'))
    }
  }

  test("decoded secret") {
    println(decodedSecret)
  }

  test("get chars") {
    new TestTrees {
      assert(getChars(t1, List(0)) == 'a')
      assert(getChars(t1, List(1)) == 'b')
      assert(getChars(t2, List(0, 0)) == 'a')
      assert(getChars(t2, List(0, 1)) == 'b')
      assert(getChars(t2, List(1)) == 'd')
    }
  }

  test("get bits") {
    new TestTrees {
      assert(getBits(t1, 'a', List()) == List(0))
      assert(getBits(t1, 'b', List()) == List(1))
      assert(getBits(t2, 'a', List()) == List(0, 0))
      assert(getBits(t2, 'b', List()) == List(0, 1))
      assert(getBits(t2, 'd', List()) == List(1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

}
