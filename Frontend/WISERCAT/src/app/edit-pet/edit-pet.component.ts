import {Component, OnInit} from '@angular/core';
import {Pet} from "../models/pet";
import {PetService} from "../pet.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-edit-pet',
  templateUrl: './edit-pet.component.html',
  styleUrls: ['./edit-pet.component.css']
})
export class EditPetComponent implements OnInit {

  identificationCode: string | null = null;
  name: string | null = null;
  type: string | null = null;
  furColor: string | null = null;
  country: string | null = null;

  constructor(private petService: PetService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.identificationCode = params.get("identificationCode")
      this.name = params.get("name")
      this.type = params.get("type")
      this.furColor = params.get("furColor")
      this.country = params.get("country")
    })
  }

  onSubmit(pet: Pet) {
    this.petService.editPet(pet).subscribe(() => {
      this.router.navigate(['']);
    })
  }
}
