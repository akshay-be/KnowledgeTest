package ca.test;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author eshak01
 *
 */
public class JsonParser {

   public static void main(String[] args) {
      
      /*{
         name: "affliate",
         descrption: "aaaaaaaaaaaaaaaaaaaaaaaaaaaa",
         apigroups: {
            affliate: {
               "name": "affliate",
               "apiListing": {
                  "food nutri": {
                     "avialabevaria": {
                        "v0.1.0": {
                           "resourceName": " food nutrition",
                           get : "http://localhost:8080/application"
                        }
                     }
                  }
               }
               
            }
         }
      }*/
      String jsonStr = "{\"name\": \"affliate\",\"apistring\": {\"food nutri\": {\"avialabevaria\": {\"v0.1.0\": {\"resourceName\": \" food nutrion \"} }  }  } }";
      try {
         JSONObject jsonObj = new JSONObject(jsonStr);
         JSONObject apistring = jsonObj.getJSONObject("apistring");
         JSONObject foodNutri = apistring.getJSONObject("food nutri");
         JSONObject avialabevaria = foodNutri.getJSONObject("avialabevaria");
         JSONObject resourceName = avialabevaria.getJSONObject("v0.1.0");
         String strName = resourceName.getString("resourceName");
         System.out.println(strName);
      } catch (JSONException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}


