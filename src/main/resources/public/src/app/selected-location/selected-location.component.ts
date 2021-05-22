import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from '../services/api.service';
import { AuthenticationService } from '../services/authentication.service';

import { Location } from "../../models/location";

@Component({
  selector: 'app-selected-location',
  templateUrl: './selected-location.component.html',
  styleUrls: ['./selected-location.component.css']
})
export class SelectedLocationComponent implements OnInit {
  locations         :   Array<Location>;
  selectedLocation  :   Location = new Location({});

  constructor(private router : Router,
              private apiService : ApiService,
              private authenticationService : AuthenticationService) { }

   ngOnInit(): void {
    this.getLocationsToDisplay();
  }

  public addLocation(){
    this.router.navigate(['add']);
  }

  public deleteLocation(){
    this.apiService.deleteLocation(this.selectedLocation.id).subscribe();

    this.apiService.getSavedLocations(this.authenticationService.getCurrentUser().id).subscribe( result => {
      this.locations = result;
    });
  }

  public getLocationsToDisplay(){
    this.apiService.getSavedLocations(this.authenticationService.getCurrentUser().id).subscribe( result => {
      this.locations = result;

      if( result ){
        this.apiService.getLocation(this.selectedLocation.longitude, this.selectedLocation.latitude)
                        .subscribe(result => {
                          this.selectedLocation = result;
                        });
      }
    });
  }
}
