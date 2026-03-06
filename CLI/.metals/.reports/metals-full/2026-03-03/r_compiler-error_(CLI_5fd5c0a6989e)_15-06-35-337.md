error id: A3FACB53B8D2D32A18D048DDC2FAE49F
file://<WORKSPACE>/cc_scala.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.



action parameters:
offset: 1014
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

class Entier(n : Int) extends Polynome
class Variable(c : Char) extends Polynome
class Somme(p1 : Polynome, p2 : Polynome) extends Polynome
class Produit(p1 : Polynome, p2 : Polynome) extends Polynome

sealed abstract class Polynome(){

    def substituer(map : HashMap[Char,Int]) : Polynome = {
        this match
            case e: Entier => e
            case v: Variable => map.get(v) match
                case Some(e : Int) => Entier(e)
                case None(e@@)
                
            
            case s: Somme => s
            case p: Produit => p
        
    }
}
    

```


presentation compiler configuration:
Scala version: 3.8.0-bin-nonbootstrapped
Classpath:
<WORKSPACE>/.scala-build/CLI_d5c0a6989e/classes/main [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.8.0/scala3-library_3-3.8.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/3.8.0/scala-library-3.8.0.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/com/sourcegraph/semanticdb-javac/0.10.0/semanticdb-javac-0.10.0.jar [exists ], <WORKSPACE>/.scala-build/CLI_d5c0a6989e/classes/main/META-INF/best-effort [missing ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE> -Ywith-best-effort-tasty




#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:134)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:38)
	scala.collection.immutable.List.apply(List.scala:83)
	dotty.tools.pc.InferCompletionType$.inferType(InferExpectedType.scala:94)
	dotty.tools.pc.InferCompletionType$.inferType(InferExpectedType.scala:62)
	dotty.tools.pc.completions.Completions.advancedCompletions(Completions.scala:543)
	dotty.tools.pc.completions.Completions.completions(Completions.scala:131)
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:139)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:197)
	scala.meta.internal.pc.CompilerAccess.withSharedCompiler(CompilerAccess.scala:149)
	scala.meta.internal.pc.CompilerAccess.$anonfun$1(CompilerAccess.scala:93)
	scala.meta.internal.pc.CompilerAccess.onCompilerJobQueue$$anonfun$1(CompilerAccess.scala:210)
	scala.meta.internal.pc.CompilerJobQueue$Job.run(CompilerJobQueue.scala:153)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	java.base/java.lang.Thread.run(Thread.java:840)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0