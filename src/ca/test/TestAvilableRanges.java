package ca.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author eshak01
 *
 */
public class TestAvilableRanges {

   public static void main(String[] args) {

      Map<Long, Long> masterCardMap = new HashMap<>();
      Map<Long, Long> visaMap = new HashMap<>();
      Map<Long, Long> amexMap = new HashMap<>();
      Map<Long, Long> discoverMap = new HashMap<>();
      Map<Long, Long> jcbMap = new HashMap<>();

      List<Long> masterCardExistingRanges = new ArrayList<>();
      masterCardExistingRanges.add(Long.valueOf("5000100010001000")); masterCardExistingRanges.add(Long.valueOf("5000100010004000"));
      masterCardExistingRanges.add(Long.valueOf("5000200010002000")); masterCardExistingRanges.add(Long.valueOf("5000200010005000"));
      masterCardExistingRanges.add(Long.valueOf("5000800060001000")); masterCardExistingRanges.add(Long.valueOf("5000800060004000"));
      List<Long> visaExistingRanges = new ArrayList<>();
      visaExistingRanges.add(Long.valueOf("4460810060064900")); visaExistingRanges.add(Long.valueOf("4460810060064910"));
      visaExistingRanges.add(Long.valueOf("4685510060054980")); visaExistingRanges.add(Long.valueOf("4685510060054990"));
      visaExistingRanges.add(Long.valueOf("4011060007001800")); visaExistingRanges.add(Long.valueOf("4011060007002800"));
      visaExistingRanges.add(Long.valueOf("4000420086002000")); visaExistingRanges.add(Long.valueOf("4000420086003500"));
      List<Long> amexExistingRanges = new ArrayList<>();
      List<Long> discoverExistingRanges = new ArrayList<>();
      List<Long> jcbExistingRanges = new ArrayList<>();

      listAvailableRanges(CardTypeEnum.MASTERCARD.getCode(), masterCardExistingRanges, masterCardMap);
      listAvailableRanges(CardTypeEnum.VISA.getCode(), visaExistingRanges, visaMap);
      /*listAvailableRanges(CardTypeEnum.AMEX.getCode(), amexExistingRanges, amexMap);
      listAvailableRanges(CardTypeEnum.DISCOVER.getCode(), discoverExistingRanges, discoverMap);
      listAvailableRanges(CardTypeEnum.JCB.getCode(), jcbExistingRanges, jcbMap);*/
   }

   public static void listAvailableRanges(Integer brand, List<Long> brandExistingRanges, Map<Long, Long> brandCardMap) {
      System.out.println(" BrandExistingRanges : " + brandExistingRanges);
      if (brandExistingRanges.isEmpty()) {
         brandCardMap.put(Long.valueOf(generateMinValueOFRange(brand, 16)), Long.valueOf(generateMaxValueOFRange(brand, 16)));
      } else {
         if (brandExistingRanges.size() == 2) {
            brandCardMap.put(brandExistingRanges.get(1) + 1, Long.valueOf(generateMaxValueOFRange(brand, brandExistingRanges.get(1).toString().length())));
            long tempMinValue = Long.valueOf(generateMinValueOFRange(brand, brandExistingRanges.get(0).toString().length()));
            if (tempMinValue < brandExistingRanges.get(0)) {
               brandCardMap.put(tempMinValue, brandExistingRanges.get(0) - 1);
            }
         } else {
            Collections.sort(brandExistingRanges);
            System.out.println(" Sorted : " + brandExistingRanges);
            long tempMinValue = Long.valueOf(generateMinValueOFRange(brand, brandExistingRanges.get(0).toString().length()));
            if (brandExistingRanges.get(0) - 1 > tempMinValue) {
               brandCardMap.put(tempMinValue, brandExistingRanges.get(0) - 1);
            }
            for (int i = 1; i < brandExistingRanges.size() - 2; i += 2) {
               if (((brandExistingRanges.get(i) + 1) < (brandExistingRanges.get(i + 1) - 1))
                     && brandExistingRanges.get(i + 1) - 1 < brandExistingRanges.get(i + 2)) {
                  brandCardMap.put(brandExistingRanges.get(i) + 1, brandExistingRanges.get(i + 1) - 1);
               }
            }

            long tempMaxValue = Long.valueOf(generateMaxValueOFRange(brand, brandExistingRanges.get(1).toString().length()));
            if (brandExistingRanges.get(brandExistingRanges.size() - 1) < tempMaxValue) {
               brandCardMap.put(brandExistingRanges.get(brandExistingRanges.size() - 1) + 1, tempMaxValue);
            }
         }
      }
      System.out.println(" brandCardMap : " + brandCardMap);
   }

   public static String generateMaxValueOFRange(long brandValue, int rangeSize) {
      String result = null;
      if (brandValue == CardTypeEnum.AMEX.getCode()) {
         result = "3";
      }
      if (brandValue == CardTypeEnum.VISA.getCode()) {
         result = "4";
      }
      if (brandValue == CardTypeEnum.MASTERCARD.getCode()) {
         result = "5";
      }
      if (brandValue == CardTypeEnum.DISCOVER.getCode()) {
         result = "6";
      }
      if (brandValue == CardTypeEnum.JCB.getCode()) {
         result = "1";
      }
      for (int j = 0; j < rangeSize - 1; j++) {
         result += "9";
      }
      return result;
   }

   public static String generateMinValueOFRange(long brandValue, int rangeSize) {
      String result = null;
      if (brandValue == CardTypeEnum.AMEX.getCode()) {
         result = "3";
      }
      if (brandValue == CardTypeEnum.VISA.getCode()) {
         result = "4";
      }
      if (brandValue == CardTypeEnum.MASTERCARD.getCode()) {
         result = "5";
      }
      if (brandValue == CardTypeEnum.DISCOVER.getCode()) {
         result = "6";
      }
      if (brandValue == CardTypeEnum.JCB.getCode()) {
         result = "1";
      }
      for (int j = 0; j < rangeSize - 1; j++) {
         result += "0";
      }
      return result;
   }
}
