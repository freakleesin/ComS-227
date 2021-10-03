package lab8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer
{
  public static void main(String[] args) throws FileNotFoundException
  {
	File file = new File("/Users/liurundi/eclipse-workspace/project8/story");
    Scanner scanner = new Scanner(file);
    int lineCount = 1;
    
    while (scanner.hasNextLine())
    {
      int wordCount=0;
      String line = scanner.nextLine();
      Scanner scanner1 = new Scanner(line);
      while(scanner1.hasNext())
      {
    	  String line2 = scanner1.next();
    	  //System.out.println(line2);
    	  wordCount++;
      }
      System.out.print(lineCount+ " ");
      System.out.println(line);
      System.out.println("the number of words:"+wordCount);
      lineCount += 1;
    }
    scanner.close();
  }
}
