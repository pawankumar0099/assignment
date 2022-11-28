import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    email: new FormControl('', Validators.email),
    password: new FormControl('')
  })
  constructor(private service: AuthService, private router: Router) { }

  invalidUserorPass: boolean = false
  ngOnInit(): void {
  }

  getData() {
    this.service.login(this.loginForm.value).subscribe((resp: any) => {
      if (resp == null) {
        this.invalidUserorPass = true;
      }
      else {

        this.service.loginUser(resp.token, resp.username, resp.role)
      }

      if (this.service.isLogedIn() == true) {

        if (resp.role == "user")
          this.router.navigateByUrl('/search').then(() => { window.location.reload() });
        else if (resp.role == "admin") {

          this.router.navigateByUrl('/admin').then(() => { window.location.reload() });
        }
      }



    },
      error => {
        this.invalidUserorPass = true;
      }
    )



  }
  get email() { return this.loginForm.get('email') }
  get password() { return this.loginForm.get('password') }

}
