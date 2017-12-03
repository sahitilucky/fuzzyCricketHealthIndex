

public class FuzzyRules4 {
	HealthIndex2 HI;
	int[][][] RelationalMatrix=new int[3][4][3];
	double[] outputdeltahi;
	
	public FuzzyRules4(HealthIndex2 hi){
		HI=hi;
		MakeRules();
	}
	
	private void MakeRules() {
		// TODO Auto-generated method stub
		//Here filling the relation matrix,storing the linguistic values
		//The matrix
		//OversRemaining  	Required-Present    WicketLost       HealthIndex
		RelationalMatrix[0][2][0]=2;
		RelationalMatrix[0][2][1]=2;
		RelationalMatrix[0][2][2]=1;
		
		RelationalMatrix[0][1][0]=4;
		RelationalMatrix[0][1][1]=4;
		RelationalMatrix[0][1][2]=2;
		
		RelationalMatrix[0][0][0]=4;
		RelationalMatrix[0][0][1]=4;
		RelationalMatrix[0][0][2]=4;
		
		
		RelationalMatrix[1][2][0]=2;
		RelationalMatrix[1][2][1]=1;
		RelationalMatrix[1][2][2]=0;
		
		
		RelationalMatrix[1][1][0]=3;
		RelationalMatrix[1][1][1]=3;
		RelationalMatrix[1][1][2]=2;
		
		RelationalMatrix[1][0][0]=4;
		RelationalMatrix[1][0][1]=4;
		RelationalMatrix[1][0][2]=4;
		
		
		RelationalMatrix[2][2][0]=1;
		RelationalMatrix[2][2][1]=0;
		RelationalMatrix[2][2][2]=0;
		
		RelationalMatrix[2][1][0]=3;
		RelationalMatrix[2][1][1]=2;
		RelationalMatrix[2][1][2]=1;
		
		RelationalMatrix[2][0][0]=4;
		RelationalMatrix[2][0][1]=4;
		RelationalMatrix[2][0][2]=4;
		
		RelationalMatrix[0][3][0]=1;
		RelationalMatrix[0][3][1]=0;
		RelationalMatrix[0][3][2]=0;
		
		RelationalMatrix[1][3][0]=0;
		RelationalMatrix[1][3][1]=0;
		RelationalMatrix[1][3][2]=0;
		
		RelationalMatrix[2][3][0]=0;
		RelationalMatrix[2][3][1]=0;
		RelationalMatrix[2][3][2]=0;
		
	}
	public void Applyrules(double[] overs,double[] diffrr,double[] third){
		int i,j,k;
		
		outputdeltahi=new double[HI.discretization]; 
		for(i=0;i<HI.discretization;i++){
			outputdeltahi[i]=0;
		}
		double[] outputarray;
		for(i=0;i<3;i++){
			if(overs[i]!=0){
				for(j=0;j<4;j++){
					if(diffrr[j]!=0){
						for(k=0;k<3;k++){
							if(third[k]!=0){
								int linguisticvalue=RelationalMatrix[i][j][k];
								double cutfordeltar=Math.min(overs[i],Math.min(diffrr[j],third[k]));
								outputarray=HI.applycut(cutfordeltar,linguisticvalue);
								outputdeltahi=Takemax(outputdeltahi,outputarray);
							}
						}
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
