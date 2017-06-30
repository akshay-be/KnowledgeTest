package com.learn.inheitance;

/**
 * 
 * @author eshak01
 *
 */
public class InheritanceChallenge {
   static class GoldSaint {
      static{
         System.out.println("GoldSaint - static block.");
      }
      public GoldSaint(){
         System.out.println("GoldSaint - default constractor.");
      }
   }

   
   static class ChildGoldSaint extends GoldSaint {
      static{
         System.out.println("ChildGoldSaint - static block.");
      }
      public ChildGoldSaint(){
         System.out.println("ChildGoldSaint - default constractor.");
      }
   }
   
   public static void main(String[] args) {
      new ChildGoldSaint();
   }

}


