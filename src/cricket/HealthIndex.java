import java.util.Arrays;


public class HealthIndex {
	LeftHalfTrapezoid low;
	Triangle med;
	RightHalfTrapezoid high;
	
	
	//Discretization to be decided.
	int discretization;
	
	//low  -  0
	//med  -  1
	//high  -  2
	
	double allarrays[][];

	public HealthIndex() {
			
		low=new LeftHalfTrapezoid(0,30,60);
		med=new Triangle(40, 60, 80);
		high=new RightHalfTrapezoid(60,90,100);
		discretization=101;
		allmembershiparray();
	}
	
	public double[] fuzzify(double predictedrr){
		//low  -  0
		//med  -  1
		//high  -  2
		
		double[] output=new double[3];
		output[0]=low.membership(predictedrr);
		output[1]=med.membership(predictedrr);
		output[2]=high.membership(predictedrr);
		return output;
	}
	
	public void allmembershiparray(){
		
		allarrays=new double[3][discretization];

		double start=0;
		for(int i=0;i<101;i++){
			double[] output=fuzzify(start);
			for(int j=0;j<3;j++){
				allarrays[j][i]=output[j];
			}
			start+=1;
		}
		
	}
	
	//defuzzification using average.
	public double AverageDefuzzification(double[] membershipvalues){
		double output=0;double sum=0;
	//	System.out.println(Arrays.toString(membershipvalues));
		double start=0;
		for(int i=0;i<101;i++){
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
		
		double start=0;
		for(int i=0;i<100;i++){
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
