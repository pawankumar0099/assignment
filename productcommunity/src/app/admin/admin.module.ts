import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddProductComponent } from './add-product/add-product.component';
import { AppRoutingModule } from '../app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';




@NgModule({
  declarations: [
  
    AdminHomeComponent,
       AddProductComponent,
    
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  exports:[
    AdminHomeComponent,
    AddProductComponent
  ]
})
export class AdminModule { }
