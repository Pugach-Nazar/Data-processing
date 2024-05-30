import { Component, Input } from '@angular/core';
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
  @Input() machineGun?:MachineGun;
  selectedMachineGun!:MachineGun;

  table:boolean=false;
  showCreateForm:boolean = false;
  showEditForm:boolean = false;

  constructor(private service:Service1Service){}

  getRest():void{
    this.service.getRest().subscribe(
      (restResponce)=>{
        this.machineGuns=restResponce;
      }
    );
  }

  createMachineGun(machineGun:MachineGun){
    this.service.postMachineGun(machineGun).subscribe();
    this.getRest();
    this.showCreateForm=false;
  }

  onSelect(machineGun:MachineGun):void{
    this.selectedMachineGun=machineGun;
  }

  updateMachineGun():void{
    this.service.putMachineGun(this.selectedMachineGun).subscribe();
    this.getRest();
    this.showEditForm=false;
  }
  
  deleteMachineGun(machineGun:MachineGun):void{
    this.service.deleteMachineGun(machineGun).subscribe();
    this.getRest();
  }
}
