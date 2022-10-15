package GameMonsters;

public abstract class Monster {
    private int Id;
    private int damage;
    private int health;
    private int droppedMoney;

    public Monster(int Id, int damage, int health, int droppedMoney) {
        this.Id = Id;
        this.damage = damage;
        this.health = health;
        this.droppedMoney = droppedMoney;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDroppedMoney() {
        return droppedMoney;
    }

    public void setDroppedMoney(int droppedMoney) {
        this.droppedMoney = droppedMoney;
    }
    
}
