import java.util.Arrays;


public class FuzzyRules {
	DeltaHI deltaHI;
	int[][][] Relationmatrix=new int[3][4][3];
	double[] outputdeltahi;
	
	public FuzzyRules(DeltaHI deltahi){
		deltaHI=deltahi;
		MakeRules();
	}
	
	private void MakeRules() {
		// TODO Auto-generated method stub
		//Here filling the relation matrix,storing the linguistic values
		//The matrix
		// Overs  	WicketStrength    DeltaR       DeltaHI
		//whatever		ZR              ND           NF
        //whatever		ZR              ZR           ZR
		//whatever		ZR              PD           PF
		//high   		high           whatever      NS     
        //medium		high           whatever      NM
		//low    		high           whatever      NB
		//high		    med            whatever		 NS      
        //medium		med            whatever      NM
		//low    	    med            whatever      NM
		//high		    low            whatever		 NS      
        //medium		low            whatever      NS
		//low    	    low            whatever      NM
		
		
		
		Relationmatrix[0][3][0]=3;
		Relationmatrix[0][3][1]=4;
		Relationmatrix[0][3][2]=5;
		Relationmatrix[1][3][0]=3;
		Relationmatrix[1][3][1]=4;
		Relationmatrix[1][3][2]=5;
		Relationmatrix[2][3][0]=3;
		Relationmatrix[2][3][1]=4;
		Relationmatrix[2][3][2]=5;

		Relationmatrix[0][2][0]=0;Relationmatrix[0][2][1]=0;Relationmatrix[0][2][2]=0;
		Relationmatrix[1][2][0]=1;Relationmatrix[1][2][1]=1;Relationmatrix[1][2][2]=1;
		Relationmatrix[2][2][0]=2;Relationmatrix[2][2][1]=2;Relationmatrix[2][2][2]=2;
		
		Relationmatrix[0][1][0]=1;Relationmatrix[0][1][1]=1;Relationmatrix[0][1][2]=1;
		Relationmatrix[1][1][0]=1;Relationmatrix[1][1][1]=1;Relationmatrix[1][1][2]=1;
		Relationmatrix[2][1][0]=2;Relationmatrix[2][1][1]=2;Relationmatrix[2][1][2]=2;
		
		
		Relationmatrix[0][0][0]=1;Relationmatrix[0][0][1]=1;Relationmatrix[0][0][2]=1;
		Relationmatrix[1][0][0]=2;Relationmatrix[1][0][1]=2;Relationmatrix[1][0][2]=2;
		Relationmatrix[2][0][0]=2;Relationmatrix[2][0][1]=2;Relationmatrix[2][0][2]=2;
			
	}
	public void Applyrules(double[] overs,double[] rtsdiff,double[] deltarr){
		int i,j,k;
		
		outputdeltahi=new double[deltaHI.discretization]; 
		for(i=0;i<deltaHI.discretization;i++){
			outputdeltahi[i]=0;
		}
		double[] outputarray;
		for(i=0;i<3;i++){
			if(overs[i]!=0){
				for(j=0;j<4;j++){
					if(rtsdiff[j]!=0){
						for(k=0;k<3;k++){
							if(deltarr[k]!=0){
								int linguisticvalue=Relationmatrix[i][j][k];
								double cutfordeltar=Math.min(overs[i], Math.min(rtsdiff[j], deltarr[k]));
								outputarray=deltaHI.applycut(cutfordeltar,linguisticvalue);
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
		double output=deltaHI.AverageDefuzzification(outputdeltahi);
		return output;
	}
	public double Maximadefuzzification() {
		// TODO Auto-generated method stub
		double output=deltaHI.MaximaDefuzzification(outputdeltahi);
		return output;
	}

}
