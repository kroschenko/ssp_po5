import java.util.ArrayList;

class Indent{
    int otstyp;
    String line;

    public Indent(int otstyp, String line){
        this.otstyp = otstyp;
        this.line = line;
    }

    public void setLine(String line){
        this.line = line;
    }

    public void setOtstyp(int otstyp){
        this.otstyp = otstyp;
    }

    public void show(){
        for(int i=0; i<otstyp; i++)
            System.out.print(" ");
        System.out.println(line);
    }

}


class Page{
    Indent indent = null;
    ArrayList<String> lines;

    public Page(){
        lines = new ArrayList<String>();
    }

    public void setIndent(int otstyp, String line){
        indent = new Indent(otstyp, line);
    }

    public void addLine(String line){
        lines.add(line);
    }

    public void show(){
        if(indent==null)
            System.out.println("Ошибка - у страницы нет абзаца.");
        else{
            indent.show();
            for (String line : lines) System.out.println(line);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Page page = new Page();

        page.show();

        page.setIndent(3, "Это первая строка этого");
        page.addLine("текста,  а это продолжение");
        page.addLine("этого текста.");
        System.out.println();
        page.show();
    }
}
