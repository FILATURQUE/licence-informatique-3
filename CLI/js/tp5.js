// Exercice 1 
class Champi {
    constructor(nom, poids, comestible) {
        this.nom = nom;
        this.poids = poids;
        this.comestible = comestible;
    }

    toString() {
        return `Nom du champignon: ${this.nom}, son poids: ${this.poids}, comestible : ${this.comestible}`;
    }
}

class Morille extends Champi{
    constructor(p){
        super("Morille",p,true);
    }
}

class Amanite extends Champi{
    constructor(n,p,c,s) {
        super(n,p,c);
        this.stries = s;
    }
    toString(){
        let f = super.toString();
        if (this.stries) {
            return f + " plus presence de stries.";
        } else {
            return f;
        }
    }
}

class Golmotte extends Amanite {
    constructor(p) {
        super("Golmotte",p,true,false);
    }
}

class Panthere extends Amanite {
    constructor(p) {
        super("Panthere",p,false,true);
    }
}

let g = new Golmotte(55);
let m = new Morille(677777677777);
let p = new Panthere(556)

console.log(g.toString());
console.log(m.toString());
console.log(p.toString());


// Exercice 2
let selForOf = function(panierChamp) {
    let newPanier = [];
    for (let e of panierChamp){
        if (e.comestible){
            newPanier.push(e);
        }
    }
    return newPanier;
}

let selFor = function(panierChamp) {
    let newPanier = [];
    for (let index = 0; index < panierChamp.length; index++) {
        if (panierChamp[index].comestible){
            newPanier.push(panierChamp[index]);
        }
    }
    return newPanier;
}

let selFilter = function(panierChamp) {
    return panierChamp.filter(e => e.comestible);
}

let cp = [new Golmotte(53),new Panthere(34), new Morille(123)];

console.log(selFilter(cp));
console.log(selForOf(cp));
console.log(selFor(cp));

// Question 3

let danger_golmottes= function(panierChamp) {
    var count = 0;
    for (let e of panierChamp){
        if (e.nom == "Golmotte"){
            count += e.poids;
        }
    }
    if (count > 1000){
        return true;
    } else {
        return false;
    }
}

let danger_golmottes2 = function(panierChamp) {
    return panierChamp.filter(e => e.nom == "Golmotte").reduce((acc,e)=> acc + e.poids,0) > 999;
}

let cp2 = [new Golmotte(1001)];

console.log(danger_golmottes(cp2));
console.log(danger_golmottes2(cp2));

// Question 4
function usine_champ(nom,poids, comestible) {
    attribut = {
        nom : nom,
        poids : poids,
        comestible : comestible
    }
}

function usine_morille(poids) {
    attribut = {
        nom : "Morille",
        poids : poids,
        comestible : true,
    }
}

function usine_amanite(nom,poids, comestible, stries) {
    attribut = {
        nom : nom,
        poids : poids,
        comestible : comestible,
        stries : stries,
    }
}

function usine_golmotte(poids) {
     
    attribut = {
        nom : "Golmotte",
        poids : poids,
        comestible : true,
        stries : false,
    }
}

function usine_panthere(poids) {
    attribut = {
        nom : "Panthere",
        poids : poids,
        comestible : false,
        stries : true
    }
    Object.setPrototypeOf(attribu,)
}