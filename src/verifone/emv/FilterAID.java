package verifone.emv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import test1.CardBean;


public class FilterAID {

	public static void main(String[] args) {
		File file = new File("D:\\EMV\\NTS\\trackData\\TrackDetails.txt");
		BufferedReader br=null;
		
		ArrayList<String> aidList = new ArrayList<String>();
		
		try {
			br = new BufferedReader(new FileReader(file.getPath()));
			String line =null;
			
			while ((line=br.readLine()) != null) {
				//System.out.println(""+line);
				String[] arrElemetns = line.split(";");
				String lable = arrElemetns[0];
				String aid = arrElemetns[2];
				String pan = arrElemetns[3];
				String length = arrElemetns[4];
				if(!aidList.contains(aid.trim())){
					aidList.add(aid.trim());
				}
				if(lable.contains("Debit") || lable.contains("DEBIT")){
					System.out.println("AID : "+ aid.trim());
				}
			}
			br.close();
			System.out.println("AID List : ");
			for (String aidBean : aidList) {
				System.out.println(""+aidBean);
			}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

class AIDBean {
	private String aidName;
	private String aid;
	
	
	public AIDBean(String aidName, String aid) {
		super();
		this.aidName = aidName;
		this.aid = aid;
	}

	public String getAidName() {
		return aidName;
	}
	
	public void setAidName(String aidName) {
		this.aidName = aidName;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
		result = prime * result + ((aidName == null) ? 0 : aidName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AIDBean other = (AIDBean) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		if (aidName == null) {
			if (other.aidName != null)
				return false;
		} else if (!aidName.equals(other.aidName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "" + aidName + " " + aid + "]";
	}
	
	
	
}
