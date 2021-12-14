public class Zadanie2 {
   public static void main(String[] args) {
   GardenTree[] trees1 = new GardenTree[3];
    trees1[0] = new PearTree(1, 500, "pear tree", 3);
    trees1[1] = new AppleTree(2, 600, "apple tree", 7);
    trees1[2] = new CherryTree(3, 300, "cherry tree", 4);
	for (GardenTree i: trees1)
       i.show();
    }
}
abstract class GardenTree {
    private int number;
    private int fruiting;
    private String view;
    private int age;
    public GardenTree (int _number, int _fruiting, String _view, int _age) {
        number = _number;
	fruiting = _fruiting;
        view = _view;
        age = _age;
    }
    public int getNumber() {
        return number;
    }
	public int getFruiting() {
        return fruiting;
    }
    public String getView() {
        return view;
    }
    public int getAge() {
        return age;
    }

    public abstract void show();
}

class AppleTree extends GardenTree {
    private String fruit = "apples";
    public AppleTree (int _number, int _fruiting, String _view, int _age) {
        super(_number, _fruiting, _view, _age);
    }
    public void show () {
        System.out.print("The number this tree is " + super.getNumber() + ". This is " + super.getView() +
                " and it is " + super.getAge() + " years old. It bears fruit up to " + super.getFruiting() + " kilograms " + fruit + " per year. ");
				if (super.getAge() < 5) System.out.println("It can be transplanted");
    }
}

class PearTree extends GardenTree {
    private String fruit = "pears";
    public PearTree  (int _number, int _fruiting, String _view, int _age) {
        super(_number, _fruiting, _view, _age);
    }
    public void show () {
        System.out.print("The number this tree is " + super.getNumber() + ". This is " + super.getView() +
                " and it is " + super.getAge() + " years old. It bears fruit up to " + super.getFruiting() + " kilograms " + fruit + " per year. ");
				if (super.getAge() < 5) System.out.println("It can be transplanted");
    }
}

class CherryTree extends GardenTree {
    private String fruit = "cherries";
    public CherryTree  (int _number, int _fruiting, String _view, int _age) {
        super(_number, _fruiting, _view, _age);
    }
    public void show () {
        System.out.print("The number this tree is " + super.getNumber() + ". This is" + super.getView() +
                " and it is " + super.getAge() + " years old. It bears fruit up to " + super.getFruiting() + " kilograms " + fruit + " per year. ");
				if (super.getAge() < 5) System.out.println("It can be transplanted");
    }
}
