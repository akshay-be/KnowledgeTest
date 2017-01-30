package ca.test;

public class ProxyPractice {

	public static void main(String[] args) {
		String stringProxyURL = "http://localhost:1080";
		//String uri = "/admin/tds2-admin-ui/rangeConfig.jsp";
		String uri = "/tds2-admin-service/rangeConfig.jsp";
		if(uri.startsWith("/admin/tds2-admin-ui/")){
			stringProxyURL +=  uri.substring(6+uri.indexOf("/admin/"));
		}else{
			stringProxyURL +=  uri;
		}
		
		System.out.println("URL : "+stringProxyURL);
	}
}
