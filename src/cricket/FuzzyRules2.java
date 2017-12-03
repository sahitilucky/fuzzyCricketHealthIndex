

public class FuzzyRules2 {
	DeltaHI deltaHI;
	int[][] Relationmatrix=new int[3][3];
	double[] outputdeltahi;
	
	public FuzzyRules2(DeltaHI deltahi){
		deltaHI=deltahi;
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
		
		Relationmatrix[0][2]=0;
		Relationmatrix[1][2]=1;
		Relationmatrix[2][2]=2;
		
		Relationmatrix[0][1]=1;
		Relationmatrix[1][1]=1;
		Relationmatrix[2][1]=2;
		
		
		Relationmatrix[0][0]=1;
		Relationmatrix[1][0]=2;
		Relationmatrix[2][0]=2;
			
	}
	public void Applyrules(double[] overs,double[] rtsdiff){
		int i,j,k;
		
		outputdeltahi=new double[deltaHI.discretization]; 
		for(i=0;i<deltaHI.discretization;i++){
			outputdeltahi[i]=0;
		}
		double[] outputarray;
		for(i=0;i<3;i++){
			if(overs[i]!=0){
				for(j=0;j<3;j++){
					if(rtsdiff[j]!=0){
						int linguisticvalue=Relationmatrix[i][j];
						double cutfordeltar=Math.min(overs[i],rtsdiff[j]);
						outputarray=deltaHI.applycut(cutfordeltar,linguisticvalue);
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
		double output=deltaHI.AverageDefuzzification(outputdeltahi);
		return output;
	}
	public double Maximadefuzzification() {
		// TODO Auto-generated method stub
		double output=deltaHI.MaximaDefuzzification(outputdeltahi);
		return output;
	}

}
