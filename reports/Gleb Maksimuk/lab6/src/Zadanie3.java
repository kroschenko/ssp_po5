import java.util.ArrayList;
import java.util.Stack;
public class Main {
public static void main(String[] args) {
Pizzeria pizzeria = new Pizzeria();
AddCommand add = new AddCommand(pizzeria);
RemoveCommand remove = new RemoveCommand(pizzeria);
pizzeria.executeCommand(add, Dish.soup);
pizzeria.executeCommand(add, Dish.pizza);
pizzeria.executeCommand(add, Dish.paste);
pizzeria.printOrder();
pizzeria.executeCommand(remove, Dish.soup);
pizzeria.printOrder();
pizzeria.undo();
pizzeria.printOrder();
}
}
class Pizzeria {
private ArrayList<Dish> order;
private CommandHistory history;
Pizzeria() {
order = new ArrayList<Dish>();
history = new CommandHistory();
}
void add(Dish dish) {
this.order.add(dish);
}
void remove(Dish dish) {
int index = this.order.indexOf(dish);
this.order.remove(index);
}
void undo() {
if (history.isEmpty()) return;
Command command = history.pop();
if (command != null) {
command.undo();
}
}
void restore(ArrayList<Dish> order) {
this.order = new ArrayList<Dish>(order);
}
void executeCommand(Command command, Dish dish) {
command.execute(dish);
history.push(command);
}
Snapshot createSnapshot() {
Snapshot snapshot = new Snapshot(this, order);
return snapshot;
}
void printOrder() {
System.out.println("Your order: ");
for (Dish dish: order) {
switch (dish) {
case soup:
System.out.println("Soup");
break;
case paste:
System.out.println("Paste");
break;
case pizza:
System.out.println("Pizza");
break;
case pancakes:
System.out.println("Pancakes");
break;
case sushi:
System.out.println("Sushi");
break;
}
}
}
}
enum Dish {
soup,
paste,
pizza,
pancakes,
sushi,
}
class Snapshot {
private ArrayList<Dish> order;
private Pizzeria pizzeria;
Snapshot(Pizzeria pizzeria, ArrayList<Dish> order) {
this.order = new ArrayList<Dish>(order);
this.pizzeria = pizzeria;
}
public void restore() {
pizzeria.restore(order);
}
}
abstract class Command {
private Snapshot backup;
public Pizzeria pizzeria;
Command(Pizzeria pizzeria) {
this.pizzeria = pizzeria;
}
void makeBackup(){
this.backup = pizzeria.createSnapshot();
}
void undo() {
if (backup != null) {
backup.restore();
}
}
public abstract void execute(Dish dish);
}
class AddCommand extends Command {
public AddCommand(Pizzeria pizzeria) {
super(pizzeria);
}
@Override
public void execute(Dish dish) {
pizzeria.add(dish);
}
}
class RemoveCommand extends Command {
public RemoveCommand(Pizzeria pizzeria) {
super(pizzeria);
}
@Override
public void execute(Dish dish) {
makeBackup();
pizzeria.remove(dish);
}
}
class CommandHistory {
private Stack<Command> history = new Stack<Command>();
public void push(Command c) {
history.push(c);
}
public Command pop() {
return history.pop();
}
public boolean isEmpty() {
return history.isEmpty();
}
}
