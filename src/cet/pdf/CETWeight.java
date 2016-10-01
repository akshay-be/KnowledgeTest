package cet.pdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CETWeight {
	
	public static ArrayList<String> collNames = new ArrayList<String>();
	
	public static Map<String,ArrayList<Integer>> mapData = new HashMap<String, ArrayList<Integer>>();
	
	public static Map<String,Double> mapDouble = new HashMap<String, Double>();
	
	public static Map<String,Double> mapDoubleFiltered = new HashMap<String, Double>();
	
	public static Map<String,String> mapCollegeCode = new HashMap<String, String>();
	
	public static Map<String,String> mapCollegeFullName = new HashMap<String, String>();
	
	static List<DataBean> list = new ArrayList<DataBean>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		System.out.println("Started");

		File file = new File("C:\\Users\\akshay\\Desktop\\cet\\final_allotted_engg_1.txt");
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file.getPath()));
			String line = null;
			String collegeName = null;
			String collegeCode=null;
			while ((line = br.readLine()) != null) {
				
				// System.out.println(""+line);
				 if (line != null && !line.trim().isEmpty()
						 && !line.contains("-------------") && !line.trim().startsWith("Sl") && !line.trim().startsWith("No")) {
					 //String[] lineElemetns = line.trim().split(" "); 
					 if(line.trim().startsWith("Coll Cd:")){
						 collegeName = line.substring(line.indexOf("Coll Name:")+12);
						 collegeCode = line.substring(line.indexOf("Coll Cd:")+8,line.indexOf("E")+5);
						// System.out.println(""+collegeCode.trim());
					 }else if(line.trim().length() > 90){
						 DataBean db = new DataBean();
						 //System.out.println(collegeName);
						 if(collegeName.contains(",")){
							 db.setCollegeName(collegeName.substring(0, collegeName.indexOf(",")));
						 }else{
							 db.setCollegeName(collegeName);
						 }
						 
						 mapCollegeCode.put(db.getCollegeName(), collegeCode);
						 mapCollegeFullName.put(db.getCollegeName(), collegeName);
						 db.setSlNo(Integer.parseInt(line.substring(0, 8).trim()));
						 db.setCetNo(line.substring(8, 15).trim());
						 db.setCandidateName(line.substring(15, 38).trim());
						 db.setCOURSE(line.substring(40, 57).trim());
						 db.setRank(line.substring(58, 67).trim());
						 db.addRank(line.substring(58, 67).trim());
						 db.setCategClaim(line.substring(68, 73).trim());
						 db.setCategAllot(line.substring(74, 79).trim());
						 db.setCourseFees(line.substring(79, 91).trim());
						 list.add(db);
					 }
				 }// end of if
			}// end of while
			
			for (DataBean dataBean : list) {
				//if(dataBean.getCOURSE().trim().equals("Mechanical")){
				if(dataBean.getCOURSE().trim().equals("Civil")){
				//if(dataBean.getCOURSE().trim().equals("Info.Science") || dataBean.getCOURSE().trim().equals("Computers")){
					if(( dataBean.getCategClaim().contains("GM") || dataBean.getCategClaim().contains("3B") 
									|| dataBean.getCategAllot().contains("GM") || dataBean.getCategAllot().contains("3B")  ) ){
						if(!dataBean.getCategAllot().contains("PH") && !dataBean.getCategAllot().contains("NCC")){
							//if(collNames.contains(dataBean.getCollegeName())){
							//System.out.println(dataBean.getCollegeName());
							String key = dataBean.getCollegeName();
							ArrayList<Integer> list = new ArrayList<Integer>();
							if(mapData.containsKey(key)){
								list = mapData.get(key);
							}
							list.add(Integer.parseInt(dataBean.getRank()));
							mapData.put(key, list);
						//}
						}
						
					}
				}
			}
			
						
			Iterator<Entry<String, ArrayList<Integer>>> iterator = mapData.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String, ArrayList<Integer>> entry= iterator.next();
				ArrayList<Integer> value = entry.getValue();
				long sum = 0;
				for (Integer string : value) {
					sum += string;
				}
				double weight = sum/value.size();
				
				mapDouble.put(entry.getKey(), weight);
				//System.out.println(entry.getKey()+" weight : "+weight);
			}
			
			
	        
	        
	        Iterator<Entry<String, ArrayList<Integer>>> iterator1 = mapData.entrySet().iterator();
			while(iterator1.hasNext()){
				Entry<String, ArrayList<Integer>> entry= iterator1.next();
				ArrayList<Integer> value = entry.getValue();
				Integer minRank = Collections.min(value);
				Integer maxRank = Collections.max(value);
				//Bangalore
				if(mapCollegeFullName.get(entry.getKey()).contains("Bangalore") && (minRank>50000 || maxRank > 50000)){
					//System.out.println(mapCollegeCode.get(entry.getKey())+", "+mapCollegeFullName.get(entry.getKey())+" weight : "+mapDouble.get(entry.getKey()));
					
					mapDoubleFiltered.put(entry.getKey(), mapDouble.get(entry.getKey()));
				}
			}
			
			List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(mapDoubleFiltered.entrySet());
	        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
	            public int compare(Map.Entry<String, Double> o1,
	                    Map.Entry<String, Double> o2) {
	                return o1.getValue().compareTo(o2.getValue());
	            }
	        });
	        
	        System.out.println("Final....");
	        for (Entry<String, Double> entry : list) {
	        	System.out.println(mapCollegeCode.get(entry.getKey())+", "+mapCollegeFullName.get(entry.getKey())+" weight : "+entry.getValue()+" ,Rank : "+mapData.get(entry.getKey()));
	        }
	        
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finished");
	}
	
	
	
	
	
	
	
	
	
	
	
	static{
		collNames.add("Rajarajeswari College of Engineering"); 
		collNames.add("ACS College of Engineering "); 
		collNames.add("Brindavan College of Engineering"); 
		collNames.add("K N S Institute of Technology"); 
		collNames.add("Rajiv Gandhi Institute of Technology"); 
		collNames.add("T.John Engineering College"); 
		collNames.add("S E A College of Engineering and Technology"); 
		collNames.add("Presidency University"); 
		collNames.add("Islamia Institute of Technology"); 
		collNames.add("Vivekananada Institute of Technology"); 
		collNames.add("East Point College of Engineering and Technology"); 
		collNames.add("Yellamma Dasappa Institute of Technology"); 
		collNames.add("Sambhram Institute of Technology"); 
		collNames.add("Gopalan College of Engineering and Management"); 
		collNames.add("City Engineering College"); 
		collNames.add("East West Institute of Technology"); 
		collNames.add("B T L Institute of Technology and Management"); 
		collNames.add("AMC Engineering College"); 
		collNames.add("Cambridge Institutute of Technology"); 
		collNames.add("H.K.B.K.College of Engineering"); 
		collNames.add("Bangalore College of Engineering and Technology"); 
		collNames.add("APS College of Engineering"); 
		collNames.add("Alpha College Engineering"); 
		collNames.add("Sri Venkateshwara College of Engineering"); 
		collNames.add("K S Institute of Technology"); 
		collNames.add("Nagarjuna College of Engineering and Technology"); 
		collNames.add("Atria Institute of Technology"); 
		collNames.add("Dayananda Sagar University"); 
		collNames.add("Sri Sairam College of Engineering(Formerly Shirdi Sai Engg)"); 
		collNames.add("K.S. School of Engineering And Management"); 
		collNames.add("East West College of Engineering"); 
		collNames.add("M S Engineering College"); 
		collNames.add("R.R.Institute of Technology"); 
		collNames.add("Sri Krishna Institute of Technology"); 
		collNames.add("Vemana Institute of Technology"); 
		collNames.add("Impact College of Engineering and Applied Sciences"); 
		collNames.add("Sri Revana Siddeswara Institute of Technology"); 
		collNames.add("Sambhram Institute of Technology"); 
		collNames.add("Jain University"); 
		collNames.add("Bangalore Technological  Institute"); 
		collNames.add("Alliance University"); 
		collNames.add("Adarsha Institute of Technology"); 
		collNames.add("Nandi Institute of Technology and Management Sciences"); 
		collNames.add("Jyothi Institute of Technology"); 
		collNames.add("Dr. Sri. Sri. Sri. Shivakumara Mahaswamyji College of Engineering"); 
		collNames.add("Sri Pillappa College of Engineering"); 
		collNames.add("New Horizon College of Engineering"); 
		collNames.add("Sri Vidya Vinayaka Institute of Technology"); 
		collNames.add("P N S Institute of Technology"); 
		collNames.add("Basava Academy of Engineering"); 

	}

	

}
