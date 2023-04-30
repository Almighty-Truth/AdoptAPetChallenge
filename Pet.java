/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalprojectp1;

import java.time.LocalDate;

/**
 *
 * @author Khalil Tobias 
 * Date: 4/4/2023
 * Instructor: Cristy Charters 
 * Class: Intermediate Java
 */
public class Pet implements Comparable <Pet>
{
    private final String name;
    private int dob;
    private String species;
    private String microchipId;
    
    public Pet(String name, int dob, String species)
    {
        this.name = name;
        this.dob = dob;
        this.species = species;
         this.microchipId = "";
    }

    public String getMicrochipId() 
    {
        return microchipId;
    }


    public void setMicrochipId(String microchipId) 
    {
        this.microchipId = microchipId;
    }
    
    public String getName()
    {
        return name;
    }

    public int getDob() 
    {
        return dob;
    }

    public void setDob(int dob) 
    {
        this.dob = dob;
    }

    public String getSpecies() 
    {
        return species;
    }

    public void setSpecies(String species) 
    {
        this.species = species;
    }
    
    
    
    @Override
    public String toString()
    {
        return """
               
               {Name: """ + name + "\ndob: " + dob + "\nspecies: " + species + "}"; 
    }

    @Override
    public int compareTo(Pet aPet) 
    {
        if(this.dob > aPet.dob)
        {
            return 1;
        }
        else if(this.dob == aPet.dob)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

    void setMicrochipID(String microchipID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

