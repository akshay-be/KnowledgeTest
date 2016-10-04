package cet.pdf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CETStudentTextFileRead {


	static long lowerCutOff = 50000;
	static long upperCutOff = 175000;
	
	static List<DataBean> list = new ArrayList<DataBean>();
	static Set<String> setData = new TreeSet<String>();
	
	static Map<String,DataBean> map = new HashMap<String,DataBean>();
	public static void main(String[] args) {

		System.out.println("Started");

		File file = new File("C:\\Users\\akshay\\Desktop\\cet\\final_allotted_engg_1.txt");
		
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file.getPath()));
			String line = null;
			String collegeName = null;
			while ((line = br.readLine()) != null) {
				
				// System.out.println(""+line);
				 if (line != null && !line.trim().isEmpty()
						 && !line.contains("-------------") && !line.trim().startsWith("Sl") && !line.trim().startsWith("No")) {
					 //String[] lineElemetns = line.trim().split(" "); 
					 if(line.trim().startsWith("Coll Cd:")){
						 collegeName = line.substring(line.indexOf("Coll Name:"));
						 //System.out.println(""+collegeName);
					 }else if(line.trim().length() > 90){
						 //line = line.trim();
						// System.out.println(line);
						 DataBean db = new DataBean();
						 db.setCollegeName(collegeName);
						 db.setSlNo(Integer.parseInt(line.substring(0, 8).trim()));
						 db.setCetNo(line.substring(8, 15).trim());
						 db.setCandidateName(line.substring(15, 38).trim());
						 db.setCOURSE(line.substring(40, 54).trim());
						 db.setRank(line.substring(55, 67).trim());
						 db.setCategClaim(line.substring(68, 73).trim());
						 db.setCategAllot(line.substring(74, 79).trim());
						 db.setCourseFees(line.substring(79, 91).trim());
						 list.add(db);
						 
//						 System.out.println(""+collegeName);
//						 System.out.println(db.getSlNo());
//						 System.out.println(db.getCetNo());
//						 System.out.println(db.getCandidateName());
//						 System.out.println(db.getCOURSE());
//						 System.out.println(db.getRank());
//						 System.out.println(db.getCategClaim());
//						 System.out.println(db.getCategAllot());
//						 System.out.println(db.getCourseFees());
//						 
//						 break;
						 
					 }
				 }
			}
			
			System.out.println("List Size :  "+list.size());
			for (DataBean dataBean : list) {
				//System.out.println(dataBean.getCOURSE());
				if(dataBean.getCOURSE().trim().equals("Info.Science") || dataBean.getCOURSE().trim().equals("Computers")){
					String strRank = dataBean.getRank();
					if(strRank.contains("G")){
						strRank = strRank.substring(0, strRank.indexOf("G"));
					}
					int rank = Integer.parseInt(strRank);
					if(rank > lowerCutOff && rank <upperCutOff &&
							( dataBean.getCategClaim().contains("GM") || dataBean.getCategClaim().contains("3B") 
									|| dataBean.getCategAllot().contains("GM") || dataBean.getCategAllot().contains("3B") ) ){
						//System.out.println("Bean : "+dataBean);
						setData.add(dataBean.getCollegeName());
						String collName = dataBean.getCollegeName();
						if(map.containsKey(collName)){
							DataBean db = map.get(collName);
							String strOldRank = db.getRank();
							if(strOldRank.contains("G")){
								strOldRank = strRank.substring(0, strOldRank.indexOf("G"));
							}
							int oldRank = Integer.parseInt(strRank);
							if (rank < oldRank) {
								map.put(collName, dataBean);
							}
						}else{
							map.put(collName, dataBean);
						}
					}
				}
				
			}
			
			System.out.println("College :");
			Set keys = map.keySet();
			for (Object object : keys) {
				System.out.println(object);
			}
			
		} catch (FileNotFoundException e) {
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


}
class DataBean{
	String collegeName;
	int slNo;
	String cetNo;
	String candidateName;
	String COURSE;
	String Rank;
	String CategClaim;
	String CategAllot;
	String CourseFees;
	public DataBean(int slNo, String cetNo, String candidateName,
			String cOURSE, String rank, String categClaim, String categAllot,
			String courseFees) {
		super();
		this.slNo = slNo;
		this.cetNo = cetNo;
		this.candidateName = candidateName;
		COURSE = cOURSE;
		Rank = rank;
		CategClaim = categClaim;
		CategAllot = categAllot;
		CourseFees = courseFees;
	}
	public DataBean() {
	}
	public int getSlNo() {
		return slNo;
	}
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}
	public String getCetNo() {
		return cetNo;
	}
	public void setCetNo(String cetNo) {
		this.cetNo = cetNo;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getCOURSE() {
		return COURSE;
	}
	public void setCOURSE(String cOURSE) {
		COURSE = cOURSE;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getCategClaim() {
		return CategClaim;
	}
	public void setCategClaim(String categClaim) {
		CategClaim = categClaim;
	}
	public String getCategAllot() {
		return CategAllot;
	}
	public void setCategAllot(String categAllot) {
		CategAllot = categAllot;
	}
	public String getCourseFees() {
		return CourseFees;
	}
	public void setCourseFees(String courseFees) {
		CourseFees = courseFees;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@Override
	public String toString() {
		return "DataBean [collegeName=" + collegeName + ", cetNo=" + cetNo
				+ ", candidateName=" + candidateName + ", COURSE=" + COURSE
				+ ", Rank=" + Rank + ", CategClaim=" + CategClaim
				+ ", CategAllot=" + CategAllot + ", CourseFees=" + CourseFees
				+ "]";
	}
}
