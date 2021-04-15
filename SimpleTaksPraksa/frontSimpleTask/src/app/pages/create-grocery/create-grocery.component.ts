import { Component, OnInit } from '@angular/core';
import { GroceriesService } from 'src/app/services/groceries.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-grocery',
  templateUrl: './create-grocery.component.html',
  styleUrls: ['./create-grocery.component.css']
})
export class CreateGroceryComponent implements OnInit {

  validateForm!: FormGroup;

  private user: any;

  constructor(private fb: FormBuilder, private groceriesService: GroceriesService, private router: Router) { }

  ngOnInit(): void {
    this.checkUser();

    this.validateForm = this.fb.group({
      name: [null, [Validators.required]],
      nutritionalValue: [null, [Validators.required]],
      price: [null, [Validators.required]],
    });

    this.user = JSON.parse(sessionStorage.getItem("user"));
    console.log(this.user);
  }

  public checkUser(): void{
    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user == null){
      this.router.navigateByUrl('landingPage');
    }
  }

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
    const body = {
      name: this.validateForm.value.name,
      nutritionalValue: this.validateForm.value.nutritionalValue,
      price: this.validateForm.value.price,
      userUsername: this.user.username
    }
    this.groceriesService.newGrocery(body).subscribe(data => {alert('Uspesno ste kreirali namirnicu')});
  }

}
