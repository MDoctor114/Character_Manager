// Races.java
// Mark Doctor
// 12/2/2016
// Contains Race specific data
package gamemanager;

public class Race
{
    String raceName;
    int[] racialIncreases;
    String[] classes;
    String[] alignments;
    
    public Race(){}
    public Race(String raceName, int[] racialIncreases)
    {
        this.raceName = raceName;
        this.racialIncreases = racialIncreases;
        
    }
  
    @Override
    public String toString()
    {
        return raceName;
    }
}
