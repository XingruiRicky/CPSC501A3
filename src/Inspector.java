import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Inspector {


    public void inspect(Object obj, boolean recursive) throws IllegalAccessException {
        Class objClass = obj.getClass();
        getClassName(objClass);
        getSuperClassName(objClass);
        getInterfaceNames(objClass);
        getConstructors(objClass);
        getMethods(objClass);
        getFields(objClass);
    }

    public void getClassName(Class obj) {
        Class currentClass = obj.getClass();
        System.out.println("className:  "+currentClass.getName());
    }

    public void getSuperClassName(Class obj) {
        Class currentClass = obj.getClass();
        while(currentClass!= Object.class){
            System.out.println("superClassName:  "+currentClass.getSuperclass().getName());
            getSuperClassName(currentClass.getSuperclass());
        }
    }

    public void getInterfaceNames(Class obj) {
        Class currentClass = obj.getClass();
        Class[] interfaceName = currentClass.getInterfaces();
        System.out.println("InterfaceName:  "+ interfaceName);
    }

    public void getConstructors(Class obj) {
        Class currentClass = obj.getClass();
        Constructor[] cons =currentClass.getDeclaredConstructors();
        for (int i=0;i<cons.length;i++){

            String consName = cons[i].getName();
            Class[] consET = cons[i].getExceptionTypes();
            Class[] consPT = cons[i].getParameterTypes();
            String modifier = convertModifier(cons[i].getModifiers());

            System.out.println("ConstructorName:  "+ consName);
            System.out.println("ExceptionTypeName:  "+ consET);
            System.out.println("ParameterTypeName:  "+ consPT);
            System.out.println("ModifierName:  "+ modifier);
        }
    }


    public void getMethods(Class obj) {
        Class currentClass = obj.getClass();
        Method[] methods =currentClass.getDeclaredMethods();
        for (int i=0;i<methods.length;i++){

            String methodName = methods[i].getName();
            Class[] methodET = methods[i].getExceptionTypes();
            Class[] methodPT = methods[i].getParameterTypes();
            Class<?> methodRT = methods[i].getReturnType();
            String modifier = convertModifier(methods[i].getModifiers());

            System.out.println("ConstructorName:  "+ methodName);
            System.out.println("ExceptionTypeName:  "+ methodET);
            System.out.println("ParameterTypeName:  "+ methodPT);
            System.out.println("ParameterTypeName:  "+ methodRT);
            System.out.println("ModifierName:  "+ modifier);
        }
    }

    public void getFields(Class obj) throws IllegalAccessException {
        Class currentClass = obj.getClass();
        Field[] fields =currentClass.getDeclaredFields();
        for (int i=0;i<fields.length;i++){

            String fieldName = fields[i].getName();
            Class<?> fieldType = fields[i].getType();
            String modifier = convertModifier(fields[i].getModifiers());
            Object value = fields[i].get(obj);

            System.out.println("ConstructorName:  "+ fieldName);
            System.out.println("TypeName:  "+ fieldType);
            System.out.println("ModifierName:  "+ modifier);
            System.out.println("CurrentValue:  "+ value);

        }

    }


    public static void main(String[] args) {

        System.out.println("Hello world!");
    }


    public String convertModifier(int mod){
        if(mod==1){
            return "public";
        }
        else if (mod == 2){
            return "private";
        }
        else if (mod == 4){
            return "protected";
        }
        else if (mod == 8){
            return "static";
        }
        else if (mod == 16){
            return "final";
        }
        else if (mod == 32){
            return "synchronized";
        }
        else if (mod == 64){
            return "volatile";
        }
        else if (mod == 128){
            return "transient";
        }
        else if (mod == 256){
            return "native";
        }
        else if (mod == 512){
            return "interface";
        }
        else if (mod == 1024){
            return "abstract";
        }
        else if (mod == 2048){
            return "strict";
        }
        return "No modifier match";
    }
}