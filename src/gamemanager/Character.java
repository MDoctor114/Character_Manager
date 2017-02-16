// Character.java
// Mark Doctor
// 11/9/2016
// Base class for all characters
package gamemanager;

class Character
{
    private static int count = 0;
    //private final int characterID; Need to learn how to implement this when storing in database
    private String characterName;
    private int level;
    private String race;
    private String alignment;
    //private int[] languages; want to use numbers to pull from a languages table
    private float experience;
    private float hitPoints;
    private int initiative;
    private int speed;
    private int armorClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    
    //Constructor
    public Character(String characterName, int level, String race, 
                     String alignment, float experience, float hitPoints, 
                     int strength, int dexterity, int constitution,
                     int intelligence, int wisdom, int charisma)
    {
        this.characterName = characterName;
        this.level = level;
        this.race = race;
        this.alignment = alignment;
        //this.languages = languages; not implemented
        this.experience = experience;
        this.hitPoints = hitPoints;
        count++;
    }
    
    //Methods/Behaviors
    //toString method
    @Override
    public String toString()
    {
        return "Name: \t\t" + characterName +
                "\n  Level: \t" + level +
                "\n  Alignment: \t" + alignment +
                "\n  Race: \t" + race;
    }
    
    //Getters/Setters
    public static int getCount() {return count;}    
}// end class
