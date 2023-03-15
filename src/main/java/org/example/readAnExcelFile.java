package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class readAnExcelFile {
    public static void main(String[] args){

        File file_name =new File("writeAnExcelFile.xlsx");
        try(FileInputStream file =new FileInputStream(file_name);
            XSSFWorkbook workbook =new XSSFWorkbook(file);){

            //get the desired sheet from workbook
            XSSFSheet sheet= workbook.getSheetAt(0);

            //iterate through each rows one by one
            Iterator<Row> rowIterator=sheet.iterator();
            while (rowIterator.hasNext()){

                Row row = rowIterator.next();
                //for each row iterate through all the columns
                Iterator<Cell> cellIterator=row.cellIterator();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();

                    //check the cell type and format accordingly
                    switch(cell.getCellType()){
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue()+"\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue()+"\t");
                            break;



                    }
                }
                System.out.println("");
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
