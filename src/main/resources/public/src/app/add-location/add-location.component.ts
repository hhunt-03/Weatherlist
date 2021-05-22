import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

import { Location } from "../../models/location";


@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {
  longitude     : string;
  latitude      : string; 
  foundLocation : Location;
  errorMessage  : string;
  
  constructor(private apiService : ApiService) { }

  ngOnInit(): void {
    this.longitude = "";
    this.latitude = "";
    this.errorMessage = "";
  }

  public findLocation(longitude,  latitude){
    this.apiService.getLocation(longitude, latitude).subscribe(result => {
      if(result.temperature != null){
        this.foundLocation = result;
        this.errorMessage = "";
      } else {
        this.errorMessage = "Incorrect coordinates. Please enter a location in the USA."
      }
    })
  }

  public addLocation(location){
    this.apiService.addSavedLocation(location).subscribe();
  }

}
