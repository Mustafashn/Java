
package GameWeapons;

public abstract class Weapon {
    private int Id;
    private int damage;
    private int cost;

    public Weapon(int Id, int damage, int cost) {
        this.Id = Id;
        this.damage = damage;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
}
