import { Component, OnInit } from '@angular/core';
import { User } from 'src/models/user';

import { AuthenticationService } from '../services/authentication.service';
import { ApiService } from '../services/api.service';
import { PathLocationStrategy } from '@angular/common';
import { Photo } from '../../app/../models/photo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user : User;
  photoFile : File = null;
  profilePicture : Photo;

  constructor(private authenticationService : AuthenticationService,
              private apiService : ApiService,
              private router : Router ) { }

  ngOnInit(): void {
    this.user = this.authenticationService.getCurrentUser();
  }

  public upload(){
    const formData = new FormData();
    formData.append('photo', this.photoFile );
    
    this.apiService.addProfilePicture(formData, this.user.id ).subscribe(x => {
      this.authenticationService.photoChanged();
    });
  }

  public fileChosen($event){
    this.photoFile = $event.target.files.item(0);
  }

  public logout(){
    this.authenticationService.logout(this.user.username, this.user.password);
    this.router.navigate(['/']);

  }
}
