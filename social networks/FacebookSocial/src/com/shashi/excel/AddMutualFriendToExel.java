package com.shashi.excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class AddMutualFriendToExel {
	private String inputFile;
	public static File excelFile; 
	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	 private WritableWorkbook workbook;
	public static AddMutualFriendToExel instance = null;
	public static int sheetNo = 0;
	public static AddMutualFriendToExel getInstance()
	{
		if(instance == null)
			instance = new AddMutualFriendToExel();
		return instance;
	}
	
	public void setOutputFile(String inputFile) 
	{
		  this.inputFile = inputFile;
		  excelFile = new File(inputFile);
	}
	
	private AddMutualFriendToExel()
	{
		//WriteExcel test = new WriteExcel();
	    this.setOutputFile("facebook.xls");
	    WorkbookSettings wbSettings = new WorkbookSettings();

	    wbSettings.setLocale(new Locale("en", "EN"));
	    try {
			workbook = Workbook.createWorkbook(excelFile, wbSettings);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Workbook can not be creattd .....");
			e.printStackTrace();
		}
	}
	private void createLabel(WritableSheet sheet)
		      throws WriteException {
		    // Lets create a times font
		    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		    // Define the cell format
		    times = new WritableCellFormat(times10pt);
		    // Lets automatically wrap the cells
		    times.setWrap(true);

		    // create create a bold font with unterlines
		    WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
		        UnderlineStyle.SINGLE);
		    timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		    // Lets automatically wrap the cells
		    timesBoldUnderline.setWrap(true);

		    CellView cv = new CellView();
		    cv.setFormat(times);
		    cv.setFormat(timesBoldUnderline);
		    cv.setAutosize(true);

		    // Write a few headers
		    addCaption(sheet, 0, 0, "Mutual Friend");
		    addCaption(sheet, 1, 0, "Friend ID");
	}
	 private void addCaption(WritableSheet sheet, int column, int row, String s)
		      throws RowsExceededException, WriteException {
		    Label label;
		    label = new Label(column, row, s, timesBoldUnderline);
		    sheet.addCell(label);
	 }
	 
	 private void createContent(WritableSheet sheet, HashMap<String, String> mutual) throws WriteException,
     RowsExceededException 
     {
		 int i = 1;
		 Set<String> mutualFriendNames = mutual.keySet();
		 for (String mutualFriend : mutualFriendNames) {
			 addLabel(sheet, 0, i, mutualFriend);
			 addLabel(sheet, 1, i, mutual.get(mutualFriend));
			 i++;
		}
	 }
	 
	 private void addLabel(WritableSheet sheet, int column, int row, String mutualFriend)
		      throws WriteException, RowsExceededException {
		    Label label;
		    label = new Label(column, row, mutualFriend, times);
		    sheet.addCell(label);
	 }
	 
	public void addMutualFriend(String friend, HashMap<String, String> mutual)
	{
	    try {		
			workbook.createSheet(friend, sheetNo);
			WritableSheet excelSheet = workbook.getSheet(sheetNo);
			createLabel(excelSheet);
			createContent(excelSheet, mutual);

			
			sheetNo++;
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void closeWorkBook()
	{
		try {
			workbook.write();
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
