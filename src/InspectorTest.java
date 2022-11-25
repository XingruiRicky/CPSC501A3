import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InspectorTest {

    @Test
    void inspect() {
    }

    @Test
    void getClassName() throws Exception {
        ClassA ca = new ClassA();
        ClassB cb = new ClassB();
        ClassD cd = new ClassD();
        Inspector ip = new Inspector();
        assertEquals(ca.getClass().getName(),ip.getClassName(ca.getClass(),ca,false,""),"Error in getClassName with ca");
        assertEquals(cb.getClass().getName(),ip.getClassName(cb.getClass(),cb,false,""),"Error in getClassName with cb");
        assertEquals(cd.getClass().getName(),ip.getClassName(cd.getClass(),cd,false,""),"Error in getClassName with cd");
    }

    @Test
    void getSuperClassName() throws Exception {
        ClassA ca = new ClassA();
        ClassB cb = new ClassB();
        ClassD cd = new ClassD();
        Inspector ip = new Inspector();
        assertEquals(ca.getClass().getSuperclass().getClass(),ip.getSuperClassName(ca.getClass(),ca,false,"").getClass(),"Error in getSuperClassName with ca");
        assertEquals(cb.getClass().getSuperclass().getClass(),ip.getSuperClassName(cb.getClass(),cb,false,"").getClass(),"Error in getClassName with cb");
        assertEquals(cd.getClass().getSuperclass().getClass(),ip.getSuperClassName(cd.getClass(),cd,false,"").getClass(),"Error in getSuperClassName with cd");
    }

    @Test
    void getInterfaceNames() throws Exception {
        ClassA ca = new ClassA();
        ClassB cb = new ClassB();
        ClassD cd = new ClassD();
        Inspector ip = new Inspector();
        assertEquals(ca.getClass().getInterfaces().getClass(),ip.getInterfaceNames(ca.getClass(),ca,false,"").getClass(),"Error in getClassName with ca");
        assertEquals(cb.getClass().getInterfaces().getClass(),ip.getInterfaceNames(cb.getClass(),cb,false,"").getClass(),"Error in getClassName with cb");
        assertEquals(cd.getClass().getInterfaces().getClass(),ip.getInterfaceNames(cd.getClass(),cd,false,"").getClass(),"Error in getClassName with cd");
    }

    @Test
    void getConstructors() throws Exception {
        ClassA ca = new ClassA();
        ClassB cb = new ClassB();
        ClassD cd = new ClassD();
        Inspector ip = new Inspector();
        assertEquals(ca.getClass().getInterfaces().getClass(),ip.getInterfaceNames(ca.getClass(),ca,false,"").getClass(),"Error in getClassName with ca");
        assertEquals(cb.getClass().getInterfaces().getClass(),ip.getInterfaceNames(cb.getClass(),cb,false,"").getClass(),"Error in getClassName with cb");
        assertEquals(cd.getClass().getInterfaces().getClass(),ip.getInterfaceNames(cd.getClass(),cd,false,"").getClass(),"Error in getClassName with cd");
    }

    @Test
    void getMethods() throws Exception {
        ClassA ca = new ClassA();
        ClassB cb = new ClassB();
        ClassD cd = new ClassD();
        Inspector ip = new Inspector();
        assertEquals(ca.getClass().getMethods().getClass(),ip.getMethods(ca.getClass(),ca,false,"").getClass(),"Error in getClassName with ca");
        assertEquals(cb.getClass().getMethods().getClass(),ip.getMethods(cb.getClass(),cb,false,"").getClass(),"Error in getClassName with cb");
        assertEquals(cd.getClass().getMethods().getClass(),ip.getMethods(cd.getClass(),cd,false,"").getClass(),"Error in getClassName with cd");
    }

    @Test
    void getFields() throws Exception {
        ClassA ca = new ClassA();
        ClassB cb = new ClassB();
        ClassD cd = new ClassD();
        Inspector ip = new Inspector();
        assertEquals(ca.getClass().getDeclaredFields().getClass(),ip.getFields(ca.getClass(),ca,false,"").getClass(),"Error in getClassName with ca");
        assertEquals(cb.getClass().getDeclaredFields().getClass(),ip.getFields(cb.getClass(),cb,false,"").getClass(),"Error in getClassName with cb");
        assertEquals(cd.getClass().getDeclaredFields().getClass(),ip.getFields(cd.getClass(),cd,false,"").getClass(),"Error in getClassName with cd");
    }
}