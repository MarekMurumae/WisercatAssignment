import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import {Pet} from "./models/pet";


@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { }

  findAllPets(): Observable<Pet[]> {
    return this.http.get<Pet[]>(environment.apiUrl + "/all");
  }

  addPet(pet: Pet): Observable<any> {
    return this.http.post<any>(environment.apiUrl, pet)
  }

  editPet(pet: Pet): Observable<any> {
    return this.http.put<any>(environment.apiUrl + "/edit", pet)
  }
}
