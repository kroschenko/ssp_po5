public class percussion extends musicInst
{
    String owner;

    public percussion(String _inst, String _owner)
    {
        super(_inst);
        owner = _owner;
    }

    @Override
    public void show()
    {
        System.out.println(owner+" plays on "+super.getInst());
    }
}