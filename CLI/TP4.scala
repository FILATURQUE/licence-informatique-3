import scala.collection.immutable.HashMap
// Question 1: 
// Il faut que la fonction soit une fonction fonctionnel pur (sans effet de bord)

class Cache[T,U] private (val f : T => U, var hm : HashMap[T,U]){
    def this(f: T => U) = {
        this(f,new HashMap[T,U]())
    }

    def apply(x : T) : Tuple2[U,Cache[T,U]] = {
        hm.get(x) match {
            case Some(u) => (u,this)
            case _ => 
            val y = f(x)
            hm = hm.updated(x,y)
            (y,this) 
        }
    }
}

class Etu {
    
}
