/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dfr.chuvawebscrapper.controller;

import br.com.dfr.chuvawebscrapper.entities.Paper;
import br.com.dfr.chuvawebscrapper.entities.Person;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author danie
 */
public class ExcelExporter {

    public static void exportToExcel(Paper[] papers, String filePath) {
        // Crie uma nova pasta de trabalho XLSX

        try (FileInputStream fileInputStream = new FileInputStream(filePath); 
                Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            
            Sheet sheet = workbook.getSheetAt(0);
            
            int rowIndex = 1;
 
            for (Paper paper : papers) {
                Row row = sheet.createRow(rowIndex++); // Criar uma nova linha

                Cell cell0 = row.createCell(0, CellType.NUMERIC);
                cell0.setCellValue(paper.getId());

                Cell cell1 = row.createCell(1, CellType.STRING);
                cell1.setCellValue(paper.getTitle());

                Cell cell2 = row.createCell(2, CellType.STRING);
                cell2.setCellValue(paper.getType());

                Person[] authors = paper.getAuthors();
                int authorColumn = 3; 

                for (Person author : authors) {
                    Cell authorNameCell = row.createCell(authorColumn, CellType.STRING);
                    authorNameCell.setCellValue(author.getName());
                    authorColumn++;

                    Cell authorInstitutionCell = row.createCell(authorColumn, CellType.STRING);
                    authorInstitutionCell.setCellValue(author.getInstitution());
                    authorColumn++;
                }
                
                try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                    workbook.write(outputStream);
                } catch (IOException e) {
                    System.out.println("Ocorreu um erro na manipulação de dados: " + e.getMessage());
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível encontra o arquivo. Verifique se o caminho está correto."
                    + "\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na manipulação de dados: " + e.getMessage());
        }
    }
}