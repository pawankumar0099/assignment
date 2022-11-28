import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ShowProductsComponent } from './components/show-products/show-products.component';
import { FilterPipe } from './filter.pipe';
import { PostReviewComponent } from './components/post-review/post-review.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './components/login/login.component';
import { SearchComponent } from './components/search/search.component';
import { ShowReviewComponent } from './components/show-review/show-review.component';
import { RegisterComponent } from './components/register/register.component';
import { AdminModule } from './admin/admin.module';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ShowProductsComponent,
    FilterPipe,
    PostReviewComponent,
    SearchComponent,
    ShowReviewComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule,
    FormsModule,
    AdminModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
