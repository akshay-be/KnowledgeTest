package org.jstrava.akshay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jstrava.connector.JStravaV3;
import org.jstrava.entities.activity.Activity;
import org.jstrava.entities.athlete.Athlete;
import org.jstrava.entities.club.Club;

public class TestMainApplication {
	static String filename = "D:\\Sports_League\\VRun\\AppData\\activites.txt";
	
	public static void main(String[] args) {
	

		JStravaV3 strava= new JStravaV3("9c4967366aee0aff856fd0c34c9c307ebeb2b18c");
			
		List<String> listActivityID= new ArrayList<String>();
		List<String> oldActivityIDs= loadActivityFromFile();
		
		System.out.println("Size : "+oldActivityIDs.size()+" Content : "+oldActivityIDs);
		List<Activity> listActivity= new ArrayList<Activity>();
		
		for(int i=1;i<30;i++){
			List<Activity> listActivity1= strava.findClubActivities(185777,i,10);
			listActivity.addAll(listActivity1);
			if(listActivity1.size()==0){
				break;
			}
		}
		System.out.println(listActivity.size());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String challengeStartSting = "2016-04-10";
		String challengeFinishDate = "2016-04-21";
		Date challegeStrat=null;
		Date challegeFinish=null;
		try {
			challegeStrat = formatter.parse(challengeStartSting);
			challegeFinish=formatter.parse(challengeFinishDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		//2016-04-12T04
		
		
		for (Activity activity : listActivity) {
			try {
				float distance = activity.getDistance();
				int activityId = activity.getId();
				String firstName = activity.getAthlete().getFirstname();
				String LastName = activity.getAthlete().getLastname();
				String name = firstName+" "+LastName;
				String start_date = activity.getStart_date();
				start_date = start_date.substring(0,start_date.indexOf("T"));
				Date date = formatter.parse(start_date);
				
				if(date.after(challegeStrat) && date.before(challegeFinish) && distance>1500 && !oldActivityIDs.contains(""+activityId)){
					System.out.println(activityId+", " + name + ", "+ start_date + ", " + distance/1000);
					listActivityID.add(""+activityId);
					activity.setHas_kudoed(true);
				}
				
			} catch (ParseException e) {
				System.out.println("Problem in this activity : ");
			}
		}
		
		oldActivityIDs.addAll(listActivityID);
		updateActivityToFile(oldActivityIDs);
		
		System.out.println("I am done..");
		
	}
	
	static List<String> loadActivityFromFile() {
		List<String> listActivityID= new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(new File(filename));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				listActivityID.add(line.trim());
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listActivityID;
	}
	
	static void updateActivityToFile(List<String> listActivityID){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			for (String activity : listActivityID) {
				out.write(activity+"\n");
			}
			out.close();
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}
}
