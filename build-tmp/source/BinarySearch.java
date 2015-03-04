import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class BinarySearch extends PApplet {

private Item[] store = {new Item(184,14),
        new Item(196,60),
        new Item(206,31),
        new Item(2370,65),
        new Item(7282,73),
        new Item(8303,90),
        new Item(12328,63),
        new Item(12705,14),
        new Item(13066,8),
        new Item(14088,92),
        new Item(15320,82),
        new Item(15814,60),
        new Item(15917,51),
        new Item(17911,96),
        new Item(18061,3),
        new Item(18410,56),
        new Item(18465,27),
        new Item(18618,64),
        new Item(18871,69),
        new Item(19967,45)
};                             
public int linearSearch(int catNumToFind)
{
    for(Item theI : store){
        if(theI.getCatNum()==catNumToFind)
            return theI.getInventory();
    }
    return -1;
}
public int binarySearch(int catNumToFind)
{
  int low = 0;
  int high = store.length-1;
  int i = (high+low)/2;
 // System.out.println("mid is:" +i);
  while(low<=high){
    i = (high+low)/2;
    //System.out.println("Low: "+low+" High: "+high);
    if(store[i].getCatNum()==catNumToFind)
        return store[i].getInventory();
    if(catNumToFind>store[i].getCatNum()){
      low = i + 1;
    } else {
      high = i - 1;
    }
  }  
    return -1;    
}
public int binarySearch(int catNumToFind,int nLow, int nHigh)
{
  int i = (nHigh+nLow)/2;
  if(store[i].getCatNum() == catNumToFind){
    return store[i].getInventory();
  }
  if(nLow<=nHigh){
      if(catNumToFind<store[i].getCatNum() ){
        return binarySearch(catNumToFind, nLow, nHigh-1);
      }

      if(catNumToFind>store[i].getCatNum()){
        return binarySearch(catNumToFind, nLow+1, nHigh);
      }  
  }    
    return -1;           
}
public void setup()
{
    int[] tests = {0,183,184,2370,15320,19967,19968};
    System.out.println();
    System.out.println("Testing Linear Search");
    System.out.println("=====================");
    for (int i = 0; i < tests.length; i++)
    {

        if(linearSearch(tests[i]) != -1)
            System.out.println("Catalog #"+tests[i]+" has "+linearSearch(tests[i]) + " in stock");
        else
            System.out.println("Catalog #"+tests[i]+" not found");
    }
    System.out.println();
    System.out.println("Testing Non Recursive Binary Search");
    System.out.println("===================================");
    for (int i = 0; i < tests.length; i++)
    {

        if(binarySearch(tests[i]) != -1)
            System.out.println("Catalog #"+tests[i]+" has "+binarySearch(tests[i]) + " in stock");
        else
            System.out.println("Catalog #"+tests[i]+" not found");
    }
    System.out.println();
    System.out.println("Testing Recursive Binary Search");
    System.out.println("===============================");
    for (int i = 0; i < tests.length; i++)
    {

        if(binarySearch(tests[i],0,store.length - 1) != -1)
            System.out.println("Catalog #"+tests[i]+" has "+binarySearch(tests[i],0,store.length - 1) + " in stock");
        else
            System.out.println("Catalog #"+tests[i]+" not found");
    }

}

public void draw()
{
    //empty!
}





  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BinarySearch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
