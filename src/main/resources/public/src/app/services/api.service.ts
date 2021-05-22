import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../../models/user';
import { Location } from '../../models/location';
import { Observable } from 'rxjs';
import { Photo }  from '../../models/photo';

import { AuthenticationService } from '../services/authentication.service';


@Injectable({
  providedIn: 'root'
})

export class ApiService {

  constructor(private httpClient : HttpClient,
              private authenticationService : AuthenticationService) { }

  //ENDPOINTS
  public getUser(userid : string ) : Observable<User> {
    return this.httpClient.get<User>(`api/v1/users/${userid}`);
  }

  public getSavedLocations(userid : string ) : Observable<Location[]> {
    return this.httpClient.get<Location[]>(`api/v1/users/${userid}/locations`);
  }

  public getLocation(longitude : string, latitude : string) : Observable<Location> {
    return this.httpClient.get<Location>(`api/v1/location?longitude=${longitude}&latitude=${latitude}`);
  }

  public getProfilePicture(userid  : string) {
    return this.httpClient.get<Photo>(`api/v1/users/${userid}/photo`);
  }

  public addSavedLocation( location : Location) : Observable<Location>{
    let user = this.authenticationService.getCurrentUser();
    location.user = user;

    return this.httpClient.post<Location>(`api/v1/users/${user.id}/locations`, 
                                          JSON.stringify(location), 
                                          { headers: { 'Content-Type' : 'application/json' } });
  }

  public addProfilePicture(formData : FormData, userid : string) : Observable<Photo> {
    return this.httpClient.put<any>(`api/v1/users/${userid}/photo`, formData);
  }

  public deleteLocation( locationid : string ){
    return this.httpClient.delete<Location>(`api/v1/locations/${locationid}`);
  }
}
