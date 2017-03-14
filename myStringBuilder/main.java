
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author AYDIN ÇALIKOĞLU
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStringBuilder myBuilder=new MyStringBuilder();
        readFile(myBuilder,"numbers.txt");

        /**
         * Test indexes and get method toString
         */
        fileWrite(myBuilder.toString(),"Result1.txt");
        System.out.println("indexes and get method toString done: ");
        
        /**
         * Test iterator toString
         */
        fileWrite(myBuilder.toString2(),"Result2.txt");
        System.out.println("iterator toString: Done ");
        /**
         * Test toString method of the linked list
         */
       	fileWrite(myBuilder.toString(),"Result3.txt");
        System.out.println("toString method of the linked list done ");
        
    }
    /**
     * Read into myBuilder
     * @param myBuilder
     * @param fileName 
     */
    public static void readFile(MyStringBuilder myBuilder,String fileName)
    {
           try {
	    File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        myBuilder.appendAnything(scanner.nextInt());
                    } else {
                        scanner.next();
                    }
                }
                scanner.close();
            }
        } catch (IOException ex) {
            System.out.println("Open File Error ("+fileName+" may not found )\n");
            
        }
    }
    /**
     * Write File given String
     * @param document
     * @param fileName 
     */
    public static void fileWrite(String document,String fileName) {
        BufferedWriter writeFile=null;
        try
        {
            File file = new File(fileName);
            file.createNewFile();
            writeFile = new BufferedWriter(new FileWriter(file));
            String[] str=document.split("\n");
            for (int i = 0; i <str.length ; i++) {
                writeFile.write(str[i]);
                writeFile.newLine();
            }
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found");
            System.exit( 1 );
        }
        catch(IOException e)
        {
            System.out.println("File IO Error");
            System.exit( 1 );
        }
        finally{
            try {
                if(writeFile!=null)
                    writeFile.close();
            } catch (IOException ex) {
                System.out.println("File IO Error");
            }
        }
    }
    
}
