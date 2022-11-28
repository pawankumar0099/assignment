import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})

export class RegisterComponent implements OnInit {
  userAlreadyExist = false
  registerForm = new FormGroup({
    email: new FormControl('', Validators.email),
    password: new FormControl(''),
    firstName: new FormControl('', Validators.pattern('[a-zA-Z]*')),
    lastName: new FormControl('', Validators.pattern('[a-zA-Z]*'))
  })
  constructor(private service: AuthService, private router: Router) { }


  ngOnInit(): void {
  }
  getData() {
    this.service.regiterUser(this.registerForm.value).subscribe((resp: any) => {
      this.router.navigate(["login"])
    },
      error => {
        this.userAlreadyExist = true
      });


  }
  get email() { return this.registerForm.get('email') }
  get password() { return this.registerForm.get('password') }
  get firstName() { return this.registerForm.get('firstName') }
  get lastName() { return this.registerForm.get('lastName') }

}
