import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Account{

    class Location{
        private int id;
        private String name;
        private String address;

        public Location(int id, String name, String address){
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public void print(){
            System.out.println("id: "+id+"; название: "+name+"; адрес: "+address);
        }

        public Location clone(){
            return new Location(id, name, address);
        }
    }

    class Operation{
        private int type;
        private LocalDateTime time;
        private double sum;
        private Location location;

        public Operation(int type, double sum, Location location){
            this.type = type;
            time = LocalDateTime.now();
            this.sum=sum;
            this.location = location;
        }

        public void print(){
            System.out.print("Тип операции: ");
            if(type==0)
                System.out.print("поступление");
            else if(type==1)
                System.out.print("снятие");
            else if(type==2)
                System.out.print("платёж");

            System.out.print("; время: "+time.format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"))+"; сумма: "+sum);

            if(type==0)
                System.out.print("; источник: ");
            else if(type==1)
                System.out.print("; место операции: ");
            else if(type==2)
                System.out.print("; получатель: ");

            System.out.println(location.name);
        }
    }

    String accountId;
    double money = 0;
    private ArrayList<Location> locations;
    private ArrayList<Operation> operations;

    public Account(String accountId){
        this.accountId = accountId;

        locations = new ArrayList<Location>();
        operations = new ArrayList<Operation>();

        locations.add(new Location(0,"ООО Пищевые Продукты", "ул. Советская, 54"));
        locations.add(new Location(1,"Банкомат АТМ Беларусбанк", "ул. Луцкая, 12"));
        locations.add(new Location(2,"Оператор МТС", "ул. Стафеева, 1, к.1"));
    }

    public void printLocations(){
        for(int i=0; i<locations.size(); i++)
            locations.get(i).print();
    }

    public void printOperations(){
        for(int i=0; i<operations.size(); i++)
            operations.get(i).print();
    }

    public boolean addOperation(int type, int idLocation, double sum){
        if(sum<=0)
            return false;

        if((type==1||type==2)&&sum>money)
            return false;

        Location location = null;
        for(int i=0; i<locations.size(); i++)
            if(locations.get(i).id==idLocation)
            {
                location = locations.get(i).clone();
                break;
            }

        if(location==null)
            return false;

        operations.add(new Operation(type, sum, location));

        if(type==0)
            money+=sum;
        else
            money-=sum;

        return true;
    }

    public void print(){
        System.out.println("Остаток на счёте "+accountId+": "+money);
    }
}

public class Main {

    public static void main(String[] args) {
        Account account = new Account("000259325023A2");

        account.printLocations();
        System.out.println();

        account.addOperation(0, 0, 25);
        account.addOperation(1, 1, 10.2);
        account.addOperation(2, 2, 5);

        account.printOperations();
        System.out.println();
        account.print();
    }
}
