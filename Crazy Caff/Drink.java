public class Drink
{
    private String drinkName;
    private String size;
    private double caffeineAmount;
    private double timeConsumed;


    public Drink(String drinkName, String size, double caffeineAmount, double timeConsumed)
    {
        this.drinkName = drinkName;
        this.size = size;
        this.caffeineAmount = caffeineAmount;
        this.timeConsumed = timeConsumed;
    }


    public String getDrinkName()
    {
        return drinkName;
    }


    public String getSize()
    {
        return size;
    }


    public double getCaffeineAmount()
    {
        return caffeineAmount;
    }


    public double getTimeConsumed()
    {
        return timeConsumed;
    }
}