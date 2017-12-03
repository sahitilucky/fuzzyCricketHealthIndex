
public class WicketStrength {
	LeftHalfTrapezoid low;
	Triangle medium;
	RightHalfTrapezoid high;
	
	public WicketStrength(){
		//initiate low,medium and so on with parameters
		high=new RightHalfTrapezoid(30,60,100);
		medium=new Triangle(5,25,50);
		low=new LeftHalfTrapezoid(0.1,5,10);
	}
	
	public double[] fuzzify(double percentagediff){
		double[] output=new double[3];
		output[0]=low.membership(percentagediff);
		output[1]=medium.membership(percentagediff);
		output[2]=high.membership(percentagediff);
		return output;
	}

}
