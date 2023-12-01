public class Person {
    private String name;//is declared as private to ensure that it can only be accessed and modified through the getter and setter methods.
    private String surname;
    private String email;

    public Person(String name, String surname, String email) {
        this.name = name; //name variable(defined in this Person class) = name(within this method)
        this.surname = surname;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
//https://www.w3schools.com/java/java_constructors.asp