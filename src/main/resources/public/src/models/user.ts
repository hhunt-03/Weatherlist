import { Location } from './location';
import { Photo } from './photo';

export class User {
    id             : string;
    firstName       : string;
    lastName        : string;
    email           : string;
    username        : string;
    password        : string;
    profilePicture  : Photo;

    constructor( config : any ){
        this.id             = config.id;
        this.firstName      = config.firstName;
        this.lastName       = config.lastName;
        this.email          = config.email;
        this.username       = config.username;
        this.password       = config.password;
        this.profilePicture = config.profilePicture;
    }
}