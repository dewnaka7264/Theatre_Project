public class Ticket{
    private int row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    public int getRow(){
        return row;
    }
    public void setRow(int row){
        this.row = row;
    }
    public int getSeat(){
        return seat;
    }
    public void setSeat(int seat){
        this.seat = seat;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person){
        this.person = person;
    }
    public void print(){
        System.out.println(person.getName());
        System.out.println(person.getSurname());
        System.out.println(person.getEmail());
        System.out.println(row);
        System.out.println(seat);
        System.out.println(price);
    }

}
//https://www.w3schools.com/java/java_modifiers.asp