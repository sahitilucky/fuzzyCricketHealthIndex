

public class FuzzyRules3 {
	HealthIndex HI;
	int[][] Relationmatrix=new int[3][2];
	double[] outputdeltahi;
	
	public FuzzyRules3(HealthIndex hi){
		HI=hi;
		MakeRules();
	}
	
	private void MakeRules() {
		// TODO Auto-generated method stub
		//Here filling the relation matrix,storing the linguistic values
		//The matrix
		// Overs  	WicketStrength    DeltaR       DeltaHI
		//high   		high           whatever      NS     
        //medium		high           whatever      NM
		//low    		high           whatever      NB
		//high		    med            whatever		 NS      
        //medium		med            whatever      NM
		//low    	    med            whatever      NM
		//high		    low            whatever		 NS      
        //medium		low            whatever      NS
		//low    	    low            whatever      NM
		Relationmatrix[0][0]=0;
		Relationmatrix[1][0]=1;
		Relationmatrix[2][0]=2;
		
		Relationmatrix[0][1]=0;
		Relationmatrix[1][1]=1;
		Relationmatrix[2][1]=1;

	
	}
	public void Applyrules(double[] overs,double[] bts){
		int i,j,k;
		
		outputdeltahi=new double[HI.discretization]; 
		for(i=0;i<HI.discretization;i++){
			outputdeltahi[i]=0;
		}
		double[] outputarray;
		for(i=0;i<3;i++){
			if(overs[i]!=0){
				for(j=0;j<2;j++){
					if(bts[j]!=0){
						int linguisticvalue=Relationmatrix[i][j];
						double cutfordeltar=Math.min(overs[i],bts[j]);
						outputarray=HI.applycut(cutfordeltar,linguisticvalue);
						outputdeltahi=Takemax(outputdeltahi,outputarray);
					}
				}
			}
		}
	}

	
	private double[] Takemax(double[] outputdeltar, double[] outputarray) {
		// TODO Auto-generated method stub
		for(int i=0;i<outputdeltar.length;i++){
			outputdeltar[i]=Math.max(outputdeltar[i], outputarray[i]);
		}
		return outputdeltar;
	}
	public double Averagedefuzzification() {
		// TODO Auto-generated method stub
		double output=HI.AverageDefuzzification(outputdeltahi);
		return output;
	}
	public double Maximadefuzzification() {
		// TODO Auto-generated method stub
		double output=HI.MaximaDefuzzification(outputdeltahi);
		return output;
	}

}
