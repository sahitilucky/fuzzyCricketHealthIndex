class Triangle{
	double a,b,c;
	public Triangle(double A,double B,double C){
		a=A;b=B;c=C;
	}
	double membership(double x){
		double trianglex = 0;
		if(x<=a){
			trianglex=0;
		}
		else if(x>=a && x<=b){
			trianglex=(double)(x-a)/(double)(b-a);
		}
		else if(x>=b && x<=c){
			trianglex=(double)(c-x)/(double)(c-b);
		}
		else if(x>=c){
			trianglex=0;
		}
		return trianglex;
	}
	
}

class Gaussian{
	double mean;
	double variance;
	public Gaussian(double m,double v){
		mean=m;
		variance=v;
	}
	double membership(double x){
		return Math.exp((-0.5*(Math.pow((x-mean/variance), 2))));
		
	}
}

class SigmoidMF{
	double a;double c;
	public SigmoidMF(double A,double C){
		a=A;c=C;
	}
	double membership(double x){
		double sigmoidmf=(double)1/(double)(1+Math.exp(a*(c-x)));
		return sigmoidmf;
	}
}
class Trapezoid{
	double a,b,c,d;
	
	public Trapezoid(double A,double B,double C,double D){
		a=A;b=B;c=C;d=D;
		
	}
	double membership(double x){
		double trianglex = 0;
		if(x<=a){
			trianglex=0;
		}
		else if(x>=a && x<=b){
			trianglex=(double)(x-a)/(double)(b-a);
		}
		else if(x>=b && x<=c){
			trianglex=(double)1;
		}
		else if(x>=c && x<=d){
			trianglex=(double)(d-x)/(double)(d-c);
		}

		else if(x>=d){
			trianglex=0;
		}
		return trianglex;
	}
}
class LeftHalfTrapezoid{
	double a,b,c;
	public LeftHalfTrapezoid(double A,double B,double C){
		a=A;b=B;c=C;
	}
	double membership(double x){
		double trianglex = 0;
		if(x>=a && x<=b){
			trianglex=(double)1;
		}
		else if(x>=b && x<=c){
			trianglex=(double)(c-x)/(double)(c-b);
		}

		else if(x>=c){
			trianglex=0;
		}
		return trianglex;
	}
	
}	
class RightHalfTrapezoid{
	double a,b,c;
	public RightHalfTrapezoid(double A,double B,double C){
		a=A;b=B;c=C;
	}
	double membership(double x){
		double trianglex = 0;
		if(x>=a && x<=b){
			trianglex=(double)(x-a)/(double)(b-a);
		}
		else if(x>=b && x<=c){
			trianglex=(double)1;
		}
		else if(x>=c){
			trianglex=0;
		}
		return trianglex;
	}
}

class Point{
	double point;
	public Point(double a){
		point=a;
	}
	double membership(double x){
		if(x==point){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	
	
}
	
	
	
	


