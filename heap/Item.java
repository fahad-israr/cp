// Java code to demonstrate 
// the working of TreeSet 
import java.util.*; 
import java.io.*;
class House { }
public class Item implements Serializable
{
  private House house  = new House();

  public static void main(String[]args){
    Item items = new Item();
    items.FarmHouse(items);
  }


void FarmHouse(Item items){
  try{
    ObjectOutputStream os =  new ObjectOutputStream(new FileOutputStream("File"));
    os.writeObject(house);
    os.close();
    System.out.println("Finished");
  }
  catch(Exception x){
    System.out.println("Exception");
  }
}
}
