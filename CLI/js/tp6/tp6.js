var bonne_taupe = creerTaupe("bonne_taupe.png");
let mTaupe = [];
let coord = [];
let ind = 0;

function creerTaupe(link) {
    let body = document.querySelector("body");
    let newTaupe = document.createElement("img");
    body.prepend(newTaupe);
    newTaupe.setAttribute("src",link);
    newTaupe.setAttribute("height",window.innerWidth/15);
    newTaupe.setAttribute("width",window.innerWidth/15);
    newTaupe.style.position="absolute";
    clicBonneTaupe(newTaupe);
    return newTaupe;
}


function placerTaupe(taupe){
    x = Math.floor(Math.random()*(window.innerWidth - taupe.width));
    y = Math.floor(Math.random()*(window.innerHeight - taupe.height));
    taupe.style.left=x+"px";
    taupe.style.top=y+"px";
}

function clicBonneTaupe(taupe) {
    taupe.addEventListener("click",() => {
        if (taupe.getAttribute("src") == "mauvaise_taupe.png") {
            mTaupe.forEach(el => {
                el.remove();
                mTaupe = [];
            })
            placerTaupe(bonne_taupe);
        } 
        else{
            let mT = creerTaupe("mauvaise_taupe.png");
            placerTaupe(taupe);
            mTaupe.push(mT);
            mTaupe.forEach(
                (el) => {
                    placerTaupe(el);
                } 
            )
        }
    })
}

placerTaupe(bonne_taupe);


