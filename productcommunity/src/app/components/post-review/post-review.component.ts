import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/service/product.service';
import { ActivatedRoute } from '@angular/router';
import { NgbRatingConfig } from '@ng-bootstrap/ng-bootstrap';
import { Location } from '@angular/common';

@Component({
  selector: 'app-post-review',
  templateUrl: './post-review.component.html',
  styleUrls: ['./post-review.component.sass']
})
export class PostReviewComponent implements OnInit {
  reviewForm = new FormGroup({
    heading: new FormControl(''),
    review: new FormControl('')
  })

  res: any
  currentRate = 0
  id: any
  username = localStorage.getItem("username")

  constructor(private service: ProductService, private _location: Location, private route: ActivatedRoute, private config: NgbRatingConfig) { }


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get("id")

    this.service.getbyId(this.id).subscribe(resp => {
      this.res = resp
    })

  }
  getData() {
    let product = { "id": +this.id }

    this.reviewForm.value.rating = this.currentRate
    this.reviewForm.value.product = product
    this.reviewForm.value.reviewBy = this.username
    this.reviewForm.value.verified = false


    this.service.postReview(this.reviewForm.value).subscribe(resp => { })
    alert("review saved")
    this._location.back()
  }
  get heading() { return this.reviewForm.get('heading') }
  get review() { return this.reviewForm.get('review') }
}
