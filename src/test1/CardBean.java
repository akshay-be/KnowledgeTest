package test1;

public class CardBean {
	private String applicationLable;
	private String AID;
	private String applicationPAN;
	private int length;
	
	
	public CardBean(String applicationLable, String aID, String applicationPAN,int length) {
		super();
		this.applicationLable = applicationLable;
		this.AID = aID;
		this.applicationPAN = applicationPAN;
		this.length = length;
	}
	public CardBean()
	{
		
	}
	public String getApplicationLable() {
		return applicationLable;
	}
	public void setApplicationLable(String applicationLable) {
		this.applicationLable = applicationLable;
	}
	public String getAID() {
		return AID;
	}
	public void setAID(String aID) {
		AID = aID;
	}
	public String getApplicationPAN() {
		return applicationPAN;
	}
	public void setApplicationPAN(String applicationPAN) {
		this.applicationPAN = applicationPAN;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AID == null) ? 0 : AID.hashCode());
		result = prime
				* result
				+ ((applicationLable == null) ? 0 : applicationLable.hashCode());
		result = prime * result
				+ ((applicationPAN == null) ? 0 : applicationPAN.hashCode());
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
		CardBean other = (CardBean) obj;
		if (AID == null) {
			if (other.AID != null)
				return false;
		} else if (!AID.equals(other.AID))
			return false;
		if (applicationLable == null) {
			if (other.applicationLable != null)
				return false;
		} else if (!applicationLable.equals(other.applicationLable))
			return false;
		if (applicationPAN == null) {
			if (other.applicationPAN != null)
				return false;
		} else if (!applicationPAN.equals(other.applicationPAN))
			return false;
		return true;
	}
}
