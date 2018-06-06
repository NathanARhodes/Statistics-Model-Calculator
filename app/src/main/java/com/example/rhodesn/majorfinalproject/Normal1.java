//Proportion hypothesis tests
package com.example.rhodesn.majorfinalproject;
public class Normal1 {

	boolean tt;
	boolean ut;
	double nul;
	double nq;
	double p;
	double a;
	int n;
	double se;

	Normal1() {

		tt = false;
		ut = false;
		nul = 0;
		nq = 0;
		p = 0;
		a = 0;
		n = 0;
		se = 0;
	}

	Normal1(boolean ttt, boolean utt, double nu, double p1, double al, int size) {

		tt = ttt;
		ut = utt;
		nul = nu;
		nq = 1 - nul;
		p = p1;
		a = al;
		n = size;
		se = Math.sqrt((nul * nq) / n);
	}

	public double zscore() {

		double z = ((p - nul) / se);
		return z;

	}

	public double pvalue() {

		StatsTable f = new StatsTable();

		double zs = (zscore());
		//System.out.println("The z=score is "+zs);
		double azs = Math.abs(zs);
		double pv=0;

		if (tt) {
	
				pv=2.0*(1-f.getTableValue(azs));
		
		}else if(ut) {
			
			if(zs<=0) {
				
				pv=f.getTableValue(azs);
			}else {
				
				pv=1-f.getTableValue(zs);
			}
		}else {
			if(zs<=0) {
				pv=1-f.getTableValue(azs);
			}else {
				
				pv=f.getTableValue(zs);
			}
			
			
		}

		return pv;
	}
	
	public String conclusion() {
		
		if(pvalue()<a) {
			
			return "Since the p-value is low, I reject the null hypothesis.";
		}else {
			return "Since the p-value is high, I fail to reject the null hypothesis.";

		}
	}

}
