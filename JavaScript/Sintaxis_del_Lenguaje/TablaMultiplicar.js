function tablaMultiplicar(num){
    mult = [];
    for(var i= 1;i<=10;i++){
        mult.push(i*num);
    }
    return mult;
}
 var tabla=[];
 tabla=tablaMultiplicar(3);

 for(var i= 0;i<tabla.length;i++){
        console.log(tabla[i]);
    }
