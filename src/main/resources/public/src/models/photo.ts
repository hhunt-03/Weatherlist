import { Binary, ThrowStmt } from '@angular/compiler';
import { User } from './user';

export class Photo {
    id              : string;
    image           : Binary;
    owner           : User;
    type            : string;

    constructor( config : any ){
        this.id     = config.id;
        this.image  = config.image;
        this.owner  = config.owner;
        this.type   = config.type;
    }
}