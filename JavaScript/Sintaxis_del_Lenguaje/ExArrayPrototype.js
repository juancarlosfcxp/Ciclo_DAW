
var aux = "ejercicio para convertir en mayusculas";

String.prototype.primeraMajuscula = function() {
    var aux=this.split(' ');
    var aux2="";
    for (i = 0; i < aux.length; i++) {
        aux[i] = aux[i].charAt(0).toUpperCase()+aux[i].substring(1,aux[i].length);
        aux2=aux2+aux[i]+" ";
    }
    return aux2;
}
aux=aux.primeraMajuscula();
console.log(aux);