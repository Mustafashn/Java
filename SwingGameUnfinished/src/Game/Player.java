package Game;
import GameCharacters.Character;
public class Player extends Character{
    private String name;
    private Character character;
    private int playerHealth;
    public Player(String name ,Character character ) {
        
        super(character.getId(), character.getDamage(),character.getHealth(), character.getPrice());
        this.name=name;
        this.character=character;
        this.playerHealth=this.character.getHealth();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }
    
}
