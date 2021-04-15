import { Component, Input, OnInit } from '@angular/core';
import { GroceriesService } from 'src/app/services/groceries.service';


@Component({
  selector: 'app-grocery-card',
  templateUrl: './grocery-card.component.html',
  styleUrls: ['./grocery-card.component.css']
})
export class GroceryCardComponent implements OnInit {

  @Input() grocery: any;

  constructor(private groceriesService: GroceriesService) { }

  ngOnInit(): void {
  }

  public deleteGrocery(id){
    this.groceriesService.deleteGrocery(id).subscribe(data =>{
      location.reload();
      console.log('usao')
    })
  }

} 
