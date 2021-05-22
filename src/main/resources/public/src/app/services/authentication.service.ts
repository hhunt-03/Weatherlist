import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';

import { User } from '../../models/user';
import { Photo } from '../../models/photo'
import { ApiService } from './api.service';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<User>;
  private currentUser : Observable<User>;

  constructor(private httpClient : HttpClient) { 

    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public getCurrentUser() {
    return JSON.parse(localStorage.getItem('currentUser'));
  }

  public getCurrentUserAsObservable(){
    return this.currentUser;
  }

  public getCurrentUserSubject(){
    return this.currentUserSubject;
  }

  public login(username: string, password: string) : Observable<User>{
    return this.httpClient.post<User>("/login", 
                                      `username=${username}&password=${password}`, 
                                      { headers : { 'Content-Type' : 'application/x-www-form-urlencoded' } } )
                .pipe( map ( user => {
                  localStorage.setItem('currentUser', JSON.stringify(user));
                  this.currentUserSubject.next(user);
                  return user;
                }));
  }

  public photoChanged(){
    this.currentUserSubject.next(this.getCurrentUser());
  }
  
  public logout( username: string, password : string ): void{
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);  }
}
