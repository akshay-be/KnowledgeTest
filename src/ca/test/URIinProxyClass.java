package ca.test;

public class URIinProxyClass {

   public static void main(String[] args) {
      String[] uri = { "/vpas/admin/tds2/tds2-admin-ui/index.html", 
                        "/vpas/admin/tds2-admin-ui/index.html",
                        "/vpas/admin/tds2-admin-ui/tds2-admin-service/api/tds2/admin/v1/SystemConfig/getParamGroups",
                        "/vpas/admin/tds2/tds2-admin-ui/tds2-admin-service/api/tds2/admin/v1/SystemConfig/getParamGroups",
                        "/vpas/admin/tds2/tds2-admin-ui/ui/tds2-admin-ui/styles.bundle.css"};
      for (String string : uri) {
         changeURI(string);
      }

   }
   
   public static void changeURI(String uri){
      System.out.println("I/P : "+uri);
      String newURI;
      // Add URI
      if (uri.contains("/tds2-admin-service/")) {
         //http://localhost:7080/vpas/admin/tds2-admin-ui/tds2-admin-service/api/tds2/admin/v1/SystemConfig/getParamGroups 
         newURI = uri.substring(uri.indexOf("/tds2-admin-service/"));
      }else if(uri.contains("/admin/tds2/tds2-admin-ui/ui/tds2-admin-ui/")){
         newURI = uri.substring(uri.lastIndexOf("/tds2-admin-ui/"));
      }else if (uri.contains("/admin/tds2/")){
         newURI = uri.substring(11 + uri.indexOf("/admin/tds2/"));
      }else{
         newURI = uri.substring(6 + uri.indexOf("/admin/"));
      }
      System.out.println("O/P : "+newURI);
      System.out.println("*******************************");
   }
}
