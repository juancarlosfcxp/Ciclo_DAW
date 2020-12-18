var arrayDatos = [
    ['0', 'Belgica', 'Bruselas'],
    ['1', 'Alemania', 'Berlin'],
    ['2', 'España', 'Madrid'],
    ['3', 'Francia', 'Paris'],
    ['4', 'Inglaterra', 'Londres'],
    ['5', 'Venezuela', 'Caracas'],
    ['6', 'Italia', 'Roma'],
    ['7', 'Albania', 'Tirana'],
    ['8', 'Andorra', 'Andorra La Vella'],
    ['9', 'Austria', 'Viena'],
    ['10', 'Bulgaria', 'Sofia'],
    ['11', 'Croacia', 'Zagreb'],
    ['12', 'Dinamarca', 'Copenhague'],
    ['13', 'Grecia', 'Atenas'],
    ['14', 'Estonia', 'Tallinn'],
    ['15', 'Ucrania', 'Kiev'],
    ['16', 'Eslovaquia', 'Bratislava'],
    ['17', 'Eslovenia', 'Ljubljana'],
    ['18', 'Finlandia', 'Helsinki'],
    ['19', 'Irlanda', 'Dublin'],
    ['20', 'Islandia', 'Reykjavík'],
    ['21', 'Kosovo', 'Pristina'],
    ['22', 'Letonia', 'Riga'],
    ['23', 'Liechtenstein', 'Vaduz'],
    ['24', 'Lituania', 'Vilnius'],
    ['25', 'Luxemburgo', 'Luxembourg'],
    ['26', 'Malta', 'Valletta'],
    ['27', 'Moldavia', 'Chisinau'],
    ['28', 'Mónaco', 'Monaco'],
    ['29', 'Montenegro', 'Podgorica'],
    ['30', 'Noruega', 'Oslo'],
    ['31', 'Paises_Bajos', 'Ámsterdam'],
    ['32', 'Polonia', 'Varsovia'],
    ['33', 'Portugal', 'Lisbon'],
    ['34', 'Rumania', 'Bucarest'],
    ['35', 'Rusia', 'Moscú'],
    ['36', 'Serbia', 'Belgrado'],
    ['37', 'Suecia', 'Estocolmo'],
    ['38', 'Suiza', 'Bern']
];

var respuesta;
var correctas = 0;
var totalPreguntas = 0;
var maximo = 10;
var pila = [];
var segundos = 5;
var time = window.setInterval(contar, 1000);


function jugar() {
    totalPreguntas++;
    segundos = 5;
    document.body.style.backgroundColor = "white";
    generaPregunta();
    rellenarLista();

    var select = document.getElementById('selector');
    select.addEventListener("click", es_correcte);
    if (totalPreguntas > maximo) {
        window.clearInterval(time);
        var x = document.getElementById("selector")
        x.setAttribute("style", "display:none;");
        document.getElementById("contador").setAttribute("style", "display:none;");
        document.getElementById("opcionPregunta").innerHTML = "Has acertado " + correctas + " de " + maximo;
    }
}

jugar();

function contar() {
    document.getElementById("contador").innerHTML = segundos;
    if (segundos == 0) {
        jugar();
    } else { segundos--; }
}

function generaPregunta() {
    var r;
    var aux = false;
    while (!aux) {
        r = Math.floor(Math.random() * (arrayDatos.length));
        var pregunta = arrayDatos[r][1];
        if (pila.indexOf(pregunta) == -1) {
            aux = true;
            pila.push(pregunta);
        }
    }
    respuesta = arrayDatos[r][0];
    document.getElementById("opcionPregunta").innerHTML = "¿Cual es la Bandera de " + pregunta + "?";
}

function limpiarSelect() {
    var cont;
    cont = document.getElementById("selector").length;
    var x;
    var x = document.getElementById("selector");
    while (cont > 0) {
        x.remove(cont);
        cont--;
    }
}

function rellenarLista() {
    var aux = false;
    var dentro;
    while (!aux) {
        limpiarSelect();
        dentro = [];
        while (document.getElementById("selector").length < 5) {
            var r2;
            r2 = Math.floor(Math.random() * (arrayDatos.length));
            var valor = arrayDatos[r2][0];
            if (dentro.indexOf(valor) == -1) {
                if (respuesta == valor) {
                    aux = true;
                }
                dentro.push(valor);
                generaOpcion(arrayDatos[r2][1], valor);
            }

        }
    }
}

function generaOpcion(opcionMostrar, valor) {
    var opcion = document.createElement("option");
    var textnode = document.createTextNode("");
    opcion.appendChild(textnode);
    opcion.setAttribute("value", valor);
    opcion.setAttribute("style", "background-image:url(img/" + opcionMostrar + ".png);");
    document.getElementById('selector').appendChild(opcion);
}


function es_correcte() {

    var valor = document.getElementById('selector');
    valor = valor.options[valor.selectedIndex].getAttribute("value");
    var o = document.getElementById('selector');
    if (valor != null) {
        if (valor == respuesta) {
            o.style.backgroundColor = "green";
            document.body.style.backgroundColor = "green";
            setTimeout(jugar, 500);
            correctas++;
        } else {
            o.style.backgroundColor = "red";
            document.body.style.backgroundColor = "red";
            setTimeout(jugar, 500);
        }
    }
}
s