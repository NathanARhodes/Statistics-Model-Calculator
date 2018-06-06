package com.example.rhodesn.majorfinalproject;
//Elaine Townley and Nathan Rhodes

//use recursion to create a cdf function
import java.util.*;

public class Binomial {
	
	int n;
	int s;
	double p;
	int c;
	
	Binomial(){
		
		n=0;
		s=0;
		p=0;
		c=0;
	}
	
	Binomial(int num, int ns, double prob, int choice){
		
		n=num;
		s=ns;
		p=prob;
		c=choice;
	}
	
	public double expectedValue() {
		
		return n*p;
	}
	
	public double standardDeviation() {
		
		return Math.sqrt(n*p*(1-p));
	}
	public double prob() {
		
		double nf= n;
		double sf=s;
		double xf=n-s;
		for(double i=n-1;i>0;i--) {
			
			nf=nf*i;
		}
		
		for(double i2=s-1;i2>0;i2--) {
			
			sf=sf*i2;
		}
		
		for(double i3=n-s-1;i3>0;i3--) {
			
			xf=xf*i3;
		}
		
		double com=nf/(sf*xf);
		double px=p;
		for(double h=1;h<s;h++) {
			
			px=px*p;
		}
		
		double q=1-p;
		double qx=1-p;
		for (double h2=1; h2<n-s;h2++) {
			
			qx=qx*q;
		}
			
			return com*px*qx;
		
	
	}
	
	
	public double helper() {
		double sum=0;
		double s2=s;
		double sf=s;
		
		while(s2>=0) {
			sf=s2;
			double xf=n-s2;
		double nf= n;
		for(double i=n-1;i>0;i--) {
			
			nf=nf*i;
		}
		
		for(double i2=s2-1;i2>0;i2--) {
			
			sf=sf*i2;
		}
		
		for(double i3=n-s2-1;i3>0;i3--) {
			
			xf=xf*i3;
		}
		if(sf>0) {
			double com=nf/(sf*xf);
		
	
		double px=p;
		for(double h=1;h<s2;h++) {

			px=px*p;
		}
		
		double q=1-p;
		double qx=1-p;
		for (double h2=1; h2<n-s2;h2++) {
			
			qx=qx*q;
		}
		
			sum+= com*px*qx;
		}
		else {
			double d=n;
			double qn=1-p;
			double q=1-p;
			while (d>1) {
				
				qn=qn*q;
				d--;
			}
			sum+=qn;
		}
		s2--;
		}
		return sum;
		
	}
	
	
	

}
