
public class RequiredrrPresentrr {
	LeftHalfTrapezoid low;
	Triangle med;
	Trapezoid high;
	RightHalfTrapezoid veryhigh;
	public RequiredrrPresentrr() {
	
		//initiate low,medium and so on with parameters
		low=new LeftHalfTrapezoid(-20,-3,1);
		med=new Triangle(0,1.5,3);
		high=new Trapezoid(2,5,7,10);
		veryhigh=new RightHalfTrapezoid(7,30,70);
	}
	
	public double[] fuzzify(double deltarr){
		//0 - low
		//1 - med
		//2 - high
		double[] output=new double[4];
		output[0]=low.membership(deltarr);
		output[1]=med.membership(deltarr);
		output[2]=high.membership(deltarr);
		output[3]=veryhigh.membership(deltarr);
		
		return output;
	}

}
