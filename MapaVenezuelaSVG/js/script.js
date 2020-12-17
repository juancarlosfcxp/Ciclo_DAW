function cambia_color(aux){
    var a=document.getElementById(aux)
    var b=document.getElementById(aux+"2")
    b.style.textDecoration="underline";
    b.style.color="#444444";
    a.style.fill="#fafa77";
    
}

function volver_color(aux){
    var a=document.getElementById(aux)
    var b=document.getElementById(aux+"2")
    b.style.textDecoration="none";
     b.style.color="black";
    a.style.fill="#7cfa85";
}