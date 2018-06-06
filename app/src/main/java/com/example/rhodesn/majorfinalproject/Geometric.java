
package com.example.rhodesn.majorfinalproject;
public class Geometric {
	
	private double p;
	private int t;
	
	Geometric(){
		p=0;
		t=0;
	}
	
	Geometric(double probability, int trails){
		
		p=probability;
		t=trails;
	}
	
	public double expectedValue() {
		
		return 1.0/p;
	}
	public double standardDeviation() {
		
		return Math.sqrt((1-p)/(p*p));
	}
	public double prob() {
		double q=1-p;
		double r=1-p;
		for(int i=1; i<t-1;i++) {
			
			r=r*q;
		}
		
		return r*p;
	}
	public double probc() {
		double sum=0;

		double q=1-p;

		for (int go=t;go>0;go--) {
			double r=1-p;
			for(int i=1; i<go-1;i++) {

				r=r*q;
			}
			if(go!=1) {
				sum+=r*p;
			}
			else {
				sum+=p;
			}
		}
		return sum;
	}

}
