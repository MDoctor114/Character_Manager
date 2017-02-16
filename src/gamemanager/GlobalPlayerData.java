// AllRaces.java
// Mark Doctor
// 12/2/2016
// Creates all available races
package gamemanager;

public class GlobalPlayerData
{
    final static Race[] RACES = new Race[] {
                    new Race("Human", new int[]{1,1,1,1,1,1}), 
                    new Race("Dwarf", new int[]{2,0,2,0,0,0}),
                    new Race("Elf",   new int[]{0,2,0,0,0,1}),
                    new Race("Orc",   new int[]{2,0,1,-2,0,0}),
                    new Race("Halfling", new int[]{0,2,0,0,0,1})
                };
    final static String[] CLASSES = {"Barbarian", "Bard", "Druid", "Monk", "Paladin", "Ranger", "Sorcerer", "Warlock"};
    final static String[] ALIGNMENTS = {"Lawful Good", "Neutral Good", "Chaotic Good", 
                                        "Lawful Neutral", "True Neutral", "Chaotic Neutral",
                                        "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
    
    public static int getBonus(Race race, String stat)
    {
        int bonus = 0;
        switch (stat)
        {
            case "Strength": 
                bonus = race.racialIncreases[0];
                break;
            case "Dexterity":
                bonus = race.racialIncreases[1];
                break;
            case "Constitution": 
                bonus = race.racialIncreases[2];
                break;
            case "Intelligence":
                bonus = race.racialIncreases[3];
                break;    
            case "Wisdom": 
                bonus = race.racialIncreases[4];
                break;
            case "Charisma":
                bonus = race.racialIncreases[5];
                break;    
        }       
        return bonus;
    }
}
