import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import ttt.*;

public class Inspector {

    public void inspect(Object obj, boolean recursive) throws IllegalAccessException {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive,4);
    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) throws IllegalAccessException {
        String indent = "";
        for(int i=0;i<depth;i++){
            indent+=" ";
        }
        getClassName(c,obj,recursive,indent);
        getSuperClassName(c,obj,recursive,indent);
        getInterfaceNames(c,obj,recursive,indent);
        getConstructors(c,obj,recursive,indent);
        getMethods(c,obj,recursive,indent);
        getFields(c,obj,recursive,indent);
        System.out.println("=============Inspect finish==============");
    }

    public void getClassName(Class c, Object obj, boolean recursive, String depth) {
        System.out.println("CLASS");
        System.out.println("Class:  "+c.getName());
    }

    public void getSuperClassName(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException {
        if(c.isInterface()) return;
        if(c.getSuperclass().equals(Object.class)){
            System.out.println("SuperClass: NONE");
            return;
        }
        System.out.println("SUPERCLASS -> Recursively Inspect");
        System.out.println("SuperClass: "+c.getSuperclass().getName());
//        System.out.print(depth);
        inspectClass(c.getSuperclass(),obj,true,0);
    }

    public void getInterfaceNames(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException {
        Class[] interfaceName = c.getInterfaces();
        System.out.println("INTERFACES:(" +c+ ")");
        if(interfaceName.length==0){
            System.out.println("Interfaces-> NONE");
        }
        for(int i=0;i<interfaceName.length;i++){
            System.out.println("Interfaces-> ");
            inspectClass(interfaceName[i],obj,recursive,0);
        }
    }

    public void getConstructors(Class c, Object obj, boolean recursive, String depth) {
        Constructor[] cons =c.getDeclaredConstructors();
        System.out.println("CONSTRUCTORS( "+c+" )");
        System.out.print("Constructors->");

        if(cons.length==0){
            System.out.println("NONE");
            return;
        }
        for (int i=0;i<cons.length;i++){
            System.out.println("\n"+"Constructors:  ");
            String consName = cons[i].getName();
            Class[] consET = cons[i].getExceptionTypes();
            Class[] consPT = cons[i].getParameterTypes();
            int modifier = cons[i].getModifiers();

            System.out.println("Name:  "+ consName);
            if(consET.length==0){
                System.out.println("Exceptions-> None ");
            }
            else{
                for(int j=0;j<consET.length;j++){
                    System.out.println("Exceptions:  "+ consET[j]);
                }
            }
            System.out.println("Parameter types: ");
            for(int k=0;k<consPT.length;k++){
                System.out.println(consPT[k].toString());
            }
            System.out.println("Modifiers:  "+ Modifier.toString(modifier));
            System.out.println("===========================");
        }
    }


    public void getMethods(Class c, Object obj, boolean recursive, String depth) {
        Method[] methods =c.getDeclaredMethods();
        System.out.println("METHODS( "+c+" )");
        System.out.print("Methods->");
        if(methods.length==0){
            System.out.println("None");
            return;
        }
        for (int i=0;i<methods.length;i++){
            System.out.println("METHOD");
            String methodName = methods[i].getName();
            Class[] methodET = methods[i].getExceptionTypes();
            Class[] methodPT = methods[i].getParameterTypes();
            Class<?> methodRT = methods[i].getReturnType();
            int modifier = methods[i].getModifiers();


            System.out.println("Name:  "+ methodName);
            System.out.print("Exceptions->");

            if(methodPT.length==0){
                System.out.println("NONE");
            }
            else{
                for(int j=0;j< methodET.length;j++){
                    System.out.println('\n'+methodET[j].toString());
                }
            }

            System.out.println("Parameter types-> ");
            if(methodPT.length==0){
                System.out.println("NONE");
            }
            else{
                for(int k=0;k<methodPT.length;k++){
                    System.out.println(methodPT[k].toString());
                }
            }

            System.out.println("Return type:  "+ methodRT);
            System.out.println("Modifiers:  "+ Modifier.toString(modifier));
            System.out.println("===========================");
        }
    }

    public void getFields(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException {
        Field[] fields =c.getDeclaredFields();
        System.out.println("FIELDS( "+c+" )");
        System.out.print("Fields->");
        if(fields.length==0){
            System.out.println("None");
            return;
        }
        for (int i=0;i<fields.length;i++){

            String fieldName = fields[i].getName();
            Class<?> fieldType = fields[i].getType();
            int modifier = fields[i].getModifiers();
            fields[i].setAccessible(true);
            Object value = fields[i].get(obj);
// Add array type handling here

            System.out.println("\n"+"Name:  "+ fieldName);
            System.out.println("Type:  "+ fieldType);
            System.out.println("Modifiers:  "+ Modifier.toString(modifier));
            if(!fieldType.isPrimitive() && (recursive==false)){
                System.out.println("Value:  "+ value);
            }
            else if(!fieldType.isPrimitive()){
                inspectClass(fields[i].getClass(),fields[i],recursive,0);
            }
            else if(fieldType.isPrimitive()){
                System.out.println("Value:  "+ value);
            }
            else{
                System.out.println("Error in getFields");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BlockingPlayer bp = new BlockingPlayer("test",'X');
        Inspector ip = new Inspector();
        ip.inspect(bp,true);
    }
}