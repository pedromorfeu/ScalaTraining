package objsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {

  trait TestSets {
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5: TweetSet = set4c.incl(d)
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  test("filter: on empty set") {
    new TestSets {
      assert(size(set1.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: b on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "b")) === 1)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }

  test("filter: <10 on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.retweets < 10)) === 2)
    }
  }

  test("filter: true on set5") {
    new TestSets {
      assert(size(set5.filter(tw => true)) == 4)
    }
  }

  test("filter: false on set5") {
    new TestSets {
      assert(size(set5.filter(tw => false)) == 0)
    }
  }

  test("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  test("union: set4d and set5") {
    new TestSets {
      assert(size(set4d.union(set5)) === 4)
    }
  }

  test("union: set5 and set4d") {
    new TestSets {
      assert(size(set5.union(set4d)) === 4)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set1)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(set1.union(set5)) === 4)
    }
  }

  test("mostRetweeted: exception on empty") {
    new TestSets {
      try {
        val retweeted: Tweet = set1.mostRetweeted
        fail()
      } catch {
        case e: java.util.NoSuchElementException => // ok
      }
    }
  }

  test("mostRetweeted: a(20) or b(20) on set 5") {
    new TestSets {
      val most: Tweet = set5.mostRetweeted
      assert(most.user == "b")
      assert(most.retweets === 20)
    }
  }

  test("descending: set5") {
    new TestSets {
      val trends: TweetList = set5.descendingByRetweet
      trends.foreach(t => print(t.user + " "))
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
      assert(trends.tail.head.user == "a" || trends.tail.head.user == "b")
      assert(trends.tail.tail.head.user == "d")
      assert(trends.tail.tail.tail.head.user == "c")
    }
  }

}
