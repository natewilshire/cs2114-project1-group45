public class User
{
    private String sex;
    private double height;
    private double weight;


    public User(String sex, double height, double weight)
    {
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }


    public String getSex()
    {
        return sex;
    }


    public double getHeight()
    {
        return height;
    }


    public double getWeight()
    {
        return weight;
    }
}