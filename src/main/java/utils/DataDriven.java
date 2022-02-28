package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class DataDriven {

    public XSSFWorkbook excel_utils_base() throws IOException {
        File file = new File("C:\\Users\\mayurmansukh\\OneDrive - Instarem PTE Ltd\\Desktop\\Automation-Assessment\\Data.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        return workbook;
    }

    public String excelData1() throws IOException {
        XSSFSheet sheet = excel_utils_base().getSheetAt(0);
        XSSFCell username = sheet.getRow(1).getCell(0);
        return String.valueOf(username);
    }

    public String excelData2() throws IOException {
        XSSFSheet sheet = excel_utils_base().getSheetAt(0);
        XSSFCell password = sheet.getRow(1).getCell(1);
        return String.valueOf(password);
    }

}

