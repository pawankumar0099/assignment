import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.sass']
})
export class SearchComponent implements OnInit {

  res: any = []
  uniqueBrandArray: any = []
  constructor(private service: ProductService) { }

  ngOnInit(): void {
  }

  filterFunction(v: any) {
    if (v.target.value != '')
      this.service.getProducts(v.target.value).subscribe((resp) => {
        this.res = resp

        this.uniqueBrandArray = [...new Map(this.res.map((item: any) =>
          [item["brand"], item])).values()];
      })
  }
}
