import java.lang.reflect.*;

import ttt.*;

import javax.lang.model.type.PrimitiveType;

public class Inspector {

    public void inspect(Object obj, boolean recursive) throws IllegalAccessException, NoSuchFieldException {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive,0);
    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) throws IllegalAccessException, NoSuchFieldException {
        String indent = " ";
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

    public String getClassName(Class c, Object obj, boolean recursive, String depth) {
        System.out.println(depth+"CLASS");
        System.out.println(depth+"Class:  "+c.getName());
        return c.getName();
    }

    public Class getSuperClassName(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException, NoSuchFieldException {
        if(c.isInterface()) return null;
        if(c.equals(Object.class)){
            System.out.println(depth+"SuperClass: NONE");
            return null;
        }
        System.out.println(depth+"SUPERCLASS -> Recursively Inspect");
        System.out.println(depth+"SuperClass: "+c.getSuperclass().getName());
//        System.out.print(depth);
        inspectClass(c.getSuperclass(),obj,recursive,depth.length()+4);
        return c.getSuperclass();
    }

    public Class[] getInterfaceNames(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException, NoSuchFieldException {
        Class[] interfaceName = c.getInterfaces();
        System.out.println(depth+"INTERFACES:(" +c+ ")");
        if(interfaceName.length==0){
            System.out.println(depth+"Interfaces-> NONE");
            return interfaceName;
        }
        for(int i=0;i<interfaceName.length;i++){
            System.out.println(depth+"Interfaces-> ");
            System.out.println(depth+"INTERFACE -> Recursively Inspect");
            System.out.println(depth+interfaceName[i].toString());
            inspectClass(interfaceName[i],obj,recursive,depth.length()+4);
        }
        return interfaceName;
    }

    public Constructor[] getConstructors(Class c, Object obj, boolean recursive, String depth) {
        Constructor[] cons =c.getDeclaredConstructors();
        System.out.println(depth+"CONSTRUCTORS( "+c+" )");
        System.out.print(depth+"Constructors->");

        if(cons.length==0){
            System.out.println("NONE");
            return cons;
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
        return cons;
    }


    public Method[] getMethods(Class c, Object obj, boolean recursive, String depth) {
        Method[] methods =c.getDeclaredMethods();
        System.out.println(depth+"METHODS( "+c+" )");
        System.out.print(depth+"Methods->");
        if(methods.length==0){
            System.out.println("None");
            return methods;
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
        return methods;
    }

    public Field[] getFields(Class c, Object obj, boolean recursive, String depth) throws IllegalAccessException, NoSuchFieldException {
        Field[] fields =c.getDeclaredFields();
        System.out.println(depth+"FIELDS( "+c+" )");
        System.out.print(depth+"Fields->");
        if(fields.length==0){
            System.out.println("None");
            return fields;
        }
        System.out.println();
        for (int i=0;i<fields.length;i++){
            System.out.println(depth+" "+"FIELD");
            String fieldName = fields[i].getName();
            Class fieldType = fields[i].getType();
            int modifier = fields[i].getModifiers();
            fields[i].setAccessible(true);


// Array type handling:
            if(fieldType.isArray()){
                Object value = fields[i].get(obj);
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
                else {
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
                    Object value = fields[i].get(obj);
                    System.out.println(depth+" "+" "+"Value:  "+ value);
                }
                else if(!fieldType.isPrimitive()){
                    Object value = fields[i].get(obj);
                    System.out.println(depth+" "+" "+"Value:  "+ value);
                    System.out.println(depth+" "+" "+" "+"-> Recursively inspect");
                    if(value!=null){
                        inspectClass(value.getClass(),value,recursive,depth.length()+4);
                    }
                }
                /////////////////GET PRIMITIVE DATA TYPE/////////////////////
                else if(fieldType.isPrimitive()){
                    //System.out.println(fields[i].getType());
                    //System.out.println(fields[i].getInt(obj));

                    if(fields[i].getType().toString().equals("short")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getShort(obj));
                    }
                    else if(fields[i].getType().toString().equals("int")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getInt(obj));
                    }
                    else if(fields[i].getType().toString().equals("long")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getLong(obj));
                    }
                    else if(fields[i].getType().toString().equals("float")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getFloat(obj));
                    }
                    else if(fields[i].getType().toString().equals("double")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getDouble(obj));
                    }
                    else if(fields[i].getType().toString().equals("byte")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getByte(obj));
                    }
                    else if(fields[i].getType().toString().equals("boolean")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getBoolean(obj));
                    }
                    else if(fields[i].getType().toString().equals("char")){
                        System.out.println(depth+" "+" "+"Value:  "+ fields[i].getChar(obj));
                    }
                    else{
                        System.out.println("No matching primitive type");
                    }
                }
                else{
                    System.out.println(depth+" "+" "+"Error in getFields");
                }
            }
        }
        return fields;
    }

    public static void main(String[] args) throws Exception {
        BlockingPlayer bp = new BlockingPlayer("test",'X');
        String x = new String("Hello, world!");
        Inspector ip = new Inspector();
        ip.inspect(x,true);

    }
}