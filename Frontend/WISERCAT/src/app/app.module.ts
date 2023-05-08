import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { PetsListComponent } from './pets-list/pets-list.component';
import {HttpClientModule} from "@angular/common/http";
import { AddPetComponent } from './add-pet/add-pet.component';
import { ButtonComponent } from './button/button.component';
import {FormsModule} from "@angular/forms";
import { EditPetComponent } from './edit-pet/edit-pet.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    PetsListComponent,
    AddPetComponent,
    ButtonComponent,
    EditPetComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
