
public class TransactionBean implements Comparable<TransactionBean>{
	private int ID;
	private String treadID;
	private String fepImplEnter;
	private String fepImplExit;
	private String runreceiptIn;
	private String runreceiptOut;
	private String CARDAGENTREQUEST;
	private String CARDAGENTRESPONSE;
	private String TimeOut="No";
	private int sendingChannel=0;
	private String switchingChannel="No";
	
	@Override
	public String toString() {
		return treadID+" , "+fepImplEnter+" , "+fepImplExit+" , "+runreceiptIn+" , "+CARDAGENTREQUEST+" , "+CARDAGENTRESPONSE+" , ";
	}
	
	public int compareTo(TransactionBean other) {
		int number = Integer.parseInt(this.treadID.substring(2).trim());
		int number2 = Integer.parseInt(other.treadID.substring(2).trim());
		return number-number2;
	}	
	
	public String getSwitchingChannel() {
		return switchingChannel;
	}

	public void setSwitchingChannel(String switchingChannel) {
		this.switchingChannel = switchingChannel;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTimeOut() {
		return TimeOut;
	}

	public void setTimeOut(String timeOut) {
		TimeOut = timeOut;
	}

	public String getTreadID() {
		return treadID;
	}
	public void setTreadID(String treadID) {
		this.treadID = treadID;
	}
	public String getFepImplEnter() {
		return fepImplEnter;
	}
	public void setFepImplEnter(String fepImplEnter) {
		this.fepImplEnter = fepImplEnter;
	}
	public String getFepImplExit() {
		return fepImplExit;
	}
	public void setFepImplExit(String fepImplExit) {
		this.fepImplExit = fepImplExit;
	}
	public String getRunreceiptIn() {
		return runreceiptIn;
	}
	public void setRunreceiptIn(String runreceiptIn) {
		this.runreceiptIn = runreceiptIn;
	}
	public String getRunreceiptOut() {
		return runreceiptOut;
	}
	public void setRunreceiptOut(String runreceiptOut) {
		this.runreceiptOut = runreceiptOut;
	}
	public String getCARDAGENTREQUEST() {
		return CARDAGENTREQUEST;
	}
	public void setCARDAGENTREQUEST(String cARDAGENTREQUEST) {
		CARDAGENTREQUEST = cARDAGENTREQUEST;
	}
	public String getCARDAGENTRESPONSE() {
		return CARDAGENTRESPONSE;
	}
	public void setCARDAGENTRESPONSE(String cARDAGENTRESPONSE) {
		CARDAGENTRESPONSE = cARDAGENTRESPONSE;
	}

	public int getSendingChannel() {
		return sendingChannel;
	}

	public void setSendingChannel(int sendingChannel) {
		this.sendingChannel = sendingChannel;
	}
	
	
}
