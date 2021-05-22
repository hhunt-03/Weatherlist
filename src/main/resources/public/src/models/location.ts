import { User } from './user';

export class Location {
    id             : string;
    longitude       : string;
    latitude        : string;
    temperature     : string;
    text            : string;
    areaDescription : string;
    user            : User;

    constructor( config : any ){
        this.longitude          = config.longitude;
        this.latitude           = config.latitude;
        this.temperature        = config.temperature;
        this.text               = config.text;
        this.areaDescription    = config.areaDescription;
        this.id                = config.id;
    }
}