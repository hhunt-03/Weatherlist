import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AddLocationComponent } from './add-location/add-location.component';
import { ProfileComponent } from './profile/profile.component';
import { AboutComponent } from './about/about.component';


const routes: Routes = [{ path: '',           component: LoginComponent       },
                        { path: 'home',       component: HomeComponent        },
                        { path: 'about',      component: AboutComponent     },
                        { path: 'profile',    component: ProfileComponent     },
                        { path: 'add',        component: AddLocationComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}