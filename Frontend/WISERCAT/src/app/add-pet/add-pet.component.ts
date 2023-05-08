import {Component} from '@angular/core';
import {PetService} from "../pet.service";
import {Pet} from "../models/pet";
import {Router} from "@angular/router";


@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent {

  constructor(private petService: PetService, private router: Router) {
  }

  onSubmit(pet: Pet) {
    this.petService.addPet(pet).subscribe(() => {
      this.router.navigate(['']);
    })
  }
}


