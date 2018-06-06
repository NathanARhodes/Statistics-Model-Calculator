package com.example.rhodesn.majorfinalproject;
public class t {

	
	public double m;
	public int c;
	public double z;
	public int n;
	public double sd;
	public int df;
	
	t(){
		
		m=0;
		c=0;
		z=0;
		n=0;
		sd=0;
	}
	
	t(double mean, int con, int sam, double ser){
		
		m=mean;
		c=con;
		n=sam;
		sd=ser;
		df=n-1;
		if(c==98) {
			z=2.33;
		}
		else if(c==95) {
			z=1.96;
		}
		else if(c==90) {
			z=1.65;
		}
	}
	public double upper() {
		
		double se=(sd/Math.sqrt(n));
		return m+(se*z);
		
	}
	public double lower() {
		

		double se=(sd/Math.sqrt(n));
		return m-(se*z);
		
	}
}
