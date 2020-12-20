import { Component} from '@angular/core';
import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent {
  marcas : any;
  foto : string;
  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar,
    private route: ActivatedRoute
  ) {
    this.getMarcas();
    this.initializeApp();
    this.route.queryParams.subscribe(params => {
      if (params.cambio) {
        this.getMarcas();
      }
    });
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

   async getMarcas(){
    this.marcas = await fetch('https://motos.puigverd.org/motos')
    .then(function(response) {
      return response.json();
    })
    .then(function(motos) {
      var marcasTodas=[];
      motos.forEach(element => {
        marcasTodas.push(element.marca)
      });
      return marcasTodas.filter((n, i) => marcasTodas.indexOf(n) === i);
    }).then(function(marcasUnicas) {

      //En esta parte creo un array json con la marca y la imagen de la marca
      var marcasJson = Array();
      marcasJson.push({nombre : "Todas",imagen :"../assets/Todas.png"})
      marcasUnicas.forEach(element => {
        marcasJson.push({nombre : element,imagen :"../assets/"+element+".png"})
      });
      return marcasJson;
    });
    
    //Y aqui consulto con una funcion si existe una imagen para esa marca
    this.marcas.forEach(async element =>{
      element.imagen= await this.getFoto(element.imagen);
    });
    }

    //Esta es la funcion que consulta si existe la imagen y si no existe devuelve otra imagen basica
     async getFoto(ruta){
      let foto : string;
       await fetch(ruta)
        .then(function(response) {
          if(response.ok) {
            foto = ruta;
          } else {
            foto = "../assets/MotoIcon.png";
          }
        })
        .catch(function(error) {
          foto= "../assets/MotoIcon.png";
        });
        return foto;
    }

    
 }
