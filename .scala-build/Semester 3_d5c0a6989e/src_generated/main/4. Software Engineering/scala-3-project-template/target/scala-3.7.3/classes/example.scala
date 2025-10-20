package `4$u002E$u0020Software$u0020Engineering`.scala$minus3$minusproject$minustemplate.target.scala$minus3$u002E7$u002E3.classes


final class example$_ {
def args = example_sc.args$
def scriptPath = """4. Software Engineering/scala-3-project-template/target/scala-3.7.3/classes/example.sc"""
/*<script>*/
case class Cell(value:Int) {
  def isSet:Boolean = value != 0
}

val cell1 = Cell(2)
cell1.isSet

val cell2 = Cell(0)
cell2.isSet

case class Field(cells: Array[Cell])

val field1 = Field(Array.ofDim[Cell](1))
field1.cells(0) = cell1

case class House(cells:Vector[Cell])

val house = House(Vector(cell1,cell2))

house.cells(0).value
house.cells(0).isSet
/*</script>*/ /*<generated>*//*</generated>*/
}

object example_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new example$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export example_sc.script as `example`

