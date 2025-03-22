package com.successTeam.core.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * program: graduate
 * ClassName ExcelParserUtils
 * description:
 * author: xhonell
 * create: 2025年02月02日18时16分
 * Version 1.0
 **/
public class ExcelParserUtils<T> {

    private final Class<T> clazz;

    public ExcelParserUtils(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> parseExcel(InputStream inputStream) throws Exception {
        List<T> resultList = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // 读取表头（第一行）
            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(cell.getStringCellValue());
            }

            // 读取数据行
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                T obj = clazz.getDeclaredConstructor().newInstance();

                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String header = headers.get(i);
                    setFieldValue(obj, header, cell);
                }

                resultList.add(obj);
            }
        }

        return resultList;
    }

    private void setFieldValue(T obj, String fieldName, Cell cell) throws Exception {
        Field field;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            // 如果字段不存在，跳过
            return;
        }

        field.setAccessible(true);
        Class<?> fieldType = field.getType();

        if (fieldType == String.class) {
            // 处理字符串类型
            field.set(obj, cell.getStringCellValue());
        } else if (fieldType == int.class || fieldType == Integer.class) {
            // 处理整数类型
            field.set(obj, Integer.parseInt(cell.getStringCellValue()) );
        } else if (fieldType == double.class || fieldType == Double.class) {
            // 处理双精度浮点数类型
            field.set(obj, cell.getNumericCellValue());
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            // 处理布尔类型
            field.set(obj, cell.getBooleanCellValue());
        } else if (fieldType == long.class || fieldType == Long.class) {
            // 处理长整型,使用科学计数法解决问题
            DecimalFormat df = new DecimalFormat("0");
            String valueString = df.format(cell.getNumericCellValue());
            field.set(obj, Long.parseLong(valueString));
        } else if (fieldType == float.class || fieldType == Float.class) {
            // 处理浮点类型
            field.set(obj, (float) cell.getNumericCellValue());
        } else if (fieldType == char.class || fieldType == Character.class) {
            // 处理字符类型
            String cellValue = cell.getStringCellValue();
            field.set(obj, !cellValue.isEmpty() ? cellValue.charAt(0) : '\0');
        } else if (fieldType == java.util.Date.class) {
            // 处理日期类型，假设日期格式为 "yyyy-MM-dd"
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String cellValue = cell.getStringCellValue();
            try {
                field.set(obj, dateFormat.parse(cellValue));
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format: " + cellValue, e);
            }
        } else {
            // 其他类型可以在这里扩展
            throw new UnsupportedOperationException("Unsupported field type: " + fieldType);
        }
    }
}
