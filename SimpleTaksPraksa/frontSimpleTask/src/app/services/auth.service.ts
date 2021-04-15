import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = environment.baseUrl;
  constructor( private http : HttpClient) { }

  public register(body):Observable<any> {
    return this.http.post(`${this.baseUrl}/users/registration`,body);
  }

  public login(body):Observable<any> {
    return this.http.post(`${this.baseUrl}/users/login`,body);
  }
}
