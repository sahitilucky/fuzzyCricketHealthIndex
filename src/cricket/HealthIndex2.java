import java.util.Arrays;


public class HealthIndex2 {
	LeftHalfTrapezoid verylow;
	Triangle low;
	Triangle med;
	Triangle high;
	RightHalfTrapezoid veryhigh;
	
	
	//Discretization to be decided.
	int discretization;
	
	//low  -  0
	//med  -  1
	//high  -  2
	
	double allarrays[][];

	public HealthIndex2() {
			
		verylow=new LeftHalfTrapezoid(0,10,30);
		low=new Triangle(10, 30, 50);
		med=new Triangle(30, 50, 70);
		high=new Triangle(50, 70, 90);
		veryhigh=new RightHalfTrapezoid(70,90,100);
		discretization=101;
		allmembershiparray();
	}
	
	public double[] fuzzify(double predictedrr){
		//low  -  0
		//med  -  1
		//high  -  2
		
		double[] output=new double[5];
		output[0]=verylow.membership(predictedrr);
		output[1]=low.membership(predictedrr);
		output[2]=med.membership(predictedrr);
		output[3]=high.membership(predictedrr);
		output[4]=veryhigh.membership(predictedrr);
		return output;
	}
	
	public void allmembershiparray(){
		
		allarrays=new double[5][discretization];

		double start=0;
		for(int i=0;i<101;i++){
			double[] output=fuzzify(start);
			for(int j=0;j<5;j++){
				allarrays[j][i]=output[j];
			}
			start+=1;
		}
		
	}
	
	//defuzzification using average.
	public double AverageDefuzzification(double[] membershipvalues){
		double output=0;double sum=0;
		System.out.println(Arrays.toString(membershipvalues));
		double start=0;
		for(int i=0;i<101;i++){
			output+=(membershipvalues[i]*start);
			sum+=membershipvalues[i];
			start+=1;
		}
		System.out.println("output: "+output+" sum: "+sum);
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
