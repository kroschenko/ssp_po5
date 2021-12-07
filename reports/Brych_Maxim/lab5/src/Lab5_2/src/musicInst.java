abstract class musicInst
{
    private String instrument;

    public musicInst(String _inst)
    {
        instrument = _inst;
    }

    public String getInst()
    {
        return instrument;
    }

    public abstract void show();
}
