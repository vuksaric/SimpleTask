import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  private user : any;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.checkUser();
  }

  public clearStorage(): void{
    sessionStorage.clear();
    this.router.navigateByUrl('landingPage');
  }

  public checkUser(): void{
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user == null){
      this.router.navigateByUrl('landingPage');
    }
  }

}
