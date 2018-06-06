// Elaine Townley and Nathan Rhodes
package com.example.rhodesn.majorfinalproject;
public class Normal {
	
	public double p;
	public int c;
	public double z;
	public int n;
	
	Normal(){
		
		p=0;
		c=0;
		z=0;
		n=0;
	}
	
	Normal(double prob, int con, int sam){
		
		p=prob;
		c=con;
		n=sam;
		if(con==98) {
			z=2.33;
		}
		else if(con==95) {
			z=1.96;
		}
		else if(con==90) {
			z=1.65;
		}
	}
	public double upper() {
		
		double q=1-p;
		double se=Math.sqrt(p*q/n);
		return p+(se*z);
		
	}
	public double lower() {
		
		double q=1-p;
		double se=Math.sqrt(p*q/n);
		return p-(se*z);
		
	}
	
	
	
	

}
