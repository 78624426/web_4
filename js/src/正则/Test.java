package 正则;

public class Test {
    public static void main(String[] args) {
        String reg="[abc]{2,}d";
        String s="acbd";
        System.out.println(s.matches(reg));
    }
}
