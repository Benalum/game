package Areas.Bank;

import Player.Player;

public class Banker {
    private int storedGold;

    public Banker() {
        storedGold = 0;
    }

    public void depositGold(Player player, int amount) {
        if (amount > 0 && player.getGold() >= amount) {
            player.subtractGold(amount);
            storedGold += amount;
        }
    }

    public void withdrawGold(Player player, int amount) {
        if (amount > 0 && storedGold >= amount) {
            player.addGold(amount);
            storedGold -= amount;
        }
    }

    public int getStoredGold() {
        return storedGold;
    }
}