import java.util.*;
public class Main {
    private static List<Book> books=new ArrayList<>();
    private static List<Student> learners=new ArrayList<>();
    private static List<Staff> workers=new ArrayList<>();
    public static void main(String[] args) {
          System.out.println("_____________Library Management System_____________");
          books.add(new Book("Java Development", "James Gosling"));
          books.add(new Book("OOP concepts", "Alan Kay"));
          while(true){
          System.out.println("\n\tChoose your role : ");
          System.out.println("\t    1. Student");
          System.out.println("\t    2. Staff");
          System.out.print("\t\tRole : ");
          Scanner sc=new Scanner(System.in);
          int role=sc.nextInt();
          sc.nextLine();
          switch (role){
              case 1:
                  System.out.print("\t\tEnter your name : ");
                  String name=sc.nextLine();
                  StudentUser s=new StudentUser(name);
                  if(findStudent(name)==null) {
                      System.out.print("\t\tWhat's your department : ");
                      String dep=sc.nextLine();
                      Student student=new Student(name,1,dep);
                      learners.add(student);
                      s.accessLibrary();
                      System.out.println("\t"+name+" Welcome to Library Management System");
                      showBooks();
                  }
                  else {
                      System.out.println("\t" + name + " Welcome back to Library Management System");
                      showBooks();
                      s.accessLibrary();
                  }
                  System.out.print("\t\tYou can borrow books (yes or no to exit) : ");
                  String res=sc.nextLine().toLowerCase();
                  if(res.equalsIgnoreCase("no")) {
                      System.out.print("\t\tGoodbye -Exit");
                      break;
                  }
                  else if (res.equalsIgnoreCase("yes")) {
                        System.out.print("\t\tEnter book title : ");
                        String tit=sc.nextLine().toLowerCase();
                        Book book=findBook(tit);
                        Student st=findStudent(name);
                        if(book!=null) {
                            st.borrowBook(book);
                        }
                        else {
                            System.out.println("\t\tBook not Found in Library");
                        }

                      break;
                  }
                  else {
                      System.out.println("Invalid input");
                      break;
                  }
              case 2:
                  System.out.print("\t\tEnter your names : ");
                  String nam=sc.nextLine();
                  StaffUser s1=new StaffUser(nam);
                  if(findStaff(nam)==null) {
                      Staff staff=new Staff(nam,1);
                      workers.add(staff);
                      s1.accessLibrary();
                      System.out.println("\t"+nam+" Welcome to Library Management System");
                      showBooks();
                  }
                  else {
                      System.out.println("\t" + nam + " Welcome back to Library Management System");
                      showBooks();
                      s1.accessLibrary();
                  }
                  System.out.print("\t\tYou can manage books (yes or no to exit) : ");
                  String ans=sc.nextLine().toLowerCase();
                  if(ans.equals("no")) {
                      System.out.print("\t\tGoodbye -Exit");
                      break;
                  }
                  else if (ans.equals("yes")) {
                      System.out.print("\t\tEnter book title : ");
                      String title=sc.nextLine().toLowerCase();
                      System.out.print("\t\tEnter book author : ");
                      String author=sc.nextLine();
                      System.out.print("\t\tRemove(e) or Add(a) : ");
                      String option = sc.nextLine().toLowerCase();
                      Book book=findBook(title);
                      Staff worker=findStaff(nam);
                      if(option.equalsIgnoreCase("e")) {
                          if(book!=null) {
                              worker.manageBook(book,false);
                              books.remove(book);
                          }
                          else { System.out.println("\t\tBook Not Found to Remove");
                          }
                          break;
                      }
                      else if(option.equalsIgnoreCase("a")) {
                          Book b = null;
                          if (book == null) {
                              b = new Book(title, author);
                              books.add(b);
                              worker.manageBook(b, true);
                          }
                          else {
                              System.out.println("\t\tBook already in our library");
                          }

                      }
                      break;
                  }
                  else {
                      System.out.println("Invalid input");
                      break;
                  }
              default:
                  System.out.println("Invalid input");
                  break;
            }
          }
    }
    private static Book findBook(String title) {
        for(Book b: books) {
            if(b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }
    private static Student findStudent(String name) {
        for(Student l: learners) {
            if(l.getName().equalsIgnoreCase(name)) {
                return l;
            }
        }
        return null;
    }
    private static Staff findStaff(String name) {
        for(Staff w: workers) {
            if(w.getName().equalsIgnoreCase(name)) {
                return w;
            }
        }
        return null;
    }
    private static void showBooks() {
        System.out.println("\tAvailable books");
        for(Book b: books) {
            System.out.println("\t- "+b.getTitle()+" by "+b.getAuthor()+
                    (b.isAvailable()?" [Available] " : " [Not Available] "));
        }
    }
}