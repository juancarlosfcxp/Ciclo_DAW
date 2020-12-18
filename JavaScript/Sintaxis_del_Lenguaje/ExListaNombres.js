var lista=['flores diaz jose','lopez avila carla']

Array.prototype.ordenarLista = function() {
    for(i=0;i<this.length;i++){
    var aux=this[i].split(' ');
    var aux2=aux[2]+" "+aux[0]+" "+aux[1];
        console.log(aux2);
        this[i]=aux2;
}
}

lista.ordenarLista();
lista.sort();
for(i=0;i<lista.length;i++){
    console.log(lista[i]);
}