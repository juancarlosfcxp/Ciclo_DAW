import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AltamotoPage } from './altamoto.page';

const routes: Routes = [
  {
    path: '',
    component: AltamotoPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AltamotoPageRoutingModule {}
