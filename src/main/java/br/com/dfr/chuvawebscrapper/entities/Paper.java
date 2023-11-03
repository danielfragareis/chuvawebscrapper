/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dfr.chuvawebscrapper.entities;

import java.util.Arrays;

/**
 *
 * @author danie
 */
public class Paper {

    /**
     * Paper Id.
     */
    private int id;

    /**
     * Paper Title.
     */
    private String title;

    /**
     * The paper type (e.g. Poster, Nobel Prize, etc).
     */
    private String type;

    /**
     * Paper authors.
     */
    private Person[] authors;

    /**
     * Builder.
     */
    public Paper(){
        
    }
    
    public Paper(int id, String title, String type, Person[] authors) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person[] getAuthors() {
        return authors;
    }

    public void setAuthors(Person[] authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Paper Id: " + id + "\n" 
                + "Title: " + title + "\n"
                + "Type: " + type + "\n"
                + "Authors: " + Arrays.toString(authors) + "\n";
    }
    
}