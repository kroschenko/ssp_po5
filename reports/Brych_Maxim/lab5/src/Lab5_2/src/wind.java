public class wind extends musicInst
{
    String owner;
    public wind(String _inst, String _owner)
    {
        super(_inst);
        owner = _owner;
    }

    @Override
    public void show()
    {
        System.out.println(owner+" plays on "+super.getInst()+" for 3 years");
    }
}