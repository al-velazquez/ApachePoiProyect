package org.example;


import java.io.*;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.imageio.stream.FileImageInputStream;

public class excelToCsv {
    public static void main(String[] args){

        //creating an inputFile object with specific file path
        File  inputFile= new File("/home/leonidas/Documents/ApachePoi2/writeAnExcelFile.xlsx");

        //creaet an outputFile object to write excel data to csv
        File outputFile=new File("/home/leonidas/Documents/ApachePoi2/output.csv");

        //for storing data into csv files
        //still not sure about the buffers
        StringBuffer data= new StringBuffer();

        try(FileInputStream fis =new FileInputStream(inputFile);
            FileOutputStream fos =new FileOutputStream(outputFile)){
            Workbook workbook =new XSSFWorkbook(fis);

            //get the desired shit from the workbook
            Sheet sheet=workbook.getSheetAt(0);

            //create an iterator given all sheets so we can iterate over all rows
            Iterator<Row> rowIterator=sheet.iterator();

            while(rowIterator.hasNext()){
                Row row =rowIterator.next();
                //create an iterator for each row so we can iterate over all cells (columns)
                Iterator<Cell> cellIterator= row.iterator();
                while(cellIterator.hasNext()){
                    Cell cell =cellIterator.next();

                    switch(cell.getCellType()){
                        case BOOLEAN:
                            data.append(cell.getBooleanCellValue()+",");
                            break;
                        case NUMERIC:
                            data.append(cell.getNumericCellValue()+",");

                            break;
                        case STRING:
                            data.append(cell.getStringCellValue()+",");
                            break;
                        case BLANK:
                            data.append(""+",");
                        default:
                            data.append(cell+",");

                    }
                }
                //appending new line after each row
                data.append("\n");
            }
            fos.write(data.toString().getBytes());



        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Conversion of an Excel file to cvs file");

    }
}
