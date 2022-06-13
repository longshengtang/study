package p;

public class X {
    public static void main(String[] args) {
        int i = 5;
        int j = 6;
        int sum = add(i, j);
        System.out.println(sum);

        sum = 0;
        for (i = 0; i < 100; i++)
            sum += i;

        System.out.println(sum);
    }

    public static int add(int augend, int addend) {
        int sum = augend + addend;
        return sum;
    }

    private int a=3;
}
