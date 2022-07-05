public class director extends engineer
{
    String name;
    int age;
    @Override
    public void show()
    {
        System.out.println(name+" "+age+" years\n");
    }

    public director(String _name, int _age, String _salaryDay)
    {
        super(_salaryDay);
        name = _name;
        age = _age;
    }
}