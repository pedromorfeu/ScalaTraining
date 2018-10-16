class Recipe(val calories: Int) {
  println(s"Created recipe with ${calories} calories")
  var cookTime: Int = 0

  // Declares method that returns an Int - Int return is optional.
  def estimatedEffort(servings: Int): Int = {
    println("estimating the effort...")
    servings * cookTime * calories
  }
}

val r = new Recipe(100)
r.cookTime = 2
r.estimatedEffort(1000)

class Food(calories: Int)
class Salad(val lettuceCalories: Int, val dressingCalories: Int) extends Food(lettuceCalories + dressingCalories)

class Menu(items: List[Food]) {
  def numberOfMenuItems() = items.size
}

class Dinner(items: List[Food]) extends Menu(items) {
  override def numberOfMenuItems = 2 * items.size
}

val s1 = new Salad(5, 5)
val s2 = new Salad(15, 15)
val dinner = new Dinner(List(s1, s2))

println(s"Dinner has ${dinner.numberOfMenuItems} items")

val succ = (foo: Int) => foo + 1
succ(12)

def succc(x: Int, f: Int => Int) = f(x) + 1
succc(12, succ)
