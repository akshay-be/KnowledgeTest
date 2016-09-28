package verifone.emv;

public class TLVDecoding {

	public static void main(String[] args) {
		
		//String tlv = "9F1200500E484446432042414E4B20564953415F300202015F201A53414B5448494D414E492050202020202020202020202020202F57104617864843972189D60012013473256F5A0846178648439721895F24036001315F3401015F2503130101";
		//String tlv = "9F26103A2F6CAD213A73449F2702805F2A0484009A061505119B04E8009C020082045D805F340200950a04800088009F1A048400FFC60aFC50A8A0009F0206024.98FFC80aF850A8F8009F36040058FFC70a04000000009F3708768164B49F34065E03009F03060000009F0904008C4F10A0000000250104039F0704FF009F1010020103A0800000009F0F0aF470C498009F0E0a00000000009F0D0aF470C49800";
		//String tlv = "9F2608226B79B5EA225BEE9F2701805F2A0284009F4005F000F0A0019A031505219F21031555169B02E8009C01009F4104000000239F1E048287902282025C008407A00000000310105F3401019505408000E8009F1A028400FFC605DC4000A8009F02030024989F390105FFC805DC4004F8009F3602695FFFC70500100000009F3704102C590E9F3501229F0607A00000000310109F34030103029F3303E0B8C89F03030000009F090200969F120B56697361204372656469744F07A00000000310109F0802008C9F0702FF009F100706010A03A408009F0F0500000000009F0E0500008000009F0D0500000000005F28020124";
		
		String tlv ="9F1A0208409F3901059F360200025F3401039F37049B3A68184F07A00000009808409F34031F00029F3501229F100706010A03A000009F3303E008C89F0E0500000000005F2A0208409F0F05FC70BC98009F0D05FC50AC8800950580000080009A031511209F2701809B0268009F0607A00000009808409F03060000000000009C01009F2608899DB85ABEBBC43B9F0902008C5F280208409F0702FF009F0802008C9F4104000000049F4005F000F0A001FFC605DC4000A800FFC70500100000009F0206000000002000FFC805DC4004F8009F2103050300820218009F1E0800000000835596748407A0000000980840"; 
		StringBuffer tlvBuffer = new StringBuffer(tlv);
		String tag;
		String length;
		String value;
		
		 if (tlv.matches(".*[a-z].*")){
			System.out.println("Packet contains lower case letter......"); 
		 }else{
		
			while(tlvBuffer.length()>0){
				
			Integer i2 = Integer.decode("0x"+tlvBuffer.substring(0, 2));
				
			//System.out.println("I2 : "+i2);
			//int i = 0x95;
			if((i2&0x1F)==0x1F){
				//System.out.println("Hello Tag");
				tag = tlvBuffer.substring(0, 4);
				tlvBuffer = tlvBuffer.delete(0,4);
			}else{
				//System.out.println("Bye Tag");
				tag = tlvBuffer.substring(0, 2);
				//tlv = tlv.substring(2);
				tlvBuffer = tlvBuffer.delete(0,2);
			}
			
			Integer lengthInteger = Integer.decode("0x"+tlvBuffer.substring(0, 2));
			
			if((lengthInteger&0x80) == 0x80){
				//System.out.println("Hello Value");
				length = tlvBuffer.substring(0, 4);
				//tlv = tlv.substring(4);
				tlvBuffer = tlvBuffer.delete(0,4);
			}else{
				//System.out.println("Bye Value");
				length = tlvBuffer.substring(0, 2);
				//tlv = tlv.substring(2);
				tlvBuffer = tlvBuffer.delete(0,2);
			}
			//System.out.println("Tag : "+tag);
			//System.out.println("Length : "+length);
			int intLength = Integer.decode("0x"+length);
			value = tlvBuffer.substring(0,intLength*2);
			//tlv = tlv.substring(intLength*2);
			tlvBuffer =tlvBuffer.delete(0, intLength*2);
			if(tlv.matches(".*[a-z].*") || tlv.matches(".*[a-z].*") || tlv.matches(".*[a-z].*")){
				System.out.println(tag+" : "+length+" : "+value);
			}else{
				System.out.println(tag+" : "+value);
			}
			//System.out.println("Remaining : "+tlvBuffer.toString());
			
			}
		 }
	}
}
