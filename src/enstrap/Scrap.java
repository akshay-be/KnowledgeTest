package enstrap;

import java.util.HashMap;
import java.util.Set;

public class Scrap {

	public static  HashMap<String, HashMap<String,String>> ReadStatus = new HashMap<String, HashMap<String,String>>();
	
	public static void main(String[] args) {
		
		//code to decide to make it read or not.
		
		String string = "MsgHdrGuid"; //providers.get("MsgHdrGuid")
		boolean read = true;
		if (ReadStatus.containsKey(string)) {
			HashMap<String, String> map = ReadStatus.get(string);
			if (map.isEmpty()) {
				read = false;
			} else {
				Set<String> keys = map.keySet();
				for (String string2 : keys) {
					String value = map.get(string2);
					if (value.equalsIgnoreCase("false")) {
						read = false;
					}
				}
			}

		}
		
		
		//code to update on click
		String stringMsgHdrGuid = "MsgHdrGuid"; //providers.get("MsgHdrGuid")
		if(ReadStatus.containsKey(stringMsgHdrGuid)){
			HashMap<String, String> map = ReadStatus.get(stringMsgHdrGuid);
			String innerKey = "innerKey"; //wch is on click key
			if(map.containsKey(innerKey)){
				map.put(innerKey, "true");
			}
			ReadStatus.put(stringMsgHdrGuid, map);
		}
	}
	
	void somemethod()
	{
		 //Cursor cursor3=db.rawQuery("select MsgHdrGuid,MsggUid from GET_ALLMESSAGES",null);
		// if(cursor3.moveToNext()) {
		 	String MsgHdrGuid = "";//cursor3.getString(0);
		 	String MsggUid = "";//cursor3.getString(1);
		 	if(!ReadStatus.containsKey(MsgHdrGuid)){
		 		ReadStatus.put(MsgHdrGuid, new HashMap<String, String>());
		 	}else{
		 		HashMap<String, String> hp = ReadStatus.get(MsgHdrGuid);
		 		if(!hp.containsKey(MsggUid)){
		 			hp.put(MsggUid, "false");
		 		}
		 	}
		 	
		// }
	}

}
