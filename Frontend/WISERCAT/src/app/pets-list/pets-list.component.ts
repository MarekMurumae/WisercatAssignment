import { Component } from '@angular/core';
import {PetService} from "../pet.service";
import {Pet} from "../models/pet";

@Component({
  selector: 'app-pets-list',
  templateUrl: './pets-list.component.html',
  styleUrls: ['./pets-list.component.css']
})
export class PetsListComponent {
  pets: Pet[];

  constructor(private petService: PetService) {
    this.pets = []
  }

  ngOnInit(): void {
    this.petService.findAllPets().subscribe(pets => {
      this.pets = pets;
    });
  }

}
