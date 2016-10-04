package learn;

public class LogsBean implements Comparable<LogsBean>{
	private String strDate;
	private String threadId;
	private String logStatus;
	//private String className;
	//private String methodName;
	public String getStrDate() {
		return strDate;
	}
	public LogsBean(String strDate, String threadId, String logStatus) {
		super();
		this.strDate = strDate;
		this.threadId = threadId;
		this.logStatus = logStatus;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getThreadId() {
		return threadId;
	}
	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	public String getLogStatus() {
		return logStatus;
	}
	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}
/*	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((threadId == null) ? 0 : threadId.hashCode());
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
		LogsBean other = (LogsBean) obj;
		if (threadId == null) {
			if (other.threadId != null)
				return false;
		} else if (!threadId.equals(other.threadId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return threadId+" "+strDate+" "+logStatus;
	}
	
	public Boolean contains(String str){
		return this.toString().contains(str);
	}
	public int compareTo(LogsBean other) {
		int number = Integer.parseInt(this.threadId.substring(2).trim());
		int number2 = Integer.parseInt(other.threadId.substring(2).trim());
		return number-number2;
		
 
	}	
	
}
