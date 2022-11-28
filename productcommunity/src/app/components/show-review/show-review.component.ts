import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-show-review',
  templateUrl: './show-review.component.html',
  styleUrls: ['./show-review.component.sass']
})
export class ShowReviewComponent implements OnInit {
  id:any
  res:any
  review:any
  product:any
  constructor(private route:ActivatedRoute,private service:ProductService) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get("pid")
          this.service.getReview(this.id).subscribe(response=>{
              this.review=response;
          })

          this.service.getbyId(this.id).subscribe(resp=>{
            this.product=resp
          })
  }

}
