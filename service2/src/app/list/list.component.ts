import { Component, OnInit } from '@angular/core';
import { IUser } from '../interfaces/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrl: './list.component.scss'
})
export class ListComponent implements OnInit {

  title: string = "List of users";
  usersList: IUser[] = [];
  showAddForm: boolean = false;
  selectedUser?: IUser;

  constructor(private service: UserService) { }

  ngOnInit(): void {
    this.updateUsers();
    this.service.list.subscribe(
      (list: IUser[]) => { this.usersList = list }
    );
  }
  updateUsers() {
    this.service.getUsers().subscribe(
      (users) => {
        this.usersList = users;
      }
    );
  }

  addUser(user: IUser) {
    this.service.postUser(user).subscribe(
      (user) => {
        //console.log(user);
        this.updateUsers();
      }
    );
  }

  onSelect(user: IUser) {
    if (this.selectedUser && user.id == this.selectedUser.id) {
      this.selectedUser = undefined;
    } else {
      this.selectedUser = user;
    }
  }

  deleteUser(user: IUser) {
    this.service.deleteUser(user).subscribe(
      () => {
        this.updateUsers();
      }
    );
  }
}
