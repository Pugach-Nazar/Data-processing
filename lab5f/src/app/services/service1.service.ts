import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RestRespose } from '../interfaces/rest-respose';
import { MachineGun } from '../interfaces/machine-gun';

@Injectable({
  providedIn: 'root'
})
export class Service1Service {

  url:string = "http://localhost:8080/machineGuns"

  constructor(private http:HttpClient) { }

  getRest():Observable<RestRespose>{
    return this.http.get<RestRespose>(this.url)
  }

  postMachineGun(machineGun:MachineGun):Observable<MachineGun>{
    return this.http.post<MachineGun>(this.url, machineGun)
  }

  putMachineGun(machineGun:MachineGun):Observable<MachineGun>{
    return this.http.put<MachineGun>(machineGun._links!.self.href, machineGun)
  }

  deleteMachineGun(machineGun:MachineGun):Observable<MachineGun>{
    return this.http.delete<MachineGun>(machineGun._links!.self.href)
  }
}