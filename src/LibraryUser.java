abstract public class LibraryUser {
    private String name;
    LibraryUser(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }

    abstract void accessLibrary();
}
class StudentUser extends LibraryUser {
    StudentUser(String name){
        super(name);
    }
    @Override
    void accessLibrary() {
        System.out.println("\t"+getName()+" borrows books");
    }
}
class StaffUser extends LibraryUser {
    StaffUser(String name) {
        super(name);
    }
    @Override
    void accessLibrary() {
        System.out.println("\t"+getName()+" manages library");
    }
}

