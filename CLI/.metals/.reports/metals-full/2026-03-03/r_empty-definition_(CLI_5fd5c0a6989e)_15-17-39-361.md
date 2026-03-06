error id: file://<WORKSPACE>/cc_scala.scala:substituer.
file://<WORKSPACE>/cc_scala.scala
empty definition using pc, found symbol in pc: substituer.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -s/gauche/substituer.
	 -s/gauche/substituer#
	 -s/gauche/substituer().
	 -scala/Predef.s.gauche.substituer.
	 -scala/Predef.s.gauche.substituer#
	 -scala/Predef.s.gauche.substituer().
offset: 1073
uri: file://<WORKSPACE>/cc_scala.scala
text:
```scala
import java.util.HashMap
def compterPM[T](element : T, liste : List[T]) : Int = {
    liste match {
        case t::q => t.equals(element) match {
            case true => compterPM(element, q) +1 
            case _ => compterPM(element, q)
        }
        case _ => 0
    }
}

def compterOL[T](element : T, liste : List[T]) : Int = {
    liste.filter(p => p == element).length
}

object caca {
    def main(args: Array[String]): Unit = {
        println(compterPM(5,List(1,2,3,4,5)))
        println(compterOL(5,List(5,5,5,5,4)))
    }
}

class Entier(val n : Int) extends Polynome
class Variable(val c : Char) extends Polynome
class Somme(val p1 : Polynome, val p2 : Polynome) extends Polynome
class Produit(val p1 : Polynome,val p2 : Polynome) extends Polynome

sealed abstract class Polynome(){

    def substituer(map: HashMap[Char, Int]): Polynome = {
  this match {
    case e: Entier => e

    case v: Variable =>
      map.get(v.c) match {
        case Some(e) => Entier(e)
        case None    => v
      }

    case s: Somme =>
      Somme(s.gauche.substituer@@(map), s.droite.substituer(map))

    case p: Produit =>
      Produit(p.gauche.substituer(map), p.droite.substituer(map))
  }
}
}
    

```


#### Short summary: 

empty definition using pc, found symbol in pc: substituer.