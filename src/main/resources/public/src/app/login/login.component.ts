import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username      :   string;
  password      :   string;
  errorMessage  :   string;

  constructor(private authenticationService : AuthenticationService,
              private router : Router ) { }

  ngOnInit(): void {
    this.username = "";
    this.password = "";
  }

  login($event){
    $event.preventDefault();
    this.authenticationService.login(this.username, this.password)
      .subscribe( user => {
        if( user ) {
          this.router.navigate(['home/']);
        } else {
          this.errorMessage = "Your username or password is invalid";
        }
      });
  }
}
