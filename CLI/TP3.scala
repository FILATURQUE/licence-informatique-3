object Main{
    def main(args : Array[String]) = {
        var formule : Formule = Et ( Non ( Variable ( " a " )) , Ou ( False , Variable ( " b " )))
        println(formule)
        println(Variable("a").substituer(Map(Variable("a")->Ou(True, Variable("c")), Variable("b")-> False)).toString)
    }

}
 
sealed abstract class Formule{
    override def toString() = {
        this match {
            case Variable(x) => x
            case Non(x) => "("+x.toString()+")"
            case Et(x,y) => "("+ x.toString() +" et "+y.toString()+")"
            case Ou(x,y) => "("+ x.toString() +" ou "+y.toString()+")"
            case True => "(True)"
            case False => "(False)"
        }
    }
    
    def substituer ( sub : Map [ Variable , Formule ]) : Formule = {
        this match {
            case v : Variable => sub.get(v) match {
                case Some(f) => f
                case None => v
            }

            case Non(f) => Non(f.substituer(sub))
            
            case Et(fd, fg) => Et(fd.substituer(sub), fg.substituer(sub))
            
            case Ou(fd, fg) => Ou(fd.substituer(sub), fg.substituer(sub))
            
            case _ => this
        }
    }

    def evaluer(sub:Map[Variable, Formule]) : Option[Boolean] = {
        this.substituer(sub) match {
            case Non(f) => f.evaluer(sub) match {
                case Some(f) => Some(!f)
                case _ => None 
            }
            case Et(fd, fg) => fd.evaluer(sub) match {
                case Some(fd) => fg.evaluer(sub) match {
                    case None => None
                    case Some(fg) => Some(fd && fg)
                }
                case _ => None
            }
            case Ou(fd, fg) => (fd.evaluer(sub), fg.evaluer(sub)) match {
                case (Some(fd), Some(fg)) => Some(fd || fg)
                case _ => None
            }
            case True => Some(true)
            case False => Some(false)
            case _ => None
        }
    }
}

case class Variable(var nom : String) extends Formule
case class Non(var form: Formule) extends Formule
case class Et (var formg: Formule, var formd: Formule) extends Formule
case class Ou (var formg: Formule, var formd: Formule) extends Formule
case object True extends Formule
case object False extends Formule
