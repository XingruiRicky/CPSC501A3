package ttt;

public class SomeObject {

    private int pi = 0;
    public static String pss = "hello";


    public SomeObject(int pi) {
        this.pi = pi;
    }

    public static String getPss() {
        return pss;
    }

    public static void setPss(String pss) {
        SomeObject.pss = pss;
    }

//    @Override
//    public String toString() {
//        return "SomeObject{" +
//                "pi=" + pi +
//                '}';
//    }

    public int getPi() {
        return pi;
    }

    public void setPi(int pi) {
        this.pi = pi;
    }
}
