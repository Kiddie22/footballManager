import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as environment from '../../environments/environment';
import { IClub } from '../club.type';
import { IMatch } from '../match.type';

@Injectable({
  providedIn: 'any'
})
export class PostService {

  POST_API_URL_CLUB = `${environment.environment.API_BASE_URL}/club`
  POST_API_URL_MATCH = `${environment.environment.API_BASE_URL}/match`
  POST_API_URL_GENERATE = `${environment.environment.API_BASE_URL}/generate`


  constructor(private httpClient: HttpClient) { }

  getClubs(){
    return this.httpClient.get<IClub[]>(this.POST_API_URL_CLUB)
  }

  getMatches(){
    return this.httpClient.get<IMatch[]>(this.POST_API_URL_MATCH)
  }

  generate(){
    return this.httpClient.get<IMatch[]>(this.POST_API_URL_GENERATE)
  }
}
