import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { ApiService } from '../services/api.service';
import { Photo } from 'src/models/photo';
import { User } from 'src/models/user';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  user : User;
  firstName: string;
  lastName: string;
  photoUrl : string;

  constructor(private router : Router,
              private authenticationService : AuthenticationService, 
              private apiService : ApiService ) { }

  ngOnInit(): void {
    this.user = this.authenticationService.getCurrentUser();
    this.firstName = this.user.firstName;
    this.lastName = this.user.lastName;
    this.photoUrl = `/api/v1/users/${this.user.id}/photo`;

    this.authenticationService.getCurrentUserAsObservable().subscribe(user => {
      console.log("updating profile");
      this.user = user;

      this.photoUrl = `/api/v1/users/${this.user.id}/photo?t=${Date.now()}`;
    });
  }

  public goToHome(){
    if( this.authenticationService.getCurrentUser() != null){
      this.router.navigate(['home']);
    } else {
      this.router.navigate(['/']);
    }
  }

  public goToAbout(){
     this.router.navigate(['about']);
  }

  public goToProfile(){
    if( this.authenticationService.getCurrentUser() != null){
      this.router.navigate(['profile']);
    } else {
      this.router.navigate(['/']);
    }
  }

  // public getProfilePicture(userid : string) {
  //   return this.apiService.getProfilePicture(userid).subscribe(photo => {
  //     this.user.profilePicture =  photo;
  //   });
  // }

}
