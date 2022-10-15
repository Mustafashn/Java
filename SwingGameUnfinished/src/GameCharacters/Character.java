package GameCharacters;

public abstract class  Character {
    private int Id;
    private int Damage;
    private int Health;
    private int price;
    private int dodge;
    private int characterX=5;
    private int characterY=5;
    public Character(int Id, int Damage, int Health, int price) {
        this.Id = Id;
        this.Damage = Damage;
        this.Health = Health;
        this.price = price;
        this.dodge=0;
    }
    public int setCharacter () {
        return 5;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getCharacterX() {
        return characterX;
    }

    public void setCharacterX(int characterX) {
        this.characterX = characterX;
    }

    public int getCharacterY() {
        return characterY;
    }

    public void setCharacterY(int characterY) {
        this.characterY = characterY;
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int Health) {
        this.Health = Health;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Character{" + "Id=" + Id + ", Damage=" + Damage + ", Health=" + Health + ", price=" + price + '}';
    }
    
    
    
}
