import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.sass']
})
export class AdminHomeComponent implements OnInit {

  constructor(private service:AdminService) { }

  reviews:any=[]

  ngOnInit(): void {
      this.service.getReview().subscribe(resp=>{
          this.reviews=resp
      })

  }

  approve(id:any)
  {
      this.service.approveReview(id).subscribe(resp=>{})
      window.location.reload()
  }

  reject(id:any){
    this.service.rejectReview(id).subscribe(resp=>{})
    window.location.reload()
  }

}
