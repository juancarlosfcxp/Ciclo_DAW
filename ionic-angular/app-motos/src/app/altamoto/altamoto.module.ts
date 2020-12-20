import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AltamotoPageRoutingModule } from './altamoto-routing.module';

import { AltamotoPage } from './altamoto.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AltamotoPageRoutingModule
  ],
  declarations: [AltamotoPage]
})
export class AltamotoPageModule {}
