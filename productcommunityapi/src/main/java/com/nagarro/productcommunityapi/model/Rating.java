package com.nagarro.productcommunityapi.model;

public class Rating {
		
		String sum;
		String count;
		public Rating() {
			// TODO Auto-generated constructor stub
		}
		
		public Rating(String sum, String count) {
			super();
			this.sum = sum;
			this.count = count;
		}

		public String getSum() {
			return sum;
		}
		public void setSum(String sum) {
			this.sum = sum;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		 
		

}
