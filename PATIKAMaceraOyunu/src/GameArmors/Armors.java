/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameArmors;

/**
 *
 * @author musta
 */
public abstract class Armors {
    private int money;
    private int dodge;

    public Armors(int money, int dodge) {
        this.money = money;
        this.dodge = dodge;
    }
    public int getMoney() {
        return this.money;
    }
    public int getDodge() {
        return this.dodge;
    }
}
