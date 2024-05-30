import { Component } from '@angular/core';
import { MachineGun } from './interfaces/machine-gun';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'lab5f';
  machineGuns:MachineGun[]=[];

  constructor(private service:Service1Service){}

  getRest():void{
    this.service.getRest().subscribe(
      (restResponce)=>{
        this.machineGuns=restResponce._embedded.machineGuns;
      }
    )
  }
}