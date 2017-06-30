package mf.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompanyDetails {

	public static void main(String[] args) throws IOException {
	   Map<String,FundBean> map = new HashMap<String,FundBean>();
	   try(Stream<Path> paths = Files.walk(Paths.get("C:\\SeflData\\Account statements\\mf_funds_details"))) {
	      paths.forEach(filePath -> {
	          if (Files.isRegularFile(filePath)) {
	             String name = filePath.getFileName().toString().substring(0, filePath.getFileName().toString().indexOf("."));
	            // System.out.println(name);
	             List<String> list = new ArrayList<>();

	             try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath.toAbsolutePath().toUri()))) {
	                //br returns as stream and convert it into a List
	                list = br.lines().collect(Collectors.toList());

	             } catch (IOException e) {
	                e.printStackTrace();
	             }
	             
	             for (String string : list) {
                  String[] data = string.split("\\s+");
                  //System.out.println(data.length+" "+data[0]+" : "+data[data.length-1]);
                  String companyName = data[0] +" "+data[1];
                  FundBean bean = null;
                  if(map.containsKey(companyName)){
                     bean = map.get(companyName);
                  }else{
                     bean = new FundBean();
                     bean.companyName = companyName;
                  }
                  double percentage = Double.parseDouble(data[data.length-1]);
                  if(name.equals("Axis_Long_Term_Equity_Fund")){
                     bean. Axis_Long_Term_Equity_Fund = percentage;
                  }else if(name.equals("DSP_BlackRock_Micro_Cap_Fund")){
                     bean.DSP_BlackRock_Micro_Cap_Fund= percentage;
                  }else if(name.equals("DSP_BlackRock_Tax_Saver_Fund")){
                     bean.DSP_BlackRock_Tax_Saver_Fund= percentage;
                  }else if(name.equals("Franklin_India_Smaller_Companies_Fund")){
                     bean.Franklin_India_Smaller_Companies_Fund= percentage;
                  }else if(name.equals("HDFC_Long_Term_Advantage_Fund")){
                     bean.HDFC_Long_Term_Advantage_Fund= percentage;
                  }else if(name.equals("HDFC_Tax_Saver")){
                     bean.HDFC_Tax_Saver= percentage;
                  }else if(name.equals("ICICI_Prudential_Long_Term_Equity_Fund")){
                     bean.ICICI_Prudential_Long_Term_Equity_Fund= percentage;
                  }else if(name.equals("ICICI_Prudential_Top_100_Fund")){
                     bean.ICICI_Prudential_Top_100_Fund= percentage;
                  }else if(name.equals("ICICI_Prudential_Value_Discovery_Fund")){
                     bean.ICICI_Prudential_Value_Discovery_Fund= percentage;
                  }else if(name.equals("Reliance_Tax_Saver")){
                     bean.Reliance_Tax_Saver= percentage;
                  }else if(name.equals("SBI_Blue_Chip_Fund")){
                     bean.SBI_Blue_Chip_Fund= percentage;
                  }else if(name.equals("Tata_India_Tax_Savings_Fund")){
                     bean.Tata_India_Tax_Savings_Fund= percentage;
                  }
                  map.put(companyName, bean);
               }
	          }
	      });
	  } 
	   

	   Iterator<Map.Entry<String,FundBean>> it = map.entrySet().iterator();
	   
	   while (it.hasNext()) {
	        Map.Entry<String,FundBean> pair = it.next();
	        String key =  pair.getKey();
	        FundBean bean = pair.getValue();
	        System.out.println(bean);
	    }


	}

}

class FundBean {
	String companyName ;
	double Axis_Long_Term_Equity_Fund;
	double DSP_BlackRock_Micro_Cap_Fund;
	double DSP_BlackRock_Tax_Saver_Fund;
	double Franklin_India_Smaller_Companies_Fund;
	double HDFC_Long_Term_Advantage_Fund;
	double HDFC_Tax_Saver;
	double ICICI_Prudential_Long_Term_Equity_Fund;
	double ICICI_Prudential_Top_100_Fund;
	double ICICI_Prudential_Value_Discovery_Fund;
	double Reliance_Tax_Saver;
	double SBI_Blue_Chip_Fund;
	double Tata_India_Tax_Savings_Fund;
   @Override
   public String toString() {
      return "[" + companyName + ", Axis_Long_Term_Equity_Fund=" + Axis_Long_Term_Equity_Fund + ", DSP_BlackRock_Micro_Cap_Fund="
            + DSP_BlackRock_Micro_Cap_Fund + ", DSP_BlackRock_Tax_Saver_Fund=" + DSP_BlackRock_Tax_Saver_Fund + ", Franklin_India_Smaller_Companies_Fund="
            + Franklin_India_Smaller_Companies_Fund + ", HDFC_Long_Term_Advantage_Fund=" + HDFC_Long_Term_Advantage_Fund + ", HDFC_Tax_Saver=" + HDFC_Tax_Saver
            + ", ICICI_Prudential_Long_Term_Equity_Fund=" + ICICI_Prudential_Long_Term_Equity_Fund + ", ICICI_Prudential_Top_100_Fund="
            + ICICI_Prudential_Top_100_Fund + ", ICICI_Prudential_Value_Discovery_Fund=" + ICICI_Prudential_Value_Discovery_Fund + ", Reliance_Tax_Saver="
            + Reliance_Tax_Saver + ", SBI_Blue_Chip_Fund=" + SBI_Blue_Chip_Fund + ", Tata_India_Tax_Savings_Fund=" + Tata_India_Tax_Savings_Fund + "]";
   } 
	
}
