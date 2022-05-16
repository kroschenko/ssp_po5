
import java.util.Scanner;

public class _StudentBook {
    public static Scanner ob = new Scanner(System.in);
    public info info;
    public String name;

    public _StudentBook(){
        System.out.print("Enter the name of student: ");
        setNameStudent(ob.next());
        info = new info();
    }

    public String setNameStudent(){
        return name;
    }

    public void setNameStudent(String name){
        this.name = name;
    }

    public class info {
        int pr,st,sq;
    
        public info(){  
            System.out.print("Session num: ");
            setPr(ob.nextInt());    
            System.out.print("Remaining credits: ");
            setSt(ob.nextInt());
            System.out.print("Remaining exams: ");
            setSq(ob.nextInt());    
        }
        
        public int getPr(){
            return pr;
        }
        
        public void setPr(int pr){
            this.pr=pr;
        }

        public int getSt(){
            return st;
        }
        
        public void setSt(int st){
            this.st=st;
        }
        
        public int getSq(){
            return sq;
        }
        
        public void setSq(int sq){
            this.sq = sq;
        }
        
        public void print(){
            System.out.print("The student " + setNameStudent() + " passed " +
            + getPr() + " session " + getSt() + " credits and " + getSq() + " exams");
        }
    }
    static public void main(String[]args){
        _StudentBook ct = new _StudentBook();
        ct.info.print();
    }

}
