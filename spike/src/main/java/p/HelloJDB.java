package p;

public class HelloJDB {
    public static void main(String[] args) {
        int i = 5;
        int j = 6;

        HelloJDB h = new HelloJDB();
        System.out.println(h);
        X x=new X();
        System.out.println(x);;
        //x.add(i,j);
        System.out.println(Class.class);
        System.out.println(x);
    }

    public static int add(int augend, int addend) {
        int sum = augend + addend;
        return sum;
    }

    private int a=3;
    private static int static_b=4;
}
