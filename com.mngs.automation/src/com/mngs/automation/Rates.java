package com.mngs.automation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Rates
{
public static void main(String[] args) throws InvalidFormatException, IOException, ParseException
{
    ArrayList arr=new ArrayList();

    Date date = new Date();
    System.out.println(date.toString());

    SimpleDateFormat format = new SimpleDateFormat("E MMM dd hh:mm:ss zzz yyyy", Locale.ENGLISH);
    
    Calendar myCal = new GregorianCalendar();
    myCal.setTime(date);
    DecimalFormat df = new DecimalFormat("00");
    int day = (myCal.get(Calendar.DAY_OF_MONTH)-1);
    String dy = df.format(day+1);
        int month = ((int)myCal.get(Calendar.MONTH)+1);
        String mnth = df.format(month);
    int year =  myCal.get(Calendar.YEAR);
    System.out.println("Day: " + myCal.get(Calendar.DAY_OF_MONTH));
    System.out.println("Month: " + ((int)myCal.get(Calendar.MONTH)+1));
    System.out.println("Year: " + myCal.get(Calendar.YEAR));

    File f=new File("C:\\automation\\rates"+mnth+dy+".txt");

Scanner in=new Scanner(f);
System.out.println("Read Data From The Txt file ");
while(in.hasNext())
{    
//arr.add(in.next());
arr.add(in.nextLine());
}
System.out.println("Data From ArrayList");
System.out.println(arr);

StringBuilder sb = new StringBuilder();
for(int i=0;i<arr.size();i++) {
sb.append(arr.get(i));
sb.append("\r\n");}
System.out.println("String builder contents");
System.out.println(sb);
System.out.println("Write data to an Excel Sheet");

File file = new File("C:/automation/Rates_"+mnth+year+".xls");
boolean exists= file.exists();
if (!exists) {
	System.out.println("Entering file not found loop");
FileOutputStream fos=new FileOutputStream("C:/automation/Rates_"+mnth+year+".xls");
HSSFWorkbook workBook = new HSSFWorkbook();
HSSFSheet spreadSheet = workBook.createSheet("Rates");
HSSFRow row;
HSSFCell cell;
row = spreadSheet.createRow(day);
row.setHeight((short) (10*spreadSheet.getDefaultRowHeight()));
HSSFCellStyle cs = workBook.createCellStyle();
spreadSheet.setColumnWidth(0,8000);
cs.setWrapText(true);
cell = row.createCell(0);	
cell.setCellStyle(cs);
cell.setCellValue(sb.toString());

/*for(int i=0;i<arr.size();i++) {
	System.out.println(arr.get(i));
	row = spreadSheet.createRow((i));
cell = row.createCell(0);	
cell.setCellValue(arr.get(i).toString());
}*/
System.out.println("Done");
workBook.write(fos);
fos.close();
}

else
{
	System.out.println("Entering file found loop");
	FileInputStream inp = new FileInputStream("C:/automation/Rates_"+mnth+year+".xls");
 HSSFWorkbook workbook = new HSSFWorkbook(inp);
	 HSSFSheet spreadSheet = workbook.getSheetAt(0);
	
	 HSSFRow row;
	 HSSFCell cell;
	 row = spreadSheet.createRow(day);
	 row.setHeight((short) (10*spreadSheet.getDefaultRowHeight()));
	 HSSFCellStyle cs = workbook.createCellStyle();
	 spreadSheet.setColumnWidth(0,8000);
	 cs.setWrapText(true);
	 cell = row.createCell(0);	
	 cell.setCellStyle(cs);
	 cell.setCellValue(sb.toString());
	 System.out.println("Done");
	 FileOutputStream fos=new FileOutputStream("C:/automation/Rates_"+mnth+year+".xls");
	 workbook.write(fos);
	 fos.close();
} 

	
arr.clear();
System.out.println("ReadIng From Excel Sheet");

FileInputStream fis = null;
    fis = new FileInputStream("C:/automation/Rates_"+mnth+year+".xls");

    HSSFWorkbook workbook = new HSSFWorkbook(fis);
    HSSFSheet sheet = workbook.getSheetAt(0);
    Iterator rows = sheet.rowIterator();

    while (rows.hasNext()) {
        HSSFRow row1 = (HSSFRow) rows.next();
        Iterator cells = row1.cellIterator();
        while (cells.hasNext()) {
            HSSFCell cell1 = (HSSFCell) cells.next();
            arr.add(cell1);
        }
System.out.println(arr);
	
}
}
}