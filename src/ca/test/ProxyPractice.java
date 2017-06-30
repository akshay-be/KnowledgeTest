package ca.test;

public class ProxyPractice {

	public static void main(String[] args) {
		String stringProxyURL = "http://localhost:1080";
		String uri = "/vpas/admin/tds2-admin-ui/rangeConfigTds.jsp";
		//String uri = "/vpas/admin/tds2-admin-service/api/tds2/admin/getBanks";
		//String uri = "/vpas/admin/tds2/tds2-admin-ui/ui/tds2-admin-ui/styles.bundle.css";
		if(uri.startsWith("/vpas/admin/tds2-admin")){
			stringProxyURL +=  uri.substring(6+uri.indexOf("/admin/"));
		}else{
			stringProxyURL +=  uri;
		}
		System.out.println("URI : "+uri);
		System.out.println("URL : "+stringProxyURL);
	}
}
