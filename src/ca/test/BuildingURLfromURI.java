package ca.test;

public class BuildingURLfromURI {

   public static void main(String[] args) {
      String[] uri = { 
                        "sadasd=asdasd",
                        "action=tds2-admin-ui/indexNonSence.html",
                        "action=tds2-admin-ui/indexNonSence.html&bank=i18n/en_US&locale=en_US&loggedinlevel=2&auth=1",
                        "bank=i18n/en_US&locale=en_US&loggedinlevel=2&auth=1",
                      };
      
      for (String string : uri) {
         buildURLAfterMC(string);
      }

   }

   public static void buildURLAfterMC(String queryString) {
      String redirectURL = "";
      if (queryString.contains("action=")) {
         if (queryString.contains("&")) {
            redirectURL = queryString.substring(7 + queryString.indexOf("action="), queryString.indexOf("&"));
            redirectURL += "?" + queryString.substring(1 + queryString.indexOf("&"));
         } else {
            redirectURL = queryString.substring(7 + queryString.indexOf("action="));
         }
      } else {
         redirectURL = /*request.getContextPath() +*/ "/admin/message.jsp";
      }

      System.out.println("" + redirectURL);
      System.out.println("*******************************");
   }

}
