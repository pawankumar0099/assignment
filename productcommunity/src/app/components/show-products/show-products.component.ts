import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ProductService } from "src/app/service/product.service";
@Component({
  selector: "app-show-products",
  templateUrl: "./show-products.component.html",
  styleUrls: ["./show-products.component.sass"],
})
export class ShowProductsComponent implements OnInit {
  searchString: any;
  productArray: any = [];
  arr: any = [];
  uniqueBrandArray: any = [];
  rating: any = [];
  uniqueNameArray: any = [];

  constructor(private route: ActivatedRoute, private service: ProductService) {}

  ngOnInit(): void {
    this.searchString = this.route.snapshot.paramMap.get("search");

    this.service.getProducts(this.searchString).subscribe((resp) => {
      this.productArray = resp;
      this.uniqueBrandArray = resp;
      this.arr = resp;
      if (this.productArray.length == 0) {
        alert("result not found");
      }
      this.uniqueBrandArray = [
        ...new Map(
          this.uniqueBrandArray.map((item: any) => [item["brand"], item])
        ).values(),
      ];
      this.uniqueNameArray = [
        ...new Map(
          this.productArray.map((item: any) => [item["name"], item])
        ).values(),
      ];

      for (let i = 0; i < this.productArray.length; i++) {
        let t: number;
        this.service
          .getrating(this.productArray[i].id)
          .subscribe((respo: any) => {
            this.productArray[i].sum = respo.sum;
            this.productArray[i].count = respo.count;
          });
      }
    });
  }

  temp: any = [];
  temp1: any = [];
  filterByBrand(a: any) {
    if (a.target.checked) {
      this.temp = this.arr.filter((e: any) => e.brand == a.target.value);

      this.productArray = [];
      if (this.temp1.length != 0) {
        for (var i = 0; i < this.temp.length; i++) {
          var flag = 0;
          for (var j = 0; j < this.temp1[0].length; j++) {
            if (this.temp1[0][j].id == this.temp[i].id) {
              flag = 1;
              break;
            }
          }
          if (flag == 0) {
            let t: any = [];
            t.push(this.temp[i]);
            this.temp1.push(t);
            console.log(this.temp1);
          }
        }
      } else {
        this.temp1.push(this.temp);
      }

      for (let i = 0; i < this.temp1.length; i++) {
        var fisrtArray = this.temp1[i];

        for (let i = 0; i < fisrtArray.length; i++) {
          this.productArray.push(fisrtArray[i]);
        }
      }
    } else {
      this.temp = this.productArray.filter(
        (e: any) => e.brand != a.target.value
      );

      this.temp1 = [];
      this.productArray = [];
      if (this.temp.length == 0) {
        window.location.reload();
      } else this.temp1.push(this.temp);

      for (let i = 0; i < this.temp1.length; i++) {
        var fisrtArray = this.temp1[i];

        for (let i = 0; i < fisrtArray.length; i++) {
          this.productArray.push(fisrtArray[i]);
        }
      }
    }
  }

  filterbyName(a: any) {
    if (a.target.checked) {
      this.temp = this.arr.filter((e: any) => e.name == a.target.value);

      this.productArray = [];
      if (this.temp1.length != 0) {
        for (var i = 0; i < this.temp.length; i++) {
          var flag = 0;
          for (var j = 0; j < this.temp1.length; j++) {
            if (this.temp1[j][0].id == this.temp[i].id) {
              flag = 1;
              break;
            }
          }
          if (flag == 0) {
            let t: any = [];
            t.push(this.temp[i]);
            this.temp1.push(t);
            console.log(this.temp1);
          }
        }
      } else {
        this.temp1.push(this.temp);
      }

      for (let i = 0; i < this.temp1.length; i++) {
        var fisrtArray = this.temp1[i];

        for (let i = 0; i < fisrtArray.length; i++) {
          this.productArray.push(fisrtArray[i]);
        }
      }
    } else {
      this.temp = this.productArray.filter(
        (e: any) => e.name != a.target.value
      );

      this.temp1 = [];
      this.productArray = [];
      if (this.temp.length == 0) {
        window.location.reload();
      } else this.temp1.push(this.temp);

      for (let i = 0; i < this.temp1.length; i++) {
        var fisrtArray = this.temp1[i];

        for (let i = 0; i < fisrtArray.length; i++) {
          this.productArray.push(fisrtArray[i]);
        }
      }
    }
  }
  filterByCode(a: any) {
    if (a.target.checked) {
      this.temp = this.arr.filter((e: any) => e.code == a.target.value);

      this.productArray = [];
      if (this.temp1.length != 0) {
        for (var i = 0; i < this.temp.length; i++) {
          var flag = 0;
          for (var j = 0; j < this.temp1.length; j++) {
            if (this.temp1[j][0].id == this.temp[i].id) {
              flag = 1;
              break;
            }
          }
          if (flag == 0) {
            let t: any = [];
            t.push(this.temp[i]);
            this.temp1.push(t);
            console.log(this.temp1);
          }
        }
      } else {
        this.temp1.push(this.temp);
      }

      for (let i = 0; i < this.temp1.length; i++) {
        var fisrtArray = this.temp1[i];

        for (let i = 0; i < fisrtArray.length; i++) {
          this.productArray.push(fisrtArray[i]);
        }
      }
    } else {
      this.temp = this.productArray.filter(
        (e: any) => e.code != a.target.value
      );

      this.temp1 = [];
      this.productArray = [];
      if (this.temp.length == 0) {
        window.location.reload();
      } else this.temp1.push(this.temp);

      for (let i = 0; i < this.temp1.length; i++) {
        var fisrtArray = this.temp1[i];

        for (let i = 0; i < fisrtArray.length; i++) {
          this.productArray.push(fisrtArray[i]);
        }
      }
    }
  }
}
