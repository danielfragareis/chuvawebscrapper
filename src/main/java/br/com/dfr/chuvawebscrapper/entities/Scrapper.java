/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dfr.chuvawebscrapper.entities;

/**
 *
 * @author danie
 */
import br.com.dfr.chuvawebscrapper.entities.Paper;
import br.com.dfr.chuvawebscrapper.entities.Person;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Scraps paper information from HTML and returns an array with the data.
 */
public class Scrapper {

    /**
     * Loads paper information from the HTML and returns an array with the data.
     *
     * @return a array of Papers with papers information
     * @param dom
     */
    public static Paper[] scrap(Document dom) {
        Elements aTags = dom.select("a.paper-card");
        List<Person> authorsList = new ArrayList<>();
        List<Paper> papersList = new ArrayList<>();

        for (Element aTag : aTags) {
            int divVolumeInfo = Integer.parseInt(aTag.select("div.volume-info").text());
            Elements university = aTag.select("span[title]");
            String paperTitle = aTag.select("h4.my-xs").text();
            String paperType = aTag.select("div.tags").text();
            String[] periodicAuthors = aTag.select("div.authors").text().split(";");
            if (!authorsList.isEmpty()) {
                authorsList.clear();
            }
            for (String periodicAuthor : periodicAuthors) {
                authorsList.add(new Person(periodicAuthor, university.attr("title")));
            }

            papersList.add(new Paper(divVolumeInfo, paperTitle, paperType, authorsList.toArray(Person[]::new)));
        }

        return papersList.toArray(Paper[]::new);
    }
}
