
class BowlingTeamStrength {
	//ranges from 0 to 500 
	//450 to 500 is very high.
	//
	RightHalfTrapezoid high;
	Trapezoid nothigh;
	public BowlingTeamStrength(){
		//initiate low,medium and so on with parameters
		high=new RightHalfTrapezoid(350, 480,1100);
		nothigh=new Trapezoid(0,0,400,400);
	
	}
	
	public double[] fuzzify(int rts){
		double[] output=new double[2];
		output[0]=nothigh.membership(rts);
		output[1]=high.membership(rts);
		return output;
	}
	
}
