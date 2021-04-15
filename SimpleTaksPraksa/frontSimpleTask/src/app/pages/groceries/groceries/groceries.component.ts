import { Component, OnInit } from '@angular/core';
import { GroceriesService } from 'src/app/services/groceries.service';

@Component({
  selector: 'app-groceries',
  templateUrl: './groceries.component.html',
  styleUrls: ['./groceries.component.css']
})
export class GroceriesComponent implements OnInit {

  constructor(private groceriesService: GroceriesService) { }

  public groceries = [];

  ngOnInit(): void {
    this.getAllGroceries();
  }

  getAllGroceries(): void {
    this.groceriesService.getAll().subscribe(data => {
      this.groceries = data;
    });
  }
  

}
