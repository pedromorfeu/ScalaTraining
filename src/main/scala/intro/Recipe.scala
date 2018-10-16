package intro

class Recipe(val calories: Int) {
  println(s"Created recipe with ${calories} calories")
  var cookTime: Int = 0

  // Declares method that returns an Int - Int return is optional.
  def estimatedEffort(servings: Int): Int = {
    println("estimating the effort...")
    servings * cookTime * calories
  }
}

object Recipe {

  def apply(calories: Int) = new Recipe(calories * 2)

}
