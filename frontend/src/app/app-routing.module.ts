import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestoranListComponent } from './components/restoran-list/restoran-list.component';
import { RestoranDetaljiComponent } from './components/restoran-detalji/restoran-detalji.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { HttpClientModule } from '@angular/common/http';
import { ZvjezdiceComponent } from './components/zvjezdice/zvjezdice.component';
import { OtvoreniComponent } from './components/otvoreni/otvoreni.component';

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'restorani', component: RestoranListComponent },
  { path: 'otvoreni', component: OtvoreniComponent },
  { path: 'restorani/:id', component: RestoranDetaljiComponent },
  { path: 'zvjezdice', component: ZvjezdiceComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule, HttpClientModule],
})
export class AppRoutingModule {}
