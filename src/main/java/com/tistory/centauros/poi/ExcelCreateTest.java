package com.tistory.centauros.poi;

import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelCreateTest {

    public static void main(String[] args) {

        DataValidation dataValidation = null;
        DataValidationConstraint constraint = null;
        DataValidationHelper validationHelper = null;

        //XSSFWorkbook or HSSFWorkbook
        XSSFWorkbook wb = new XSSFWorkbook();
        //create sheet
        XSSFSheet sheet1 = wb.createSheet("DropDownTest");
        //dropdown list - valid value
        String[] validValue = {"10", "20", "30"};

        validationHelper = new XSSFDataValidationHelper(sheet1);
        //valid value apply range - row&col start index is 0
        CellRangeAddressList addressList = new CellRangeAddressList(1, 10, 1, 1);
        constraint =validationHelper.createExplicitListConstraint(validValue);
        dataValidation = validationHelper.createValidation(constraint, addressList);
        //set dropdown
        dataValidation.setSuppressDropDownArrow(true);
        //set invalid data alert
        dataValidation.setShowErrorBox(true);
        //create invalid alert message
        dataValidation.createErrorBox("Error", "올바른값을 입력하세요!!");
        sheet1.addValidationData(dataValidation);

        //init data
        sheet1.createRow(1).createCell(1).setCellValue("selected");
        try {
            //file write
            FileOutputStream fos = new FileOutputStream("excelTest.xlsx");
            wb.write(fos);
            fos.close();
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
