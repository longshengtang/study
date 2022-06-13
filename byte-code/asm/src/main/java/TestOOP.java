public class TestOOP {
    private static int d=3,z=4;
    private static int a=5;
    private int v=6;
    public int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c/d/z;
    }

    public static void s(Object o) {
        System.out.println("o----");
    }
    public static void s(int i) {
        System.out.println("int----");
    }

    public static void main(String[] args) {
//        Object a="4";
//        s(a);
//        s((int)a);
        TestOOP v=new TestOOP();
        System.out.println("v = " + v);
        System.out.println("v = " + v);
    }
}
