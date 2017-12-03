import java.util.Arrays;


public class DeltaHI {
	LeftHalfTrapezoid NB;
	Triangle NM;
	RightHalfTrapezoid NS;
	LeftHalfTrapezoid ND;
	Triangle ZR;
	RightHalfTrapezoid PD;
	
	
	//Discretization to be decided.
	int discretization;
	
	//NB  -  0
	//NM  -  1
	//NS  -  2
	//ND  -  3
	//ZR  -  4
	//PD  -  5

	double allarrays[][];

	public DeltaHI(){
		
		PD=new RightHalfTrapezoid(0,5,10);
		ZR=new Triangle(-5, 0, 5);
		ND=new LeftHalfTrapezoid(-5,-5,0 );
	//	NS=new Triangle(-20,-15,-10);
	//	NM=new Triangle(-25,-20,-15);
	//	NB=new LeftHalfTrapezoid(-40,-25,-20);
		NS=new RightHalfTrapezoid(-45,-30,-20);
		NM=new Triangle(-55,-45,-35);
		NB=new LeftHalfTrapezoid(-60,-55,-45);
			
		discretization=(71);
		allmembershiparray();
	}
	
	public double[] fuzzify(double predictedrr){
		//NB  -  0
		//NM  -  1
		//NS  -  2
		//ND  -  3
		//ZR  -  4
		//PD  -  5
		
		double[] output=new double[6];
		output[0]=NB.membership(predictedrr);
		output[1]=NM.membership(predictedrr);
		output[2]=NS.membership(predictedrr);
		output[3]=ND.membership(predictedrr);
		output[4]=ZR.membership(predictedrr);
		output[5]=PD.membership(predictedrr);
		return output;
	}
	
	public void allmembershiparray(){
		
		allarrays=new double[6][discretization];

		double start=-60;
		for(int i=0;i<discretization;i++){
			double[] output=fuzzify(start);
			for(int j=0;j<6;j++){
				allarrays[j][i]=output[j];
			}
			start+=1;
		}
		
	}
	
	//defuzzification using average.
	public double AverageDefuzzification(double[] membershipvalues){
		double output=0;double sum=0;
	//	System.out.println(Arrays.toString(membershipvalues));
		double start=-60;
		System.out.println(discretization);
		for(int i=0;i<discretization;i++){
			output+=(membershipvalues[i]*start);
			sum+=membershipvalues[i];
			start+=1;
		}
	//	System.out.println("output: "+output+" sum: "+sum);
		output=output/sum;
		return output;
	}
	
	//defuzzification using maximum.
	public double MaximaDefuzzification(double[] membershipvalues){
		double output=0;double sum=0;
		double maximum=0;
	//	System.out.println(Arrays.toString(membershipvalues));
		
		double start=-60;
		for(int i=0;i<discretization;i++){
			if(membershipvalues[i]>maximum){
				maximum=membershipvalues[i];
				output=(membershipvalues[i]*start);
				sum=membershipvalues[i];
			}
			else if(membershipvalues[i]==maximum){
				maximum=membershipvalues[i];
				output+=(membershipvalues[i]*start);
				sum+=membershipvalues[i];
			}
			start+=1;
		}
	//	System.out.println("output: "+output+" sum: "+sum);
		output=output/sum;
		return output;
	}

	public double[] applycut(double cutfordeltar,int linguisticvalue) {
		// TODO Auto-generated method stub
		double[] output=new double[discretization];
		for(int i=0;i<discretization;i++){
			output[i]=Math.min(cutfordeltar, allarrays[linguisticvalue][i]);
		}
		return output;
	}

}
