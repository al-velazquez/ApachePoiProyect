package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class writeAnExcelF {
    public static void main(String[] args) {
        File file =new File("writeAnExcelFile.xlsx");
       try(XSSFWorkbook workbook =new XSSFWorkbook();
           FileOutputStream  out =new FileOutputStream(file);){

           //create a blank sheet
           XSSFSheet sheet=workbook.createSheet("Employee Data");

           //data that will be written
           Map<String, Object[]> data= new TreeMap<String, Object[]>();
           data.put("1", new Object[]{"ID","NAME","LASTNAME"});
           data.put("2", new Object[]{1,"Amit","Shukla"});
           data.put("3", new Object[]{2,"Lokesh","Gupta"});
           data.put("4", new Object[]{3,"John","Adwards"});
           data.put("5", new Object[]{4,"Brian","Shultz"});

           //iterate over data and write to sheet
           Set<String> keyset=data.keySet();
           int rownum=0;
           for (String key: keyset)
           {
               Row row =sheet.createRow(rownum++);
               Object [] objArr=data.get(key);
               int cellnum=0;
               for (Object obj: objArr)
               {
                   Cell cell =row.createCell(cellnum++);
                   if (obj instanceof String)
                       cell.setCellValue((String)obj);
                   else if (obj instanceof Integer)
                       cell.setCellValue((Integer)obj);
               }
           }
           workbook.write(out);
           System.out.println("writeanExcelFile writen succenfully");
       }
       catch(IOException e){
           e.printStackTrace();
       }



    }
}
