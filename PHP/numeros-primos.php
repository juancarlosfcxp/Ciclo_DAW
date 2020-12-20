<html>
<head>
    <title>Calcular numeros primos</title>
</head>
<body>
    <header>
        <h1>Ejercicio numeros primos</h1>
    </header>
    <p>Comprovar si un numero entres 1 y 200 es primo</p>
    <form method="post">
        Numero: <input type="number" name="numero"><br>
        <input type="submit" value="Comprobar">
    </form>
<?php
$lista = array(1, 2);

function calcularPrimos($array)
{
    for ($i = 3; $i <= 200; $i++) {
        $esPrimo = true;
        for ($j = 2; $j <= $i /2 && $esPrimo; $j++) {
            if ($i % $j == 0) {
                $esPrimo = false;
            }
        }
        if ($esPrimo) {
            $array[] = $i;
        }
    }
    return $array;
}

    function comprovar($array)
    {
        $aux = $_POST["numero"];
        if(empty($aux)){
        }
        else if (isset($aux) && in_array($aux,$array)) {
            echo "El numero: "."$aux". " SI es primo". "<br>";
            printar($array);
        }
        else{
            echo"El numero: "."$aux". " NO es un numero primo o no esta en la lista". "<br>";
            printar($array);
        }

    }


    function printar($array){
        echo "<br>"."Los numeros primos entre 1 y 200 son: " . "<br>";
        foreach ($array as $num) {
            echo $num . ", ";
        }
    }
    $lista=calcularPrimos($lista);
    comprovar($lista);
    ?>
</body>
</html>
