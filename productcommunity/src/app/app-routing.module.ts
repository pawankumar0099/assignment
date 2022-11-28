import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SearchComponent } from './components/search/search.component';
import { AuthGuard } from './service/auth.guard';
import { ShowProductsComponent } from './components/show-products/show-products.component';
import { PostReviewComponent } from './components/post-review/post-review.component';
import { LoginComponent } from './components/login/login.component';
import { ShowReviewComponent } from './components/show-review/show-review.component';
import { RegisterComponent } from './components/register/register.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { AdminGuard } from './service/admin.guard';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { AddProductComponent } from './admin/add-product/add-product.component';


const routes: Routes = [
  
  {
    path:"",
    redirectTo:"home",
    pathMatch:"full"
  },
  {
      path:"home",
      component:HomeComponent
  },
  {
    path:"login",
    component:LoginComponent
  },
  {
    path:"search",
    component:SearchComponent,
    canActivate:[AuthGuard]
  },
  {path:"register",component:RegisterComponent},
  {
    path:"product/:search",component:ShowProductsComponent,canActivate:[AuthGuard]
  },
  {
    path:"review/:id",component:PostReviewComponent,canActivate:[AuthGuard]
  },
  {
    path:"productreview/:pid",component:ShowReviewComponent,canActivate:[AuthGuard]
  },
  {
    path:"admin",component:AdminHomeComponent,canActivate:[AdminGuard]
  },
  {
    path:"addproduct",component:AddProductComponent,canActivate:[AdminGuard]
  },
  {
    path:"**",component:PageNotFoundComponent,pathMatch:"full"
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
