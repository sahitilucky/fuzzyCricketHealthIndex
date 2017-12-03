
public class OVERS {
	LeftHalfTrapezoid low;
	Triangle med;
	RightHalfTrapezoid high;
	public OVERS(){
		//initiate low,medium and so on with parameters
		low=new LeftHalfTrapezoid(0,0,10);
		med=new Triangle(5,10,15);
		high=new RightHalfTrapezoid(10,20,20);
	
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
