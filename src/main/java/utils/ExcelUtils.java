package utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class ExcelUtils {

    public static String getCellValue(String filePath, int row, int col) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheetAt(0);
            return sheet.getRow(row).getCell(col).getStringCellValue();
        } catch (Exception e) {
            System.out.println("Excel read error: " + e.getMessage());
            return null;
        }
    }
}