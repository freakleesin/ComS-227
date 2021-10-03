package lab8;

import java.util.ArrayList;

public class ArrayListExample4 {
  public static void removeDuplicates(ArrayList<String> words )
  {
      ArrayList<String> temp = new ArrayList<String>();
   for(String word : words){
	   if(!temp.contains(word))   {
		   temp.add(word);
		   }
    }
   words.clear();
   words.addAll(temp);
  }
   
  public static void main(String[] args)
   {
     ArrayList<String> test = new ArrayList<String>();
     test.add("a");
     test.add("a");
     test.add("b");
     test.add("b");
     test.add("c");
     test.add("d");
     removeDuplicates(test);
     System.out.println(test);
   }
}