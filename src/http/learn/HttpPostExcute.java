package http.learn;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 
 * @author eshak01
 *
 */
public class HttpPostExcute {

   public static void main(String[] args) throws HttpException, IOException {
      PostMethod postMethodProxyRequest = new PostMethod("url");
      postMethodProxyRequest.setRequestHeader("ADMINS", "");
      postMethodProxyRequest.setRequestHeader("LOCALEID", "");
      //postMethodProxyRequest.setRequestEntity(new InputStreamRequestEntity(httpServletRequest.getInputStream()));
      postMethodProxyRequest.setRequestBody("");
      HttpClient httpClient = new HttpClient();
      int intProxyResponseCode = httpClient.executeMethod(postMethodProxyRequest);
      
      
      GetMethod getMethod = new GetMethod("http://localhost:2080/crypto-service/api/v1/is-active");
      getMethod.setRequestHeader("Transaction-Id", "12345678910");
      getMethod.setRequestHeader("Content-Type", "application/json");
      HttpClient httpClient1 = new HttpClient();
      int intProxyResponseCode1 = httpClient1.executeMethod(getMethod);
      System.out.println("intProxyResponseCode : "+intProxyResponseCode1);
   }
}
