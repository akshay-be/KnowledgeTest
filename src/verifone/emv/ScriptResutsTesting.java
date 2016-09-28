package verifone.emv;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ScriptResutsTesting {

	public static void main(String[] args) {
		
		List<byte[]> scriptResults = new ArrayList<byte[]>();
		scriptResults.add("0010000000".getBytes());
		scriptResults.add("0010000000".getBytes());
		scriptResults.add("0010000000".getBytes());
		scriptResults.add("0050000000".getBytes());
		scriptResults.add("0050000000".getBytes());
		scriptResults.add("0050000000".getBytes());
		scriptResults.add("0040000000".getBytes());
		scriptResults.add("1040000000".getBytes());
		scriptResults.add("1030000000".getBytes());
		
		
		
		
		Map<String, String> failureResultMap = new HashMap<String, String>();
		Map<String, String> notPerformedResultMap = new HashMap<String, String>();
		Map<String, String> successResultMap = new HashMap<String, String>();

		String finalScriptResult = "";
		for (byte[] bs : scriptResults) {
			String scriptResult = bytesToString(bs);
			if (scriptResult != null && scriptResult.length() == 10) {
				String result = scriptResult.substring(0, 2);
				String identifier = scriptResult.substring(2);
				//System.out.println(result);
				//System.out.println(identifier);
				if (result.substring(0, 1).equals("1")) {
					failureResultMap.put(identifier, result);
				} else if (result.substring(0, 1).equals("0")) {
					notPerformedResultMap.put(identifier, result);
				} else {
					successResultMap.put(identifier, result);
				}
			}
		}

		int count = 0;

		for (String identifier : failureResultMap.keySet()) {
			if (!finalScriptResult.contains(identifier)) {
				count++;
				finalScriptResult += failureResultMap.get(identifier) + identifier;
	
				if (count == 2) {
					break;
				}
			}
		}
		if (count != 2) {
			for (String identifier : notPerformedResultMap.keySet()) {
				if (!finalScriptResult.contains(identifier)) {
					count++;
					finalScriptResult += notPerformedResultMap.get(identifier)+ identifier;

					if (count == 2) {
						break;
					}
				}
			}
		}

		if (count != 2) {
			for (String identifier : successResultMap.keySet()) {
				if (!finalScriptResult.contains(identifier)) {
					count++;
					finalScriptResult += successResultMap.get(identifier)+ identifier;

					if (count == 2) {
						break;
					}
				}
			}
		}
		
		
		System.out.println(""+finalScriptResult);
	}
	
	
	public static String bytesToString(byte[] data){
		String convertedString=null; 
		try {
			if(data!=null){
				convertedString = new String(data, "UTF8");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException occured while parsing ");
		}
		return convertedString;
	}
	
	
	

	
	/*if (!resultMap.containsKey(identifier)) {
		resultMap.put(identifier, result);
	} else {
		String oldResult = resultMap.get(identifier);
		if(oldResult.equals(result)){
			continue;
		}else if(result.substring(0, 1).equals("1")){
			resultMap.put(identifier, result);
		}else if(!oldResult.substring(0, 1).equals("1") && result.substring(0, 1).equals("0")){
			resultMap.put(identifier, result);
		}
	}*/
}
