package learn;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FilterRequired {
	
	//public static String location="D:\\NBS\\Logs\\Beta_site\\2194\\April 10th 2014\\Master card Fleet\\rebel2194\\";
	public static String location="C:\\Users\\akshay\\Desktop\\rebel2194viper\\";
	//public static String location="C:\\Documents and Settings\\t_AkshayB1\\Desktop\\Betasite\\26th_Feb\\viper\\";
	public static String fileName = location+"messages";
	public static String filterdFileName=location+"FilteredSelectedReponseMessages.txt";
	public static String numberthteadname=location+"FilteredSelectedNumber.txt";
	public static String timeDiference=location+"TimeDiferenceStartEndMessages.txt";
	public static String xlsx=location+"TimeDataAllMessages.xlsx";
	
	//public static  String MACAddress="00:02:6B:0B:B8:86"; // Akshay system
	//public static  String MACAddress="00:02:6B:0D:67:A4"; //Satish System
  	//public static  String MACAddress="00:02:6B:0D:1D:E7"; //Beta Site 2173 System
	public static  String MACAddress="00:02:6B:11:87:58";   //Beta Site 2194 System
  	//public static  String MACAddress="00:02:6B:0B:E4:CC"; // Raj
	//public static  String MACAddress="00:02:6B:0A:8D:D1"; //Poornima system
	//public static  String MACAddress="00:02:6B:0B:94:6B"; //Poornima system2
	//public static  String MACAddress="00:02:6B:09:DB:B0"; // Chaitra System
	
	public static void main(String [] args) {
    	//filterRequired();
		System.out.println("Strat");
    	filterRequiredAndSort();
    	System.out.println("Mid");
        timeDiference(0);
        System.out.println("END"); 
		timeTransaction();
    }
    
    public static void filterRequired()
    {
    	// The name of the file to open.
        
        File file = new File(numberthteadname);
       
        // This will reference one line at a time
        String line = null;

        try {
        	
        	 if (!file.exists()) {
     			file.createNewFile();
     		}
        	FileWriter fw = new FileWriter(file.getAbsoluteFile());
 			BufferedWriter bw = new BufferedWriter(fw);

            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);
           

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
           
            while((line = bufferedReader.readLine()) != null) 
            { //
                  if(line.contains("CommunicationsUtil    [GROUP:main, THREAD:Name=CHANNEL-com.verifone.isd.viper.eps.communications.channel.helpers.MessageQueueMgr")
  )
            	{	
	              		System.out.println("line :: "+line+"\n Index : "+line.indexOf("MessageQueueMgr")+" last :"+line.indexOf(",id="));
                	  	bw.write(line.substring(line.indexOf("MessageQueueMgr")+16,line.indexOf(",id="))+"\n");
	               		bw.flush();
	             }     
            }	
            
            bufferedReader.close();	
            bw.close();
            System.out.println("Done boss");
            // Always close files.
            		
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    public static void filterRequiredAndSort()
    {
    	// The name of the file to open.
        //String fileName = "C:\\Documents and Settings\\t_AkshayB1\\Desktop\\streetest_log_fix\\Jan21\\2ndTry\\after\\messages.1";
        
        File file = new File(filterdFileName);
       
        ArrayList<LogsBean> sorted = new ArrayList<LogsBean>();
        ArrayList<String> filtredThreadId = new ArrayList<String>();
        ArrayList<String> availThreadId = new ArrayList<String>();
        // This will reference one line at a time
        String line = null;

        try {
        	
        	 if (!file.exists()) {
     			file.createNewFile();
     		}
        	FileWriter fw = new FileWriter(file.getAbsoluteFile());
 			BufferedWriter bw = new BufferedWriter(fw);

            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);
           

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            /*	|| line.contains("INFO   NBSMessage            Request Packet :")
    		|| line.contains("INFO   NBSParser             Response Packet :")
    		|| line.contains("INFO   Workstation          CHECKPOINT (runreceipt in)")
    		|| line.contains("INFO   NBSQueueProcessor     [Got response")
    		|| line.contains("NBSIPConnectionImpl  Got acknowledgement for "*/
    		//	|| line.contains("INFO   CommunicationsUtil    [GROUP:main")
          
            while((line = bufferedReader.readLine()) != null) 
            { //
                  if(line.contains("INFO   FEPImpl              FEPImpl.process()ENTER") 
            		|| line.contains("INFO   FEPImpl              FEPImpl.process()EXIT")           	
                     )
            	{	
	              		//System.out.println("line :: "+line);
                	  	//String MACAddress="00:02:6B:0B:B8:86"; // Akshay system
	              		//String MACAddress="00:02:6B:0D:67:A4"; //Satish System
                	  	//String MACAddress="00:02:6B:0D:1D:E7"; //Site System
	              		String strDate= line.substring(line.indexOf(" ")+1,line.indexOf("PMC"));
	              		String threadId= line.substring(line.indexOf("PMC")+4, line.indexOf(MACAddress));
	              		availThreadId.add(threadId.trim());
	              		String logStatus=line.substring(line.indexOf(MACAddress)+17);
	              		//System.out.println(strDate+threadId+logStatus);
	              		LogsBean lb = new LogsBean(strDate, threadId, logStatus);
	              		sorted.add(lb);
	              		
	             }     
            }	
            
            Set<String> unique = new HashSet<String>(availThreadId);
			for (String key : unique) {
			   // System.out.println(key + ": " + Collections.frequency(availThreadId, key));
			   if(Collections.frequency(availThreadId, key)>=2 && Collections.frequency(availThreadId, key)<4)
				   filtredThreadId.add(key);
			   else
				   System.out.println("Check this thread frequency is other than 2 : "+key+" "+Collections.frequency(availThreadId, key));
			}
			System.out.println("Sorted size : "+availThreadId.size());
			System.out.println("Filtred size : "+filtredThreadId.size());
           
			Collections.sort(sorted);
            for(LogsBean temp : sorted )
            {
        	 //  System.out.println("Id "+temp.getThreadId());
            	if(filtredThreadId.contains(temp.getThreadId().trim())){
            		bw.write(temp+"\n");
            		bw.flush(); 
            	}
            }
            bufferedReader.close();	
            bw.close();
            // Always close files.
            		
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
    public static void timeDiference(int time){
    	FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd HH:mm:ss");
		//String priviousString="Dec 26 07:00:13";Dec	12	8:02:16
		ArrayList<String> threadIDList = new ArrayList<String>();
		File file = new File(timeDiference);
		FileWriter fw =null;
		BufferedWriter bw=null;
		ArrayList< String> completdata = new ArrayList<String>();
		
		try {
			fileReader = new FileReader(filterdFileName);
			bufferedReader = new BufferedReader(fileReader);
			System.out.println("Start ");
			if(file.exists())
				file.delete();
			 fw = new FileWriter(file.getAbsoluteFile());
			 bw = new BufferedWriter(fw);
			long count[]= new long[500];
			long timeout[]= new long[500];
			int crossCheck=0;
			 while ((line = bufferedReader.readLine()) != null) {
				completdata.add(line);
				String threadID1 = line.substring(0, line.indexOf(" "));
				
				String line2 = bufferedReader.readLine();
				completdata.add(line2);
				String threadID2 = line2.substring(0, line2.indexOf(" "));
				String priviousString = line2.substring(line.indexOf(" "),line.indexOf("INFO"));
				
				
				String parsed = line.substring(line2.indexOf(" "),line.indexOf("INFO"));
				
				
				//System.out.println(parsed.trim()+" : "+priviousString.trim());
				Date date1 = formatter.parse(parsed.trim());
				Date date2 = formatter.parse(priviousString.trim());
				
				String result = threadID1.trim()+" Thread Start "+parsed +" End "+priviousString+" Execution Time : "+((date2.getTime()-date1.getTime())/1000);
				//System.out.println(result);
				
				long a = (date2.getTime()-date1.getTime())/1000;
				if((date2.getTime()-date1.getTime())/1000>=time){
					System.out.println("Thread ID : "+threadID1);
					threadIDList.add(threadID1);
					bw.write(result+"\n");
					bw.flush();
					
					//System.out.println(result+" :: "+a);
					if(a<500&&a>=0)
						count[(int)a]++;
				}
				
				if(!threadID1.trim().equals(threadID2.trim())){
					System.out.println(threadID1.trim()+":"+threadID2.trim());
					System.out.println("Program is ging worng data");
					break;
				}else{
					 FileReader fileReaderCLN =  new FileReader(fileName);
					 String completeLine=null;
					 BufferedReader bufferedReaderCLN =  new BufferedReader(fileReaderCLN);
					 int i=0;
					 //bw.write("\n SwipeAhead re-started threads \n");
					 //bw.flush();
					 while((completeLine = bufferedReaderCLN.readLine()) != null) 
			         {
						// System.out.println("111 "+completeLine+"threadID1 "+threadID1);
						if((completeLine.contains("Timeout error waiting for response on message with")) && completeLine.contains(threadID1)) {
							//try{
								//System.out.println(completeLine); 
								//System.out.println(threadID1);
								String threadId= completeLine.substring(completeLine.indexOf("PMC")+3, completeLine.indexOf(MACAddress));
								if(threadID1.trim().equalsIgnoreCase(threadId.trim())){
									//System.out.println("Line : "+completeLine);
									System.out.println("TimeOut : "+threadID1+"   a :"+a); 
									if(a<500&&a>=0){
										timeout[(int)a]++;
										bw.write("Timeout thread ID "+threadID1+"\n");
										bw.flush();
									}else{
										bw.write("Cross check  Timeout thread ID "+threadID1+"\n");
										bw.flush();
										crossCheck++;
									}
								}
							/*}
							catch(java.lang.StringIndexOutOfBoundsException e)
							{
								break;
							}*/
							
						 }
						if(completeLine.contains("AbstractCardAgent     CARD AGENT RESPONSE") && completeLine.contains(threadID1))
							break;
						
			         }
					 
					 bufferedReaderCLN.close();
					 fileReaderCLN.close();
					 //bw.write("\n Number of threads having SH : "+i);
				}
				
			}
			 bw.write("Time Number"+"\n");
			 bw.flush();
			 for(int i=0;i<count.length;i++){
				 if(count[i]!=0){
					 System.out.println(i+" "+count[i]);
					 bw.write("Time : "+i+" , Count "+count[i]+" , Timeout "+timeout[i]+"\n");
					 bw.flush();
				 }
			 }
			 bw.write("Cross check with logs threads : "+crossCheck+"\n");
			 bw.flush();
			bufferedReader.close();
			
			 bw.flush();
			 bw.close();
			 fw.close();
			 System.out.println("End of looping ");
		}catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		catch(ParseException p){
			p.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.out.println("End of File....!!");
			 try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

		
    }
    
    
    public static void timeTransaction(){
        
    	File file = new File(filterdFileName);
        ArrayList<LogsBean> sorted = new ArrayList<LogsBean>();
        ArrayList<String> availThreadId = new ArrayList<String>();
        String line = null;
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd HH:mm:ss");
        Map<Integer, TransactionBean> transactionMap = new TreeMap<Integer, TransactionBean>();
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sample sheet");
      
        try {
        		if (!file.exists()) {
        			file.createNewFile();
        		}
        	FileReader fileReader =  new FileReader(fileName);
           
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
           
           while((line = bufferedReader.readLine()) != null) 
            { //
                  if(line.contains("INFO   FEPImpl              FEPImpl.process()ENTER") 
            		|| line.contains("INFO   FEPImpl              FEPImpl.process()EXIT")           	
            		|| line.contains("INFO   Workstation          CHECKPOINT (runreceipt in)")
            		|| line.contains("AbstractCardAgent     CARD AGENT REQUEST START")
            		|| line.contains("INFO   AbstractCardAgent     CARD AGENT RESPONSE")
            		|| (line.contains("NBSChannelManagerSen Sending request via") && !line.contains("SAF-THRE"))
            		|| (line.contains("Timeout error waiting for response on message with") && !line.contains("SAF-THRE"))
            		|| (line.contains("Switching to Channel") && !line.contains("SAF-THRE"))
                  )
            	{	
	              		String strDate= line.substring(line.indexOf(" ")+1,line.indexOf("PMC"));
	              		String threadId= line.substring(line.indexOf("PMC")+4, line.indexOf(MACAddress));
	              		System.out.println("line :"+line);
	              		System.out.println(threadId);
	              		Integer id = Integer.parseInt(threadId.substring(2).trim());
	              		availThreadId.add(threadId.trim());
	              		String logStatus=line.substring(line.indexOf(MACAddress)+17);
	              		//System.out.println(strDate+threadId+logStatus);
	              		LogsBean lb = new LogsBean(strDate, threadId, logStatus);
	              		sorted.add(lb);
	              		
	              		TransactionBean tb=null;
	              		if(transactionMap.containsKey(id))
	              			tb= transactionMap.get(id);
	              		else{
	              			tb= new TransactionBean();
	              			tb.setTreadID(threadId);
	              			tb.setID(Integer.parseInt(threadId.substring(2).trim()));
	              		}
	              		
	              		if(line.contains("INFO   FEPImpl              FEPImpl.process()ENTER"))
	              			tb.setFepImplEnter(strDate);
	              		else if(line.contains("INFO   FEPImpl              FEPImpl.process()EXIT"))
	              			tb.setFepImplExit(strDate);
	              		else if(line.contains("INFO   Workstation          CHECKPOINT (runreceipt in)"))
	              			tb.setRunreceiptIn(strDate);
	              		else if(line.contains("AbstractCardAgent     CARD AGENT REQUEST START"))
	              			tb.setCARDAGENTREQUEST(strDate);
	              		else if(line.contains("INFO   AbstractCardAgent     CARD AGENT RESPONSE"))
	              			tb.setCARDAGENTRESPONSE(strDate);
	              		else if(line.contains("Timeout error waiting for response on message with"))
	              			tb.setTimeOut("Yes");
	              		else if(line.contains("NBSChannelManagerSen Sending request via"))
	              			tb.setSendingChannel(tb.getSendingChannel()+1);
	              		else if(line.contains("Switching to Channel"))
	              			tb.setSwitchingChannel("Yes");
	              		
	              		transactionMap.put(id, tb);
            	}     
            }	
            
            int rownum = 0;
            long count[]= new long[500];
             for (Integer id : transactionMap.keySet()) {
            	 TransactionBean tb= transactionMap.get(id);
            	if(tb.getFepImplEnter()!=null && tb.getFepImplExit()!=null){         	
            	try{
            		Row row = sheet.createRow(rownum++);
            		Cell cell1 = row.createCell(0);
            		cell1.setCellValue(tb.getTreadID().trim());
            	
            		Date dateFepImplEnter = formatter.parse(tb.getFepImplEnter().trim());
					Date dateFepImplExit = formatter.parse(tb.getFepImplExit().trim());
					
            		Cell cell2 = row.createCell(1);
            		cell2.setCellValue(tb.getFepImplEnter().trim());
            		Cell cell3 = row.createCell(2);
            		cell3.setCellValue(tb.getFepImplExit().trim());
            		Cell cell4 = row.createCell(3);
            		long transTime = (dateFepImplExit.getTime()-dateFepImplEnter.getTime())/1000;
            		cell4.setCellValue(transTime);
            		
            		Cell cell5 = row.createCell(4);
            		Cell cell6 = row.createCell(5);
            		long transTimeTillPrint = 0;
	            	if(tb.getRunreceiptIn()!=null){
	            		Date dateRunreceiptIn = formatter.parse(tb.getRunreceiptIn());
	            		cell5.setCellValue((dateRunreceiptIn.getTime()-dateFepImplExit.getTime())/1000);
	            		transTimeTillPrint=transTime+((dateRunreceiptIn.getTime()-dateFepImplExit.getTime())/1000);
	            		cell6.setCellValue(transTimeTillPrint);
	            	}else{
	            		cell5.setCellValue("N/A");
	            		cell6.setCellValue(transTime);
	            	}
	            	
	            	
	            	//Date dateCARDAGENTREQUEST = formatter.parse(tb.getCARDAGENTREQUEST().trim());
            		//Date dateCARDAGENTRESPONSE = formatter.parse(tb.getCARDAGENTRESPONSE());
            		//cell6.setCellValue((dateCARDAGENTRESPONSE.getTime()-dateCARDAGENTREQUEST.getTime())/1000);
					
            		String result = tb.getTreadID().trim()+" Thread Start "+tb.getFepImplEnter() +" End "+tb.getFepImplExit()
					+" Execution Time : "+((dateFepImplExit.getTime()-dateFepImplEnter.getTime())/1000);
					
            		Cell cell7 = row.createCell(6);
            		cell7.setCellValue(tb.getTimeOut());
            		
            		Cell cell8 = row.createCell(7);
            		cell8.setCellValue(tb.getSendingChannel());
            		
            		Cell cell9 = row.createCell(8);
            		cell9.setCellValue(tb.getSwitchingChannel());
            		
            		System.out.println(result);
					 	}
	            	catch(ParseException p){
	        			p.printStackTrace();
	        		}
	            	}
            }
             
            
             FileOutputStream out = new FileOutputStream(new File(xlsx));
             workbook.write(out);
             out.close();
             System.out.println("Excel written successfully..");     
            bufferedReader.close();
            fileReader.close();
                                 		
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
           
        }
    }
}
