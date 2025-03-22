package com.successTeam.core.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * program: graduate
 * ClassName ExcelExportUtils
 * description:
 * author: xhonell
 * create: 2025年02月02日16时18分
 * Version 1.0
 **/
public class ExcelExportUtils {
    /**
     * 导出 Excel 文件
     *
     * @param response      HttpServletResponse
     * @param fileName      导出的文件名
     * @param sheetName     Sheet 名称
     * @param headers       表头数组
     * @param dataList      数据列表
     * @param dataMapper    数据映射函数，用于将数据对象映射为单元格值
     * @param <T>           数据类型
     * @throws IOException  IO 异常
     */
    public static <T> void exportExcel(HttpServletResponse response, String fileName, String sheetName,
                                       String[] headers, List<T> dataList, DataMapper<T> dataMapper) throws IOException {
        // 创建 Excel 工作簿
        Workbook wb = new XSSFWorkbook();
        // 创建 Sheet 页
        Sheet sheet = wb.createSheet(sheetName);

        // 创建表头
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // 设置表头样式
        CellStyle headerStyle = createHeaderStyle(wb);
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            headerRow.getCell(i).setCellStyle(headerStyle);
        }

        // 创建数据行样式
        CellStyle dataStyle = createDataStyle(wb);

        // 填充数据
        if (dataList != null)
            for (int i = 0; i < dataList.size(); i++) {
                T data = dataList.get(i);
                Row row = sheet.createRow(i + 1);
                Object[] rowData = dataMapper.mapData(data); // 调用数据映射函数
                for (int j = 0; j < rowData.length; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(rowData[j] == null ? "" : rowData[j].toString());
                    cell.setCellStyle(dataStyle);
                }
            }

        // 设置列宽自适应
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        // 将工作簿写入响应流
        wb.write(response.getOutputStream());
        wb.close();
    }

    /**
     * 创建表头样式
     */
    private static CellStyle createHeaderStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true); // 加粗
        font.setFontHeightInPoints((short) 12); // 字体大小
        style.setFont(font);
        return getCellStyle(style);
    }

    /**
     * 创建数据行样式
     */
    private static CellStyle createDataStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        return getCellStyle(style);
    }

    /**
     * 获取单元格样式
     * @param style
     * @return
     */
    private static CellStyle getCellStyle(CellStyle style) {
        style.setAlignment(HorizontalAlignment.CENTER); // 水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER); // 垂直居中
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    /**
     * 数据映射接口
     */
    @FunctionalInterface
    public interface DataMapper<T> {
        Object[] mapData(T data);
    }
}
