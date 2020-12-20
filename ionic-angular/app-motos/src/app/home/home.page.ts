import { Component } from '@angular/core';
import { Router, NavigationExtras, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  public motos: [];
  public marca: string;

  constructor(private router: Router, private route: ActivatedRoute) {
    this.router.onSameUrlNavigation = 'reload';
    this.marca="Todas";
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      if (params.marca) {
        this.marca = params.marca;
        this.getJson();
      }
    });
  }


  async getJson() {
    let url="https://motos.puigverd.org/motos";
    if(this.marca!="Todas"){
      url="https://motos.puigverd.org/motos?marca=" + this.marca;
    }
     const respuesta = await fetch(url, {
      "method": "GET",
      "headers": {}
    });
    this.motos = await respuesta.json();
  }

  async seleccionar(detalle: string[]) {
    let navigationExtras: NavigationExtras = {
      state: {
        parametros: detalle,
      }
    };
    this.router.navigate(['detalle'], navigationExtras);
  }
 
  ionViewWillEnter(){
    this.getJson();
  }
}



