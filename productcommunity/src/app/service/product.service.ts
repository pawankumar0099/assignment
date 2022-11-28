import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const ur:string="http://pawan.centralindia.cloudapp.azure.com:8080";
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }



  getProducts(data:any){
      let url=ur+"/product/"+data;

      return this.http.get(url);
  }

  getbyId(data:any){
    let url=ur+"/products/"+data;

    return this.http.get(url);
  }

  postReview(data:any){
      let url=ur+"/review";
    
      return this.http.post(url,data);
  }

  getrating(data:any){
    let url=ur+"/review/"+data

    return this.http.get(url);
  }

  getReview(data:any){
      let url=ur+"/productreview/"+data

      return this.http.get(url);
  }

  getTotalProducts(){
    let url="http://52.172.248.137:9992/totalproducts";
 
    return this.http.get(url)
  }

  getTotalReview(){
    let url=ur+"/totalreview";
 
    return this.http.get(url)
  }
  
}
