
public class DiffRRAvg {
	LeftHalfTrapezoid ND;
	Triangle ZR;
	RightHalfTrapezoid PD;
	public DiffRRAvg(){
		//initiate low,medium and so on with parameters
		PD=new RightHalfTrapezoid(0,2,20);
		ZR=new Triangle(-2,0,2);
		ND=new LeftHalfTrapezoid(-10,-3,0);
	
	}
	
	public double[] fuzzify(double deltarr){
		//0 - ND
		//1 - ZR
		//2 - PD
		double[] output=new double[3];
		output[0]=ND.membership(deltarr);
		output[1]=ZR.membership(deltarr);
		output[2]=PD.membership(deltarr);
		return output;
	}
}
