/*
Recursion Assignment
Name: Jadiha Aruleswaran
Date: December 3rd 2021
 */
package coins;

public enum Coins { //values in number of pennies
    TOONIES(200), 
    LOONIES(100),
    QUARTERS(25),
    DIMES(10),
    NICKELS(5);

    private int coin_value;
 
    Coins(int coin_value) {
        this.coin_value = coin_value;
    }

    public int minChange(double sum, Coins maxDenomination) {
        int num_of_pennies = (int) Math.round(sum * 100); //multiply by 100 to avoid floating point errors
        if (num_of_pennies == 0) { // base case
            return 0;
        } else if (maxDenomination == NICKELS) {
            return (num_of_pennies / 5); // 2nd base case, denominator represents value of a nickel
        } else {
            int coin_max_value = num_of_pennies / maxDenomination.coin_value; // # of coins needed at max value
            int change_remainder = (num_of_pennies - (coin_max_value) * maxDenomination.coin_value); // remainder after subtracting the respective coin value
            return coin_max_value + minChange((double) change_remainder / 100, (Coins.values()[maxDenomination.ordinal() + 1])); // recursive statement, moves to the next smallest denomination through index
        }

    }

    public static void main(String[] args) {
        System.out.println(Coins.TOONIES.minChange(5.10, Coins.TOONIES));
        System.out.println(Coins.TOONIES.minChange(5.10, Coins.LOONIES));
        System.out.println(Coins.TOONIES.minChange(5.10, Coins.QUARTERS));
        System.out.println(Coins.TOONIES.minChange(5.10, Coins.DIMES));
        System.out.println(Coins.TOONIES.minChange(5.10, Coins.NICKELS));
    }

}
