import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  totalReview!:number
  totalProducts!:number
  registeredUser!:number
  constructor(private service:ProductService,private userService:AuthService) { }

  ngOnInit(): void {
    this.service.getTotalProducts().subscribe(resp=>{
      this.totalProducts=+resp
    })

    this.service.getTotalReview().subscribe(resp=>{
      this.totalReview=+resp
    })

    this.userService.getRegisterdUser().subscribe(resp=>{
      this.registeredUser=+resp
    })
  }

}
