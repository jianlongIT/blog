package com.blog.blog.fileUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/utils")
public class XSSFWorkUtils {

    @RequestMapping("/readExcel")
    public static Map ReadExcel(@RequestParam String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }
        XSSFWorkbook xssfWorkbook = null;
        Map result = new HashMap();
        try {
            StringBuffer stringBuffer = new StringBuffer();
            xssfWorkbook = new XSSFWorkbook(file);
            Integer sheetNum = xssfWorkbook.getNumberOfSheets();
            for (int i = 0; i < sheetNum; i++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(i);
                Integer rowNum = xssfSheet.getLastRowNum();
                for (int j = 0; j < rowNum + 1; j++) {
                    XSSFRow xssfRow = xssfSheet.getRow(j);
                    XSSFCell firstCell = xssfRow.getCell(0);
                    XSSFCell lastCell = xssfRow.getCell(3);
                    if (firstCell == null || lastCell == null) {
                        continue;
                    }
                    String firstValue = firstCell.getStringCellValue();
                    String lastValue = lastCell.getStringCellValue();
                    if (StringUtils.isBlank(firstValue) || StringUtils.isBlank(lastValue)) {
                        continue;
                    }
                    stringBuffer.append(firstValue).append(lastValue);
                }
            }
            result.put("data", stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (xssfWorkbook != null) {
                try {
                    xssfWorkbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
