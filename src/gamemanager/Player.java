// Player.java
// Mark Doctor
// 11/9/2016
// Player class contains a player's data
package gamemanager;

class Player extends Character
{
    private String playerName;
    private String classType;
    private static int count = 0;
    
    public Player(String playerName, String classType,
                  String characterName,  int level, String race, 
                  String alignment, float experience, float hitPoints, 
                  
                  int strength, int dexterity, int constitution,
                  int intelligence, int wisdom, int charisma)
    {
        super(characterName, level, race, alignment, experience, hitPoints,
              strength, dexterity, constitution,
              intelligence, wisdom, charisma);
        
        this.playerName = playerName;
        this.classType = classType;
        count++;
    }
    
    //Getters/Setters
    public static int getCount() {return count;}
    public static int diceRoll()
    {   
        return (int) (Math.random() * 6) + 1;
    }
    public static int getStatRoll()
    {
        int[] rolls = new int[4];
        int min = 6;
        int score = 0;
        for ( int index = 0; index < rolls.length; index++)
        {
            rolls[index] = Player.diceRoll();
            if (rolls[index] < min) {min = rolls[index];}
            score += rolls[index];
        }
        score -= min;
        return score;
    }
}// end class
