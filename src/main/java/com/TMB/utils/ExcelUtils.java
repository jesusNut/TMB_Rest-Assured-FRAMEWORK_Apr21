package com.TMB.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {

	private ExcelUtils() {
	};

	// to get entire excel data in form of List of Maps

	public static List<Map<String, String>> getExcelData(String sheetName, String workBookName)
			throws FileNotFoundException, IOException {
		String excel_sheet_path = System.getProperty("user.dir") + "/src/test/resources/excel/" + workBookName
				+ ".xlsx";

		FileInputStream fis = new FileInputStream(excel_sheet_path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheet(sheetName);

		int total_rows = sheet.getLastRowNum();

		Row row = sheet.getRow(0);

		int total_col = row.getLastCellNum();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		Map<String, String> datamap = null;

		for (int i = 1; i <= total_rows; i++) {

			datamap = new HashMap<String, String>();

			for (int j = 0; j < total_col; j++) {

				String key = sheet.getRow(0).getCell(j).getStringCellValue();

				String value = sheet.getRow(i).getCell(j).getStringCellValue();

				datamap.put(key, value);

			}

			list.add(datamap);

		}

		return list;
	}

}
