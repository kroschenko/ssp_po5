import java.util.*;
public class Lab5_2
{

    public static void main(String[] args)
    {
        Vector<musicInst> insts = new Vector<>();
        insts.add(new percussion("drums", "Maksim"));
        insts.add(new strings("guitar","Roma"));
        insts.add(new wind("trumpet", "Nikita"));

        for (musicInst i: insts)
        {
            i.show();
        }
    }

}
