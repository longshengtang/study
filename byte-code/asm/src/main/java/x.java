public class x {
    private static int d=3 ;
    private static int  z=4;
    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        d=5;
        return (a + b) * c/d/z;
    }

    public static void s(Object o) {
        d=8;
        System.out.println("o----");
    }
    public static void s(int i) {
        z=5;
        System.out.println("int----");
    }

    public static void main(String[] args) {
//        Object a="4";
//        s(a);
//        s((int)a);
        x v=new x();
        x.d=5;
        x.s(3);
        x.s("fdsa");
        while (true);
    }
}
