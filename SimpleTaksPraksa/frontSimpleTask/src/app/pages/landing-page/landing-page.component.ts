import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  validateForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService : AuthService, private router: Router) { }

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      this.validateForm.controls[i].markAsDirty();
      this.validateForm.controls[i].updateValueAndValidity();
    }
    console.log(this.validateForm.value);
    this.authService.login(this.validateForm.value).subscribe(data => {
      alert('Uspesno ste se loginovali');
      console.log(data);
      sessionStorage.setItem("token", JSON.stringify(data.token));
      sessionStorage.setItem("user", JSON.stringify(data));
      this.router.navigateByUrl('dashboard');
  });

  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });
  }

}
