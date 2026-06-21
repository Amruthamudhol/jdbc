package com.xworkz.software.runner;

import com.xworkz.software.dao.SoftwareDAO;
import com.xworkz.software.dao.SoftwareDAOImpl;
import com.xworkz.software.dto.SoftwareDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;

public class ExcelRunner {
    public static void main(String[] args) {

        String filePath;
        filePath = "D:\\jdbc\\software\\softaware.xlsx";
        SoftwareDAO dao = new SoftwareDAOImpl();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            boolean isHeader = true;

            for (Row row : sheet) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String software = row.getCell(0).getStringCellValue();

                String currentVersion = row.getCell(1).toString();

                int developedYear = (int) row.getCell(2).getNumericCellValue();

                String developedBy = row.getCell(3).getStringCellValue();

                String openSource = row.getCell(4).getStringCellValue();

                SoftwareDTO dto = new SoftwareDTO(software, currentVersion, developedYear, developedBy, openSource);
                boolean saved = dao.save(dto);
                System.out.println(dto + " -> " + saved);
            }

            System.out.println("Excel data imported successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
