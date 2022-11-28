import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, filterString: string): any {

    console.log(value)
    let r:any=[]
    let t = value.split(" ")
    let t2=filterString.split(" ")

    if (t[0].includes(filterString))
    return t[0];

    if (t[1].includes(filterString))
      return t[1]
    
    if (t[2].includes(filterString))
      return t[2]

    if (t[1].includes(t2[1]) && t[0].includes(t2[0]) || t[1].includes(t2[0]) && t[0].includes(t2[1]))
      return t[1]+" "+t[2] +t[3]


  }

}
