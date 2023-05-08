import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPetComponent } from "./add-pet/add-pet.component";
import { PetsListComponent } from "./pets-list/pets-list.component";
import {EditPetComponent} from "./edit-pet/edit-pet.component";

const routes: Routes = [
  {path:"", component: PetsListComponent},
  {path:"add", component: AddPetComponent},
  {path:"edit/:identificationCode/:name/:type/:furColor/:country", component: EditPetComponent},
  {path:'**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
