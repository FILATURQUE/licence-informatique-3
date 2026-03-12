"use strict";

console.log("hello depuis script.js");

//alert("toto");
// seulement dans un navigateur

let a = 42;
a = "foo";
const b = 42;
//b = "bar";

console.log(12/5); // pas de type int, seulement des numbers
console.log(Math.floor(12/5));

console.log("true"==1);
console.log(true==1);
console.log(true==2);
console.log(true=="true");
console.log(12=="12");
console.log(false==0);
console.log(false=="0");
console.log("0"==false);
// == ne vÃ©rifie pas que les types sont Ã©gaux
// s'ils le sont, alors on vÃ©rifie que les valeurs sont Ã©gales
// sinon, les deux valeurs sont converties en nombres, et on les compare

//"true" -> NaN
// NaN est la constante numÃ©rique signifiant "not a number"
console.log(NaN == NaN) // les NaN sont tous diffÃ©rents

console.log(false==="0");
// === vÃ©rifie que les types sont Ã©gaux

console.log(12-Infinity)
console.log(Infinity-Infinity)
console.log(0*Infinity)

a=Infinity
console.log(a-a)

console.log("string".slice(2,4))
console.log('test')
console.log(`a: ${a}`)

console.log(10<2)
console.log("10"<"2") // sur les strings, < dÃ©signe l'ordre lexicographique

if (3) {
    console.log("3 est vrai");
} else {
    console.log("3 est false");
}

for (let i=0; i<10; i++){
    console.log(i);
}

while(false){

}

let t = [1,2,3,"quatre"];

t.push(5);
console.log(t.pop())

for (let e of t) {
    console.log(e);
}
    
function f (x,y) {
    console.log(`premier argument ${x}, deuxiÃ¨me argument ${y}`);
}

function g() {
    console.log("g");
}
f(5,6);
f(5,6,g());

f(5);

let h = function() {}

console.log([1,2,3].map( x=>2*x ));
console.log([1,2,3].forEach( x=>console.log(x) ));
console.log([1,2,3].filter( x=>x>1 ));

function somme1(t) {
    let acc = 0;
    for (let e of t) {
	acc = acc+e;
    }
    return acc;
}

let somme2 = t => t.reduce( (acc,e)=>acc+e , 0)
// deuxiÃ¨me argument de reduce : valeur de dÃ©part de l'accumulateur
// premier argument de reduce : fonction indiquant comment combiner la valeur de l'accumulateur et la valeur de l'Ã©lÃ©ment courant du tableau pour calculer la nouvelle valeur de l'accumulateur

console.log(somme2([1,2,3]));

let theo = {
    nom: "ThÃ©o",
    numetu: 123
}

for (let clef in theo) {
    console.log(`clef ${clef} a pour valeur ${theo[clef]}`);
}

console.log(theo.nom) // nom n'est pas Ã©valuÃ©
console.log(theo["nom"])
let nom = "numetu";
console.log(theo[nom]) // ici, nom est Ã©valuÃ©

console.log(theo);
theo.toString = function () { return `Mon nom est ${this.nom} et mon Ã¢ge est ${this.age} ans`;}
theo.age = 20;

console.log(theo.toString());

theo.toStringBis = () => `Mon nom est ${this.nom} et mon Ã¢ge est ${this.age} ans`

this.nom = "Window";
this.age = NaN;

console.log(theo.toStringBis());

let loic = {
    nom: "Loic",
    age: 32
};

loic.toString = theo.toString;

console.log(loic.toString());

let loicToString = loic.toString;


//console.log(loicToString());
// erreur

// this dans l'appel d'une function de la forme objet.f() fait rÃ©fÃ©rence Ã  objet
// dans le cas de loicToString(), il n'y a rien avant la fonction -> this prend comme valeur undefined

theo.constructF = function() { return () => this.nom;}
let F = theo.constructF();
console.log(F()); // ThÃ©o

loic.constructF = theo.constructF;
let Floic = loic.constructF();
console.log(Floic()); // Loic

loic.F = F;
console.log(loic.F()); //ThÃ©o

// dans une lambda expression, this est fixÃ© (liÃ©) au moment de la dÃ©claration
// ce n'est plus une variable libre : une fois l'expression dÃ©clarÃ©e, chaque appel aura la mÃªme valeur de this

// conclusion : ne jamais utiliser de lambda-expression pour dÃ©finir une mÃ©thode

// bind call

let f1 = theo.toString.bind(theo); // bind(obj) lie this Ã  obj
console.log(f1());

loic.f1 = f1;
console.log(loic.f1());


let f2 = theo.toString.bind(loic); // bind(obj) lie this Ã  obj
console.log(f2());

// on note que une lambda-expression Ã©quivaut Ã  function(){...}.bind(this)


// f.call(a,b,c) revient Ã  lier this Ã  a dans f, puis Ã  appeler f(b,c)

// Prototypes

loic.m = function() {return this.age*this.age;}

console.log(loic.m());

// on veut faire hÃ©riter thÃ©o de loic, pour que thÃ©o possÃ¨de Ã©galement la mÃ©thode m

Object.setPrototypeOf(theo,loic);

console.log(theo.m());

// le javascript engine cherche la mÃ©thode m dans l'objet theo
// ne la trouvant pas, il va chercher la function m dans le prototype de theo, Ã  savoir loic
// et ainsi de suite : si on Ã©choue Ã  trouver m dans loic, on va chercher dans le prototype de loic, etc.

//l'hÃ©ritage en JS est implÃ©mentÃ© grÃ¢ce aux prototypes

let MonArriereClasse ={
    f: function(){},
    h: function(){}
}

let MaClasse ={
    f: function(){},
    g: function(){}
}

let monObj = {};
Object.setPrototypeOf(monObj,MaClasse);
Object.setPrototypeOf(MaClasse,MonArriereClasse);
monObj.f(); // c'est le f de MaClasse
monObj.h(); // c'est le h de MonArriereClasse 

Object.getPrototypeOf(monObj); // MaClasse

class Etu { // class est du sucre syntaxique

    constructor(nom,numetu) {
	this.nom = nom;
	this.numetu = numetu;
    }

    toString() {
	return `mon nom est ${this.nom} et mon numetu ${this.numetu}`;
    }
}

let charlie = new Etu("charlie",456);
console.log(charlie.toString());
console.log(charlie.toStringBis());

// si f est une fonction
// new f(a,b,c) fait la chose suivante :
// 1) un nouvel objet vide obj est crÃ©Ã©, 
// 2) f(a,b,c) est appelÃ©e oÃ¹ this est liÃ© Ã  obj
// 3) on exÃ©cute Object.setPrototypeOf(obj,f.prototype)
// Attention : f.prototype n'est pas le prototype de f !?

// une class est donc une fonction dont le code est celui de son constructor,
// et dont le .prototype contient les mÃ©thodes
