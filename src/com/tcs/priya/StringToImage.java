package com.tcs.priya;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

/**
 * 
 * @author eshak01
 *
 */
public class StringToImage {

   public static void main(String[] args) throws IOException {
      String sourceData = "data:image/jpg;base64,/9j/4AAQSkZJRg";
      String base64Image = sourceData.split(",")[1];
      
      BASE64Decoder decoder = new BASE64Decoder();
      byte[] imageByte = decoder.decodeBuffer(base64Image);

      ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
      BufferedImage image = ImageIO.read(bis);
      bis.close();

      File outputfile = new File("image.jpg");
      ImageIO.write(image, "jpg", outputfile);
      System.out.println(outputfile.getAbsolutePath());
   }
}
