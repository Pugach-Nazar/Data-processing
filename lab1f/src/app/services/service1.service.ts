import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entity } from '../interface/entity';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  url:string="http://localhost:8082/lab1/Servlet1";

  constructor(private http:HttpClient) { }

  getEntities():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }
}
