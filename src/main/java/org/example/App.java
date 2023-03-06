package org.example;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App

{
    public static void main( String[] args )
    {

        File file = new File("/home/leonidas/Documents/ApachePoi2/src/main/java/org/example/myfile.txt");
        try( FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader =new BufferedReader(fileReader);){

            String line =bufferedReader.readLine();

            while(line!= null){
                System.out.println(line);
                line=bufferedReader.readLine();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        }
    }

 
