<html>
    <head>
        <title>mi primera tienda</title>
    </head>
    <body>
        <header>
            <img src="imagenes/logo.jpg" width=20% >
            <nav style="height:40px; background-color: red; color: white;">
                <ul>
                    <li style="display: inline; margin-top: 30%;">bicicletas</li>
                    <li style="display: inline">tablas</li>
                    <li style="display: inline">patines</li>
                </ul>
            </nav>
        </header>
        <section style="margin-top:2%; ">
            <nav style="height:40px; background-color: red;">bicicletas</nav>
            <?php
            printImagenes("imagenes/bicicletas/");
            ?>
        </section>
        <section style="margin-top:2%">
            <nav style="height:40px; background-color: red;">tablas</nav>
            <?php
            printImagenes("imagenes/tablas/");
            ?>
        </section>
        <section style="margin-top:2%">
            <nav style="height:40px; background-color: red;">patines</nav>
            <?php
            printImagenes("imagenes/patines/");
            ?>
        </section>

            <?php
            function printImagenes($ruta){

                foreach (new DirectoryIterator($ruta) as $i) {
                    if ($i->isDot()) continue;
                    $texto = explode(".", $i);
                    echo"<table style='width:20%;display: inline-block; border: black;border-style: solid;'>
                    <tr>
                    <td>"."<img src=\"$ruta/$i\"" . "style='width=20%;height:200;'"."\">"."
                    <p>$texto[0]</p>
                    <p style='font-size:30px;'>$texto[1]</p>
                    </td>
                    </tr>
                    </table>";
                }
            }
            ?>
    </body>
</html>