import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.page.html',
  styleUrls: ['./detalle.page.scss'],
})

export class DetallePage {

  public detalle :any;
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    public alertController: AlertController
    ) { 
    this.route.queryParams.subscribe(params => {
      if (this.router.getCurrentNavigation().extras.state) {
        this.detalle = this.router.getCurrentNavigation().extras.state.parametros;
      }
    });
  }

  async borrarMotoConfirm(idMoto) {
    const alert = await this.alertController.create({
      header: 'Cuidado!',
      message: 'Estas segura que quieres borrar esta moto?',
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel',
          cssClass: 'secondary',
        }, {
          text: 'Confirmar',
          handler: () => {
            this.borrarMoto(idMoto);
          }
        }
      ]
    });

    await alert.present();
  }

  async borrarMoto(idMoto) {
    const url = "https://motos.puigverd.org/moto/" + idMoto;
    fetch(url, {
      "method": "DELETE"
    })
    .then(response => {
        this.router.navigateByUrl('home?cambio=true');//El parametro lo envio para actualizar las marcas del componente
      });
  }

}
