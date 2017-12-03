
public class WicketsLost {
	LeftHalfTrapezoid low;
	Triangle med;
	RightHalfTrapezoid high;
	public WicketsLost() {
		//initiate low,medium and so on with parameters
		low=new LeftHalfTrapezoid(0,2,4);
		med=new Triangle(2,4,6);
		high=new RightHalfTrapezoid(5,8,10);
	
	}
	
	public double[] fuzzify(double deltarr){
		//0 - low
		//1 - med
		//2 - high
		double[] output=new double[3];
		output[0]=low.membership(deltarr);
		output[1]=med.membership(deltarr);
		output[2]=high.membership(deltarr);
		return output;
	}
}
