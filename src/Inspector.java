import java.lang.reflect.*;

import ttt.*;

public class Inspector {

    public void inspect(Object obj, boolean recursive) throws IllegalAccessException {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive,0);
    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) throws IllegalAccessException {
        String indent = "";
        for(int i=0;i<depth;i++){
            indent+=" ";
        }
        if(c.isArray()){
            Object[] objs = (Object[]) obj;
            for(int i=0;i< objs.length;i++){
                if(objs[i]!=null){
                    inspectClass(objs[i].getClass(),objs[i],recursive,depth+4);
                }
            }
        }
        getClassName(c,obj,recursive,indent);
        getSuperClassName(c,obj,recursive,indent);
        getInterfaceNames(c,obj,recursive,indent);
        getConstructors(c,obj,recursive,indent);
        getMethods(c,obj,recursive,indent);
        getFields(c,obj,recursive,indent);
    }

    public void getClassName(Class c, Object obj, boolean recursive, String depth) {
        System.out.println(depth+"CLASS");
        System.out.println(depth+"Class:  "+c.getName());
    }

    public void getSuperClassName(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException {
        if(c.isInterface()) return;
        if(c.equals(Object.class)){
            System.out.println(depth+"SuperClass: NONE");
            return;
        }
        System.out.println(depth+"SUPERCLASS -> Recursively Inspect");
        System.out.println(depth+"SuperClass: "+c.getSuperclass().getName());
//        System.out.print(depth);
        inspectClass(c.getSuperclass(),obj,true,depth.length()+4);
    }

    public void getInterfaceNames(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException {
        Class[] interfaceName = c.getInterfaces();
        System.out.println(depth+"INTERFACES:(" +c+ ")");
        if(interfaceName.length==0){
            System.out.println(depth+"Interfaces-> NONE");
            return;
        }
        for(int i=0;i<interfaceName.length;i++){
            System.out.println(depth+"Interfaces-> ");
            System.out.println(depth+"INTERFACE -> Recursively Inspect");
            System.out.println(depth+interfaceName[i].toString());
            inspectClass(interfaceName[i],obj,recursive,depth.length()+4);
        }
    }

    public void getConstructors(Class c, Object obj, boolean recursive, String depth) {
        Constructor[] cons =c.getDeclaredConstructors();
        System.out.println(depth+"CONSTRUCTORS( "+c+" )");
        System.out.print(depth+"Constructors->");

        if(cons.length==0){
            System.out.println("NONE");
            return;
        }
        System.out.println();
        for (int i=0;i<cons.length;i++){
            System.out.println(depth+" "+"Constructors:  ");
            String consName = cons[i].getName();
            Class[] consET = cons[i].getExceptionTypes();
            Class[] consPT = cons[i].getParameterTypes();
            int modifier = cons[i].getModifiers();

            System.out.println(depth+" "+" "+"Name:  "+ consName);
            if(consET.length==0){
                System.out.println(depth+" "+" "+"Exceptions-> None ");
            }
            else{
                for(int j=0;j<consET.length;j++){
                    System.out.println(depth+" "+" "+"Exceptions:  "+ consET[j]);
                }
            }
            System.out.println(depth+" "+" "+"Parameter types: ");
            for(int k=0;k<consPT.length;k++){
                System.out.println(depth+" "+" "+consPT[k].toString());
            }
            System.out.println(depth+" "+" "+"Modifiers:  "+ Modifier.toString(modifier));
        }
    }


    public void getMethods(Class c, Object obj, boolean recursive, String depth) {
        Method[] methods =c.getDeclaredMethods();
        System.out.println(depth+"METHODS( "+c+" )");
        System.out.print(depth+"Methods->");
        if(methods.length==0){
            System.out.println("None");
            return;
        }
        System.out.println();
        for (int i=0;i<methods.length;i++){
            System.out.println(depth+" "+"METHOD");
            String methodName = methods[i].getName();
            Class[] methodET = methods[i].getExceptionTypes();
            Class[] methodPT = methods[i].getParameterTypes();
            Class methodRT = methods[i].getReturnType();
            int modifier = methods[i].getModifiers();


            System.out.println(depth+" "+" "+"Name:  "+ methodName);
            System.out.print(depth+" "+" "+"Exceptions->");

            if(methodET.length==0){
                System.out.println("NONE");
            }
            else{
                System.out.println();
                for(int j=0;j< methodET.length;j++){
                    System.out.println(depth+" "+" "+methodET[j].toString());
                }
            }

            System.out.print(depth+" "+" "+"Parameter types-> ");
            if(methodPT.length==0){
                System.out.println("NONE");
            }
            else{
                System.out.println();
                for(int k=0;k<methodPT.length;k++){
                    System.out.println(depth+" "+" "+methodPT[k].toString());
                }
            }

            System.out.println(depth+" "+" "+"Return type:  "+ methodRT);
            System.out.println(depth+" "+" "+"Modifiers:  "+ Modifier.toString(modifier));
        }
    }

    public void getFields(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException {
        Field[] fields =c.getDeclaredFields();
        System.out.println(depth+"FIELDS( "+c+" )");
        System.out.print(depth+"Fields->");
        if(fields.length==0){
            System.out.println("None");
            return;
        }
        System.out.println();
        for (int i=0;i<fields.length;i++){
            System.out.println(depth+" "+"FIELD");
            String fieldName = fields[i].getName();
            Class fieldType = fields[i].getType();
            int modifier = fields[i].getModifiers();
            fields[i].setAccessible(true);
            Object value = fields[i].get(obj);

// Array type handling:
            if(fieldType.isArray()){
                System.out.println(depth+" "+" "+"Name:  "+ fieldName);
                System.out.println(depth+" "+" "+"Type:  "+ fieldType.toString());
                System.out.println(depth+" "+" "+"Modifiers:  "+ Modifier.toString(modifier));
                String component = value.getClass().getComponentType().toString();
                System.out.println(depth+" "+" "+"Component Type:  "+ component);

                if(value.getClass().getComponentType().isPrimitive()){
                    byte[] result = (byte[]) value;
                    System.out.println(depth+" "+" "+"Length:  "+ result.length);
                    System.out.println(depth+" "+" "+"Entries->");
                    for(int j=0;j<result.length;j++){
                        System.out.println(depth+" "+" "+"Value:  "+result[j]);
                    }
                }
                else{
                    Object[] result = (Object[]) value;
                    System.out.println(depth+" "+" "+"Length:  "+ result.length);
                    System.out.println(depth+" "+" "+"Entries->");
                    for(int j=0;j<result.length;j++){
                        if(result[j]!=null) {
                            inspectClass(result[j].getClass(), result[j], recursive, depth.length()+4);
                        }
                        else{
                            System.out.println(depth+" "+" "+"Value:  "+result[j]);
                        }
                        }
                    }
                }
            else{
                System.out.println(depth+" "+" "+"Name:  "+ fieldName);
                System.out.println(depth+" "+" "+"Type:  "+ fieldType.toString());
                System.out.println(depth+" "+" "+"Modifiers:  "+ Modifier.toString(modifier));
                if((!fieldType.isPrimitive()) && (!recursive)){
                    System.out.println(depth+" "+" "+"Value:  "+ value);
                }
                else if(!fieldType.isPrimitive()){
                    inspectClass(fields[i].getClass(),fields[i],recursive,depth.length()+4);
                }
                else if(fieldType.isPrimitive()){
                    System.out.println(depth+" "+" "+"Value:  "+ value);
                }
                else{
                    System.out.println(depth+" "+" "+"Error in getFields");
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BlockingPlayer bp = new BlockingPlayer("test",'X');
        String x = new String("Hello, world!");
        Inspector ip = new Inspector();
        ip.inspect(x,true);

    }
}