import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http"

const ur:string="http://pawan.centralindia.cloudapp.azure.com:8080";
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }

   regiterUser(user:any){
    console.log(user);
    return this.http.post(ur+"/user",user);
  }

  login(a:any){
    return this.http.post(ur+"/login",a);
  }

  loginUser(token:string,username:any,role:any)
  {
     
      localStorage.setItem("token",token);
      localStorage.setItem("username",username);
      localStorage.setItem("role",role);
      
      return true;
  }

  isLogedIn(){
    let token=localStorage.getItem("token");

    if(token=='undefined' || token=='' || token==null)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("username")
    localStorage.removeItem("role")
    return true;
  }

  getToken(){
    return localStorage.getItem("token");
  }


 getRegisterdUser(){
   let url=ur+"/registerusers";

   return this.http.get(url)
 }

}
