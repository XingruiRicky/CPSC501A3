import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import ttt.*;

public class Inspector {


    public void inspect(Object obj, boolean recursive) throws IllegalAccessException {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive, 0);
    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    }

    public void getClassName(Class obj) {
        Class currentClass = obj;
        System.out.println("className:  "+currentClass.getName());
    }

    public void getSuperClassName(Class obj) {
        Class currentClass = obj;
        if(currentClass.equals(Object.class)) return;
        System.out.println("superClassName:  "+currentClass.getSuperclass().getName());
        getSuperClassName(obj.getSuperclass());
    }

    public void getInterfaceNames(Class obj) {
        Class currentClass = obj;
        Class[] interfaceName = currentClass.getInterfaces();
        System.out.println("There are:  "+ interfaceName.length+" interfaces");
        for(int i=0;i<interfaceName.length;i++){
            System.out.println("InterfaceName:  "+ interfaceName[i]);
        }
    }

    public void getConstructors(Class obj) {
        Class currentClass = obj;
        Constructor[] cons =currentClass.getDeclaredConstructors();
        for (int i=0;i<cons.length;i++){

            String consName = cons[i].getName();
            Class[] consET = cons[i].getExceptionTypes();
            Class[] consPT = cons[i].getParameterTypes();
            int modifier = cons[i].getModifiers();

            System.out.println("ConstructorName:  "+ consName);
            for(int j=0;j<consET.length;j++){
                System.out.println("ExceptionTypeName:  "+ consET[j]);
            }
            for(int k=0;k<consPT.length;k++){
                System.out.println("ParameterTypeName:  "+ consPT[k]);
            }
            System.out.println("ModifierName:  "+ Modifier.toString(modifier));
            System.out.println("===========================");
        }
    }


    public void getMethods(Class obj) {
        Class currentClass = obj;
        Method[] methods =currentClass.getDeclaredMethods();
        for (int i=0;i<methods.length;i++){

            String methodName = methods[i].getName();
            Class[] methodET = methods[i].getExceptionTypes();
            Class[] methodPT = methods[i].getParameterTypes();
            Class<?> methodRT = methods[i].getReturnType();
            int modifier = methods[i].getModifiers();

            System.out.println("MethodName:  "+ methodName);
            for(int j=0;j< methodET.length;j++){
                System.out.println("ExceptionTypeName:  "+ methodET[j]);
            }
            for(int k=0;k<methodPT.length;k++){
                System.out.println("ParameterTypeName:  "+ methodPT[k]);
            }
            System.out.println("ReturnTypeName:  "+ methodRT);
            System.out.println("ModifierName:  "+ Modifier.toString(modifier));
            System.out.println("===========================");

        }
    }

    public void getFields(Class aClass,Object obj) throws IllegalAccessException {
        Class currentClass = aClass;
        Field[] fields =currentClass.getDeclaredFields();
        for (int i=0;i<fields.length;i++){

            String fieldName = fields[i].getName();
            Class<?> fieldType = fields[i].getType();
            int modifier = fields[i].getModifiers();
            fields[i].setAccessible(true);
            Object value = fields[i].get(obj);

            System.out.println("FieldName:  "+ fieldName);
            System.out.println("FieldType:  "+ fieldType);
            System.out.println("ModifierName:  "+ Modifier.toString(modifier));
            System.out.println("CurrentValue:  "+ value);
            System.out.println("===========================");
        }

    }

    public static void main(String[] args) throws Exception {
        BlockingPlayer bp = new BlockingPlayer("test",'X');
        Inspector ip = new Inspector();

        ip.getClassName(bp.getClass());
        System.out.println("===========================");
        ip.getSuperClassName(bp.getClass());
        System.out.println("===========================");
        ip.getInterfaceNames(bp.getClass());
        System.out.println("===========================");
        ip.getConstructors(bp.getClass());
        System.out.println("===========================");
        ip.getMethods(bp.getClass());
        System.out.println("===========================");
        ip.getFields(bp.getClass(),bp);
        System.out.println("===========================");

        System.out.println("Inspect finish");
    }
}