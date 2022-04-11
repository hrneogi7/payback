package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {
    private XSSFWorkbook workbook;

    public ExcelReader() {
        try {
            //C:\Users\HNEOGI\OneDrive - Capgemini\Documents\L1 Training\Sprint2\payback-explore\Resources
            String fileSeparator = System.getProperty("file.separator");
            String folderPath = System.getProperty("user.dir") + fileSeparator + "Resources";

            String fileName = "TestData.xlsx";
            String filePath = folderPath + fileSeparator + fileName;
            System.out.println(filePath);
            File excelFile = new File(filePath);
            FileInputStream inputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
            System.out.println("Excel file not found!");
        }
    }

    public Row getRowBySheetAndIndex(String sheetName, int rowIndex) {
        return workbook.getSheet(sheetName).getRow(rowIndex);
    }

    public String getCellData(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        if (cell == null)
            return "";
        else if (cell.getCellType() == CellType.NUMERIC)
            return String.valueOf((int) cell.getNumericCellValue());
        else
            return cell.getStringCellValue();
    }
}

