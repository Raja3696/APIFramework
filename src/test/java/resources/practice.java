package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class practice {
   public static void main(String[] args) {
      Properties prop = new Properties();
      String s = "Height=200";
      String s2 = "Width=15";

      try {

         // create a new input and output stream
         FileOutputStream fos = new FileOutputStream("properties.txt");
         FileInputStream fis = new FileInputStream("properties.txt");

         // write the first property in the output stream file
         fos.write(s.getBytes());

         // change the line between the two properties
         fos.write("\n".getBytes());

         // write next property
         fos.write(s2.getBytes());

         // load from input stream
         prop.load(fis);

         // print the properties list from System.out
         prop.list(System.out);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }
   

}