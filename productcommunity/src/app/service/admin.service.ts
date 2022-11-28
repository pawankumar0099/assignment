import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const ur:string="http://pawan.centralindia.cloudapp.azure.com:8080";
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  getReview(){
    let url=ur+"/newreview";

    return this.http.get(url);
  }

  approveReview(id:any){
    console.log(id)
    let url=ur+"/approve/"+id;
    return this.http.put(url,id);
  }

  rejectReview(id:any){
    console.log(id)
    let url=ur+"/reject/"+id;
    return this.http.put(url,id);
  }

  addProduct(data:any){
    let url=ur+"/product";
    return this.http.post(url,data);
  }
}
