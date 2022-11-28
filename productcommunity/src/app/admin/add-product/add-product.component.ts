import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.sass']
})
export class AddProductComponent implements OnInit {

  constructor(private service:AdminService) { }
  addproductform = new FormGroup({
    code: new FormControl(''),
    brand: new FormControl(''),
    name: new FormControl(''),
    imageURL: new FormControl(''),
    price:new FormControl('')
  })

  codeAlreadyExist=false

  getData(){
      this.service.addProduct(this.addproductform.value).subscribe(resp=>{
        this.codeAlreadyExist=false
        alert("product added")
      },
      error=>{
          this.codeAlreadyExist=true
      })
  } 

  ngOnInit(): void {
  }

  get code() { return this.addproductform.get('code') }
  get brand() { return this.addproductform.get('brand') }
  get name() { return this.addproductform.get('name') }
  get imageURL() { return this.addproductform.get('imageURL') }
  get price() { return this.addproductform.get('price') }
}
