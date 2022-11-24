import java.lang.reflect.Field;

public class ClassD {

    private ClassA val = new ClassA(17);
    private static ClassA val2;
    private int val3 = 34;
    private ClassA[] vallarray = new ClassA[10];

    //private final ClassA ss = new ClassA(22222);;

    public ClassD() {
    }

    public ClassD(int i) {
        val3 = i;
    }

    public String toString() {
        return "ClassD";
    }

    public int getVal3() {
        return val3;
    }


//    public static void main(String[] args){
//        ClassD d = new ClassD();
////        System.out.println(d.vallarray.getClass().toString());
////        System.out.println(d.vallarray.getClass().getSuperclass().toString());
////        System.out.println(d.vallarray.getClass().getSuperclass().isArray());
//        System.out.println(d.vallarray.getClass().isArray());
//        System.out.println(d.vallarray.getClass().getTypeName());
//        System.out.println(d.vallarray.getClass().getTypeName());
//        Field[] fields =d.getClass().getDeclaredFields();
//        for(int i=0;i<fields.length;i++){
//            System.out.println(fields[i]);
//        }
//        System.out.println(d.ss.getClass());
//
//    }
}
