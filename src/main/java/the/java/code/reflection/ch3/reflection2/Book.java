package the.java.code.reflection.ch3.reflection2;

@MyAnnotation(name = "inOk",number = 10)
public class Book {

    private String a;
    private static String B = "Book";
    private static final String C = "Book";
    public String d = "d";
    protected String e = "e";
    public Book(){

    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }
    private void f(){
        System.out.println("f");
    }
    public void g(){
        System.out.println("g");
    }
    public int h(){
        return 100;
    }



}
