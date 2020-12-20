import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-altamoto',
  templateUrl: './altamoto.page.html',
  styleUrls: ['./altamoto.page.scss'],
})
export class AltamotoPage {
  inputMarca:string;
  inputModelo:string;
  inputYear:number;
  inputPrecio:number;
  constructor(private router: Router,) { }

  subirMoto(){
    let moto={
      "marca": this.inputMarca,
      "modelo": this.inputModelo,
      "year": this.inputYear,
      "foto": "https://cdn.clipart.email/af0f6df26fc6de302d8d1cc45ae1df7b_vespa-silhouette-at-getdrawingscom-free-for-personal-use-vespa-_357-227.png",
      "precio": this.inputPrecio
    }
    fetch("https://motos.puigverd.org/moto", {
  "method": "POST",
  "headers": {
    "content-type": "application/json"
  },
  "body": JSON.stringify(moto)
})
.then(response => {
  console.log(response);
  this.router.navigateByUrl('home?cambio=true');//El parametro lo envio para actualizar las marcas del componente
})
.catch(err => {
  console.log(err);
});
  }


}
