package ca.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolSizeTest {

   public static void main(String[] args) {
      HashMap<String, String> dec3Dessw =  new HashMap<String, String>();
      for(int i=0;i<20;i++){
         dec3Dessw.put("K"+i, "V"+i);
      }
      int threadPoolSize = 5;
      Iterator<Entry<String, String>> it = dec3Dessw.entrySet().iterator();
      ExecutorService taskExecutor = Executors.newFixedThreadPool(25);
      List<Callable<String>> tasks = new ArrayList<>();
      while (it.hasNext()) {
         System.out.println("Main while : ");

         Map.Entry<String, String> pair1 = it.next();
         tasks.add(new BrokenTasksEncrypt(pair1.getKey(), pair1.getValue()));

      }
         try {
            long start = System.nanoTime();
            taskExecutor.invokeAll(tasks);
            long end = System.nanoTime();
            System.out.println("Time : "+(end-start));
         } catch (InterruptedException e) {
            //logger.logError("InterruptedException in processing threads for encrypt request.");
         }
         tasks.clear();    
      
      taskExecutor.shutdown();
   }

}
class BrokenTasksEncrypt implements Callable<String>  {
   String key;
   int value;
   public BrokenTasksEncrypt(String key, String value) {
     this.key =key;
   }

   @Override
   public String call() throws Exception {
      for (int i = 0; i <100000000; i++) {
         value = i;
        // System.out.println(key+" : thread"+Thread.currentThread().getName());
      }
      
      for (int i = 0; i <100000000; i++) {
         value = i;
        // System.out.println(key+" : thread"+Thread.currentThread().getName());
      }
      
      return "Done";
   }
   
}
