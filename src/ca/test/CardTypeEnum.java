package ca.test;

/**
 * 
 * @author eshak01
 *
 */
public enum CardTypeEnum {

   VISA(1, "Visa"), MASTERCARD(2, "Mastercard"), JCB(3, "Jcb"), AMEX(4, "Amex"), DISCOVER(6, "Discover");
   private int code;
   private String value;

   private CardTypeEnum(int code, String value) {
      this.code = code;
      this.value = value;
   }

   public int getCode() {
      return code;
   }

   public String getValue() {
      return value;
   }

   public static String getCardTypeValue(int code) {
      for (CardTypeEnum cardType : CardTypeEnum.values()) {
         if (cardType.getCode() == code) {
            return cardType.getValue();
         }
      }
      return "";
   }

   public static long getCardCode(String value) {
      for (CardTypeEnum cardType : CardTypeEnum.values()) {
         if (value != null && cardType.getValue().toLowerCase().equals(value.toLowerCase())) {
            return cardType.getCode();
         }
      }
      return 0;
   }

}
