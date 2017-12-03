import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class MatchProcessing2 {
	WicketStrength WS;
	OVERS o;
	DiffRRAvg diffrr;
	BowlingTeamStrength BTS;
	FuzzyRules2 f;
	
	DeltaHI deltaHI;
	
	int Actualteam1runs;		//used for training 
	int Actualteam2runs; 
	int BREAK=0;
	String team1name,team2name;
	String team1shortname,team2shortname;
	String winner;
        FileWriter file2;
	BufferedWriter filewriter;
	FuzzyRules3 f3;
	FuzzyRules4 f4;
	HealthIndex HI;
	HealthIndex2 HI2;
	WicketsLost WL;
	RequiredrrPresentrr RPrr;
	double DipScore1=0;
	double DipScore2=0;
	double noofdips=0;
	double noofdips2=0;
	ArrayList<Double> DipScoresList1;
	ArrayList<Double> DipScoresList2;
	ArrayList<Integer> WicketDrops1;
	ArrayList<Integer> WicketDrops2;
	public void ProcessMatch(String filename) throws IOException{
		WS= new WicketStrength();
		deltaHI=new DeltaHI();
		diffrr=new DiffRRAvg();
		BTS=new BowlingTeamStrength();
		f=new FuzzyRules2(deltaHI);
		o=new OVERS();
		HI=new HealthIndex();
		HI2=new HealthIndex2();
		RPrr=new RequiredrrPresentrr();
		WL=new WicketsLost();
	//	f2=new FuzzyRules2(HI);
		f3=new FuzzyRules3(HI);
		f4=new FuzzyRules4(HI2);
		DipScoresList1=new ArrayList<Double>();
		DipScoresList2=new ArrayList<Double>();
		file2=new FileWriter("output1.txt");
		filewriter=new BufferedWriter(file2);
		WicketDrops1=new ArrayList<Integer>();
		WicketDrops2=new ArrayList<Integer>();
	 ArrayList<String> Team1=new ArrayList<String>();
	 ArrayList<Integer> Team1Battingscores=new ArrayList<Integer>();
	 ArrayList<String> Team2 = new ArrayList<String>();
	 ArrayList<Integer> Team2Battingscores=new ArrayList<Integer>();
	 ArrayList<Integer> Team1Bowlingscores=new ArrayList<Integer>();
	 ArrayList<Integer> Team2Bowlingscores=new ArrayList<Integer>();
	  
	 Getallplayers(filename,Team1,Team2,Team1Battingscores,Team2Battingscores,Team1Bowlingscores,Team2Bowlingscores);
	 if(BREAK==1){
		 BREAK=0;
		 return;
	 }
	 
//	 System.out.println(Team1);
//	 System.out.println(Team2);
//	 System.out.println(Team1Battingscores);
	 FileReader file=new FileReader(filename);
	 BufferedReader filereader=new BufferedReader(file);
	 String line;
	 for(int i=0;i<6;i++){
		 line=filereader.readLine();
                 if(i==3){
                     winner = line;
                 }
                 
	 }
	 line=filereader.readLine();
	 String[] items=line.split(":");
	 String Venue=items[1].substring(1, items[1].length());
	 double pitchavgscore=Getpitchscore(Venue);
	 line=filereader.readLine();
	 line=filereader.readLine();
	 
	 int Overs=0;
	 int allwickets=0;	//wickts lost are calculated and loop is stopped when reached 20.
	 int allruns=0;		//runs incremented evry over and finally stored in team 1 or team2 accordingly.
	 int team1runs=0;	//team1runs
	 int team2runs=0;
	 
	 ArrayList<String> PlayersGoneTeam1=new ArrayList<String>();
	 ArrayList<String> PlayersGoneTeam2=new ArrayList<String>();
	 double HealthIndex = 0;
	 
	 
	 line=filereader.readLine();
	 while(line!=null){
		 PlayersGoneTeam1=new ArrayList<String>();
		 if(line.equals("2nd innings")){
			 break;
		 }
		 int runs=Integer.parseInt(line);

		 allruns+=runs;
		 Overs++;
		 double Runrate=(double)allruns/(double)Overs;
		 double currentrunrate=runs;
		 
		 line=filereader.readLine();
		 line=filereader.readLine();
		 int wickets=Integer.parseInt(line);
		 allwickets+=wickets;
		 if(wickets!=0){
			 for(int i=0;i<wickets;i++){
				 String playerout=filereader.readLine();
				 PlayersGoneTeam1.add(playerout);
			 }
		 }
		 //double Diffrunrate=currentrunrate-pitchavgscore;
		 double Diffrunrate=Runrate-pitchavgscore;
		 double DeltaHI=0;
		 if(Overs>=0){
			 if(wickets!=0)
			 {
			//	 HealthIndex=GetscaledHI(Diffrunrate,Team2Bowlingscores);;
			//	 filewriter.write(Integer.toString(Overs)+" "+Double.toString(HealthIndex)+"\n");
				 DeltaHI=GetHealthIndex(Team1,Team1Battingscores,Overs,PlayersGoneTeam1);
				 HealthIndex += DeltaHI;
				 DipScore1+=DeltaHI;
				 noofdips+=1;
				 DipScoresList1.add(Math.round(DeltaHI*100)/(double)100);
				 WicketDrops1.add(Overs);
				 System.out.println("Health Index1: "+HealthIndex);
			 }
			 else{
				 HealthIndex=GetscaledHI(Diffrunrate,Team2Bowlingscores);;
				 System.out.println("Health Index2: "+HealthIndex);
			 }
			 // System.out.println("Health Index: "+HealthIndex);
			 System.out.println("Presentrunrate: "+Runrate+"Avgrunrate:"+pitchavgscore+"wickets: "+wickets);
			 if(HealthIndex<0){
				 filewriter.write(Integer.toString(Overs)+" "+Double.toString(0)+" 0"+"\n");
			 }
			 else{
				 filewriter.write(Integer.toString(Overs)+" "+Double.toString(HealthIndex)+" 0"+"\n");
			 }
			 if(wickets!=0){
				 HealthIndex-=DeltaHI;
				 if(HealthIndex<0){
					 filewriter.write(Integer.toString(Overs)+" "+Double.toString(0)+" 1"+"\n");
				 }
				 else{
					 filewriter.write(Integer.toString(Overs)+" "+Double.toString(HealthIndex)+" 1"+"\n");
				 }
			 }
		 }
		 line=filereader.readLine();
	}
	System.out.println("Overs: "+Overs+"TotalScore: "+allruns);
	team1runs=allruns;
	int team1wickets=allwickets;
	filewriter.close();
	file2=new FileWriter("output2.txt");
	filewriter=new BufferedWriter(file2);
	FileWriter file3=new FileWriter("output3.txt");
	BufferedWriter  bf=new BufferedWriter(file3);
	
	
	line=filereader.readLine();
	Overs=0;
	allruns=0;
	allwickets=0;
	line=filereader.readLine();
	double RequiredRunrate=(double)team1runs/(double)(20);
	double HealthIndex2=0;
	while(line!=null  ){
		 
		 if(line.equals("Incompletematch")){
			 break;
		 }
		 int runs=Integer.parseInt(line);
		 double Prevrunrate=(double)allruns/(double)Overs;
		 allruns+=runs;
		 Overs++;
		 double Runrate=(double)allruns/(double)Overs;
		 double presentrunrate=(double)runs;
		 double Diffrunrate=Runrate-pitchavgscore;
		 PlayersGoneTeam2=new ArrayList<String>();
		 line=filereader.readLine();
		 line=filereader.readLine();
		 int wickets=Integer.parseInt(line);
		 allwickets+=wickets;
		 if(wickets!=0){
			 for(int i=0;i<wickets;i++){
				 String playerout=filereader.readLine();
				 PlayersGoneTeam2.add(playerout);
			 }
		 }
		 RequiredRunrate=(double)(team1runs-allruns)/(double)(20-Overs);
		 double diffrr=RequiredRunrate-Runrate;
		 HealthIndex=GetHealthIndex2((20-Overs),allwickets,diffrr);
		 int Wicketlost=0;
		 if(wickets>0){
			 Wicketlost=1;
		 }
		 
		 System.out.println("RequiredRunrate:"+RequiredRunrate +" HealthIndex: "+HealthIndex+" diffrr:"+diffrr);
		 if(Overs!=20){
			 filewriter.write(Integer.toString(Overs)+" "+Double.toString(HealthIndex)+" "+Wicketlost+"\n");
		 }
		 double DeltaHI=0;
		 if(Overs>=0){
			 if(wickets!=0)
			 {
			//	 HealthIndex=GetscaledHI(Diffrunrate,Team2Bowlingscores);;
			//	 filewriter.write(Integer.toString(Overs)+" "+Double.toString(HealthIndex)+"\n");
				 DeltaHI=GetHealthIndex(Team2,Team2Battingscores,Overs,PlayersGoneTeam2);
				 DipScore2+=DeltaHI;
				 noofdips2+=1;
				 HealthIndex2 += DeltaHI;
				 DipScoresList2.add(Math.round(DeltaHI*100)/(double)100);
				 WicketDrops2.add(Overs);
				 
			 }
			 else{
				 HealthIndex2=GetscaledHI(Diffrunrate,Team1Bowlingscores);;
			 }
			 System.out.println("Health Index2: "+HealthIndex2);
			 System.out.println("Presentrunrate: "+Runrate+"Avgrunrate:"+pitchavgscore+"wickets: "+wickets);
			 if(HealthIndex2<0){
				 bf.write(Integer.toString(Overs)+" "+Double.toString(0)+" 0"+"\n");
			 }
			 else{
				 bf.write(Integer.toString(Overs)+" "+Double.toString(HealthIndex2)+" 0"+"\n");
			 }
			 if(wickets!=0){
				 HealthIndex2-=DeltaHI;
				 if(HealthIndex2<0){
					 bf.write(Integer.toString(Overs)+" "+Double.toString(0)+" 1"+"\n");
				 }
				 else{
					 bf.write(Integer.toString(Overs)+" "+Double.toString(HealthIndex2)+" 1"+"\n");
				 }
			}
		 }
		 line=filereader.readLine();
	}
	 if(allruns>team1runs){
		 filewriter.write(Integer.toString(Overs)+" "+Double.toString(100)+" 0"+"\n");
	 }
	 else{
		 filewriter.write(Integer.toString(Overs)+" "+Double.toString(0)+" 0"+"\n");
	 }

	filewriter.close();
	bf.close();
	team2runs=allruns;
	System.out.println("Overs: "+Overs+"TotalScore: "+allruns);
	System.out.println("DipScore: "+DipScore1);
	System.out.println("AvgDipScore: "+(DipScore1/noofdips));
	System.out.println("DipScore2: "+DipScore2);
	System.out.println("AvgDipScore2: "+(DipScore2/noofdips2));
	System.out.println(DipScoresList1);
	System.out.println(DipScoresList2);
	if(team2runs>team1runs){
		System.out.println("team2 won");
	}
	else{
		System.out.println("team1 won");
	}
 }



private double Getpitchscore(String venue) throws IOException {
		// TODO Auto-generated method stub
		double pitchscore=0;
		FileReader file=new FileReader("pitch.txt");
		BufferedReader filereader=new BufferedReader(file);
		String line=filereader.readLine();
		while(line!=null){
			String[] items=line.split(",");
			if(items[0].contains(venue) ){
				System.out.println(venue);
				System.out.println(items[0]);
				pitchscore=Double.parseDouble(items[1]);
				break;
			}
			line=filereader.readLine();
		}
		filereader.close();
		if(pitchscore==0){
			pitchscore=7;
		}
		return pitchscore;
}



private double GetscaledHI(double diffrunrate,ArrayList<Integer> BowlingScores) {
		// TODO Auto-generated method stub
	int bts=0;

	for(int i=0;i<BowlingScores.size();i++){
		bts+=BowlingScores.get(i);
	}
	double[] diffrunratefuzzified=diffrr.fuzzify(diffrunrate);
	double[] btsfuzzified=BTS.fuzzify(bts);
	System.out.println("diffrunratefuzzified: "+Arrays.toString(diffrunratefuzzified));
	System.out.println("btsfuzzified: "+Arrays.toString(btsfuzzified));
	f3.Applyrules(diffrunratefuzzified, btsfuzzified);
	double HealthIndex=f3.Averagedefuzzification();
//	double HealthIndex=f3.Maximadefuzzification();
	return HealthIndex;
}



private double GetHealthIndex2(int overs,
			int WicketLost, double diffrr) {
				
		// TODO Auto-generated method stub
	System.out.println("difrr: "+diffrr+"oversremaining: "+overs+"wicketlost: "+WicketLost);
	double[] diffrrfuzzified=RPrr.fuzzify(diffrr);
	double[] overfuzzified=o.fuzzify(overs);
	double[] WLfuzzified=WL.fuzzify(WicketLost);
	System.out.println(Arrays.toString(overfuzzified));
	System.out.println(Arrays.toString(diffrrfuzzified));
	System.out.println(Arrays.toString(WLfuzzified));
	//May be Present Runrate should also be involved in prediction
	f4.Applyrules(overfuzzified,diffrrfuzzified,WLfuzzified);
	double HealthIndex2=f4.Averagedefuzzification();
	return HealthIndex2;
}




private double GetHealthIndex(ArrayList<String> Batting,
		ArrayList<Integer> Battingscores, int overs, ArrayList<String> Batsmangone) {
	// TODO Auto-generated method stub
	int rts=0;		//RTS
	
	//System.out.println(Battingscores);
	//System.out.println(Bowlingscores);
	int initialrts = 0;
	for(int i=0;i<Batting.size();i++){
		initialrts+=Battingscores.get(i);
	}
	double defaultrts=(initialrts/10);
	for(int i=0;i<Batting.size();i++){
		if(Batsmangone.contains(Batting.get(i))){
			if(Battingscores.get(i)==1){
				rts+=defaultrts;
			}
			else{
				rts+=Battingscores.get(i);
			}
		}
	}
	double percentagediff=(double)(rts)*(double)100/(double)initialrts;
	double[] WSfuzzified=WS.fuzzify(percentagediff);
	double[] overfuzzified=o.fuzzify(overs);
	System.out.println("WS: "+rts+"initial rts: "+initialrts);
	System.out.println(Arrays.toString(overfuzzified));
	System.out.println(Arrays.toString(WSfuzzified));
	//May be Present Runrate should also be involved in prediction
	f.Applyrules(overfuzzified,WSfuzzified);
	double deltaHI=f.Averagedefuzzification();
	return deltaHI;
}

	private void Getallplayers(String matchname,ArrayList<String> team1, ArrayList<String> team2, ArrayList<Integer> team1Battingscores,
			ArrayList<Integer> team2Battingscores, ArrayList<Integer> team1Bowlingscores, ArrayList<Integer> team2Bowlingscores) throws IOException {
		// TODO Auto-generated method stub
		FileReader file=new FileReader(matchname);
		BufferedReader filereader=new BufferedReader(file);
		String line;
		line=filereader.readLine();
		line=filereader.readLine();
		String items[]=line.split("-");
		int year=Integer.parseInt(items[0]);
		int month=Integer.parseInt(items[1]);
		
		/*
		if(year<2013){
			BREAK=1;
			return;
		}
		*/
		for(int i=0;i<2;i++){
			line=filereader.readLine();
		}
		line=filereader.readLine();
		line=filereader.readLine();
		team1shortname=null;
		team2shortname=null;
		
		//3 line ignore
		line=filereader.readLine();
		line=filereader.readLine();
		line=filereader.readLine();
		team1name=line;
		line=filereader.readLine();
		int runs;
		Actualteam1runs=0;
		while(line!=null){
			if(line.equals("2nd innings")){
				break;
			}
			runs=Integer.parseInt(line);
			Actualteam1runs+=runs;
			
			line=filereader.readLine();//bowler
			if(!team2.contains(line)){
				team2.add(line);		//adding bowlers to team2
			}
			line=filereader.readLine();//wickets
			int wickets=Integer.parseInt(line);
			if(wickets!=0){
				for(int i=0;i<wickets;i++){
					line=filereader.readLine();
					team1.add(line);	//team1 batsman
				}
			}
			line=filereader.readLine();
		}
		line=filereader.readLine();
		team2name=line;
		line=filereader.readLine();
		Actualteam2runs=0;
		while(line!=null){
			if(line.equals("2nd innings")){
				break;
			}
			runs=Integer.parseInt(line);
			Actualteam2runs+=runs;
			
			line=filereader.readLine();//bowler
			if(!team1.contains(line)){
				team1.add(line);		//adding bowler to team1
			}
			line=filereader.readLine();//wickets
			int wickets=Integer.parseInt(line);
			if(wickets!=0){
				for(int i=0;i<wickets;i++){
					line=filereader.readLine();
					if(!team2.contains(line)){
						team2.add(line);	//team2 batsman
					}
				}
			}
			line=filereader.readLine();
			
		}

		//Got all team players present in the file.
		//getting corresponding team shortnames;
		FileReader file2=new FileReader("Files/Preprocess/CountryShortNames");
		BufferedReader filereader2=new BufferedReader(file2);
		String line2=filereader2.readLine();
		while(line2!=null){
			items=line2.split("-");
			if(team1name.equals(items[0])){
				team1shortname=items[1];
			}
			else if(team2name.equals(items[0])){
				team2shortname=items[1];
			}
			if(team1shortname!=null && team2shortname!=null){
				break;
			}
			line2=filereader2.readLine();
		}	
		filereader2.close();
		if(team1shortname==null || team2shortname==null){
			BREAK=1;return;
		}
		//Now getting their ranks
		String monthname="";
		if(month>6){
			monthname="October";
		}
		else{
			monthname="April";
		}
		file=new FileReader("Files/Preprocess/"+monthname+"_"+year+"_Batting_Preprocess");
		filereader=new BufferedReader(file);
		line=filereader.readLine();
		for(int i=0;i<11;i++){
			team1Battingscores.add(1);
			team2Battingscores.add(1);
			team1Bowlingscores.add(1);
			team2Bowlingscores.add(1);
		}
		while(line!=null){
			
			items=line.split(",");
			if(team1shortname!=null){
				if(team1shortname.equals(items[2])){
		//			System.out.println(line);
					
					int index=team1.indexOf(items[1]);
					if(index!=-1){
						team1Battingscores.set(index,Integer.parseInt(items[0]));
					}
					else{
						if(team1.size()<11){
							team1.add(items[1]);
							index=team1.indexOf(items[1]);
							team1Battingscores.set(index, Integer.parseInt(items[0]));
						}
					}
				}
			}
			if(team2shortname!=null){ 
				if(team2shortname.equals(items[2])){
	//			System.out.println(line);
				
					int index=team2.indexOf(items[1]);
					if(index!=-1){
						team2Battingscores.set(index,Integer.parseInt(items[0]));
					}
					else{
						if(team2.size()<11){
							team2.add(items[1]);
							index=team2.indexOf(items[1]);
							team2Battingscores.set(index, Integer.parseInt(items[0]));
						}
						
					}
				}
			}
			line=filereader.readLine();
		}
		file=new FileReader("Files/Preprocess/"+monthname+"_"+year+"_Bowling_Preprocess");
		filereader=new BufferedReader(file);
		line=filereader.readLine();
		while(line!=null){
			items=line.split(",");
			if(team1shortname!=null){
				
				if(team1shortname.equals(items[2])){
					int index=team1.indexOf(items[1]);
					if(index!=-1){
						team1Bowlingscores.set(index,Integer.parseInt(items[0]));
					}
					else{
						if(team1.size()<11){
							team1.add(items[1]);
							index=team1.indexOf(items[1]);
							team1Bowlingscores.set(index, Integer.parseInt(items[0]));
						}
					}
				}
			}
			if(team2shortname!=null){ 
				if(team2shortname.equals(items[2])){
					int index=team2.indexOf(items[1]);
					if(index!=-1){
						team2Bowlingscores.set(index,Integer.parseInt(items[0]));
					}
					else{
						if(team2.size()<11){
							team2.add(items[1]);
							index=team2.indexOf(items[1]);
							team2Bowlingscores.set(index, Integer.parseInt(items[0]));
						}
					}
				}
			}
			line=filereader.readLine();
		}
		
		if(team1.size()<11)		//still did't get all 11 players
		{
			int len=team1.size();
			for(int i=len;i<11;i++){
				team1.add("team1"+Integer.toString(i)+"thplayer");
			}
		}
		
		if(team2.size()<11)		//still did't get all 11 players
		{
			int len=team2.size();
			for(int i=len;i<11;i++){
				team2.add("team2"+Integer.toString(i)+"thplayer");
			}
		}
		System.out.println(monthname+"_"+year);
		System.out.println(team1shortname+" "+team2shortname);
		
		System.out.println("ActualTeam1runs:"+Actualteam1runs+" Actualteam2runs:"+Actualteam2runs);
		System.out.println(team1);
		System.out.println(team2);
	}
	
	private double GetScalingFactor(String venue) throws IOException {
		// TODO Auto-generated method stub
		FileReader file=new FileReader("Files/Preprocess/Pitchaveragescores");
		BufferedReader filereader=new BufferedReader(file);
		String line=filereader.readLine();
		double scalingfactor=1;
		while(line!=null){
			String[] items=line.split("-");
			if(items[0].equals(venue)){
				scalingfactor=Double.parseDouble(items[1])/7.02;
				if(scalingfactor!=1)
					scalingfactor*=1.22;
				break;
			}
			line=filereader.readLine();
		}
		return scalingfactor;
	}
	/*
	private double getRangeAverage(String team1name) {
		// TODO Auto-generated method stub
		FileReader file=new FileReader("");
		BufferedReader filereader=new BufferedReader(file);
		String line=filereader.readLine();
		return 0;
	}
*/
	
	public static void main(String[] args) throws IOException{
		MatchProcessing2 match=new MatchProcessing2();
		
		/*
		File folder=new File("dubai");
		File[] files=folder.listFiles();
		for(int filenum=0;filenum<files.length;filenum++){
			System.out.println(files[filenum].getPath());
			match.ProcessMatch(files[filenum].getPath());
		}
		*/
//		match.ProcessMatch("951325.txt");
//		match.ProcessMatch("nwc/682917.txt");
//		match.ProcessMatch("nwc/636537.txt");
//		match.ProcessMatch("nwc/685727.txt");
		match.ProcessMatch("nwc/682921.txt");
		match.runFsg("python Files/plot.py","dump.txt");
		match.runFsg("python Files/plot2.py","dump.txt");
		match.runFsg("python Files/plot3.py","dump.txt");
	}
	
	public void runFsg(String command, String outfile) throws IOException {

		Process process = Runtime.getRuntime().exec(command);
		String line;
		BufferedReader input = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		PrintWriter fsgActive = new PrintWriter(outfile);
		while ((line = input.readLine()) != null) {
			// System.out.println(line);
			fsgActive.println(line);
		}
		fsgActive.close();
	}
}
