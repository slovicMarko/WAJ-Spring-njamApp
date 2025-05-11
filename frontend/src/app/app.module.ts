import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
  withEventReplay,
} from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestoranListComponent } from './components/restoran-list/restoran-list.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { ZvjezdiceComponent } from './components/zvjezdice/zvjezdice.component';
import { OtvoreniComponent } from './components/otvoreni/otvoreni.component';

@NgModule({
  declarations: [AppComponent, RestoranListComponent, HomepageComponent, ZvjezdiceComponent, OtvoreniComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideClientHydration(withEventReplay())],
  bootstrap: [AppComponent],
})
export class AppModule {}
