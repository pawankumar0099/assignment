import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderComponent implements OnInit {
  username=localStorage.getItem("username")
  constructor(private service: AuthService, private router: Router) { }

  isLoggedIn = false
  ngOnInit(): void {

    this.isLoggedIn = this.service.isLogedIn();

  }

  logout() {
    this.service.logout();
    this.router.navigate(["home"]).then(() => { window.location.reload() });

  }
}
