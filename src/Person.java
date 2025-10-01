public class Person {
    private String name;
    private int id;
    Person(String name, int id) {
        this.name=name;
        for(int i=0;i<=10;i++) {
            this.id = id;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
class Student extends Person {
    private String department;
    Student(String name, int id, String department) {
        super(name,id);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    void borrowBook(Book b) {
        if(b.isAvailable()) {
            System.out.println("\t\t"+getName()+ " from "+ getDepartment() +" borrowed "+b.getTitle());
            b.setAvailable(false);
        }
        else{  System.out.println("\t\tBook not available"); }
    }
}
class Staff extends Person {
    Staff(String name, int id) {
        super(name, id);
    }
    void manageBook(Book b, boolean add) {
        if (add) {
            System.out.println("\t"+getName()+ " added : "+b.getTitle());
            b.setAvailable(true);
        } else {
            b.setAvailable(false);
            System.out.println("\t"+getName()+ " removed "+b.getTitle());
        }
    }
}
