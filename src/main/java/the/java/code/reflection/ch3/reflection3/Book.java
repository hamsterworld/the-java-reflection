package the.java.code.reflection.ch3.reflection3;

public class Book {

    public static String A = "A";

    private String B = "B";

    public void c(){
        System.out.println("c");
    }

    public int sum(int left,int right){
        return left+right;
    }

    public Book(String b) {
        B = b;
    }

    public Book() {
    }
}
