/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.com.dfr.chuvawebscrapper;

import br.com.dfr.chuvawebscrapper.controller.ExcelExporter;
import br.com.dfr.chuvawebscrapper.entities.Scrapper;
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author danie
 */
public class Chuvawebscrapper {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            String originHtmlPath = System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "main"
                    + File.separator + "java"
                    + File.separator + "br"
                    + File.separator + "com"
                    + File.separator + "dfr"
                    + File.separator + "chuvawebscrapper"
                    + File.separator + "assets"
                    + File.separator + "origin.html";

            String modelXlsxPath = 
                    System.clearProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "main"
                    + File.separator + "java"
                    + File.separator + "br"
                    + File.separator + "com"
                    + File.separator + "dfr"
                    + File.separator + "chuvawebscrapper"
                    + File.separator + "assets"
                    + File.separator + "model.xlsx";
            Document dom = Jsoup.parse(new File(originHtmlPath), "UTF-8");

            ExcelExporter.exportToExcel(Scrapper.scrap(dom),modelXlsxPath);

        } catch (IOException e) {
            System.out.println("Archive not found, please verify the road to path\n"
                    + e.getMessage());
        }
    }
}
