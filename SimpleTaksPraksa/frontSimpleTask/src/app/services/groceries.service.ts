import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroceriesService {

  private baseUrl = environment.baseUrl;
  constructor( private http : HttpClient) { }

  public getAll(): Observable<any> {
    return this.http.get(`${this.baseUrl}/groceries/getAll`);
  }

  public newGrocery(body): Observable<any> {
    return this.http.post(`${this.baseUrl}/groceries/newGrocery`, body);
  }

  public deleteGrocery(id): Observable<any> {
    return this.http.delete(`${this.baseUrl}/groceries/delete/${id}`);
  }
}
