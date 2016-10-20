package verifone;

//import com.verifone.isd.viper.eps.sys.util.PanMasker;

public class DataMasking {

	public static void main(String[] args) {
		
		String data = "03\\03\\529148\\18\\305310254900072\\99\\910AEFB85D43EA17A6F23030";
		String maskedData = maskHostResponseArea(data);
		
		System.out.println("maskeData : "+maskedData);
	}
	
	public static String maskHostResponseArea(String sensitiveData){
		
		String [] arryData = sensitiveData.split("\\\\");
		String maskedData = "";
		if(arryData.length > 0){
			maskedData = arryData[0];
			for(int i=1 ; i< arryData.length ;i++){
				if(i%2!=0){
					maskedData = maskedData + "\\"+arryData[i];
				}else{
					//maskedData += PanMasker.mask(arryData[i]);
				}
			}
		}
		return maskedData;
	}
}
