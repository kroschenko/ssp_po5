class Person {
    protected String name;
    protected String surname;

    public Person(String _name, String _surname) {
        name = _name;
        surname = _surname;
    }
}
class Driver extends Person{

    private Race race;
    private HashMap<Car.States, Mark> results = new HashMap<Car.States, Mark>();

    public Driver (String _name, String _surname) {
        super(_name, _surname);
    }
...
class dispatcher extends Person{

    private Car.States state;
    public dispatcher (String _name, String _surname, Car _car) {
        super(_name, _surname);
        state = _car.getState();
    }
... 
