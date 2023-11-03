/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.dfr.chuvawebscrapper.entities;

/**
 *
 * @author danie
 */
public class Person {

    /**
     * Person name.
     */
    private String name;

    /**
     * Person institution.
     */
    private String institution;

    /**
     * Builder.
     */
    public Person(){
        
    }
    
    public Person(String name, String institution) {
        this.name = name;
        this.institution = institution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "\nPerson{" 
                + "\nName: " + getName() 
                + "\nInstitution: " + getInstitution()
                + "\n}";
    }
    
}