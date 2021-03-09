package com.bh.test;
import com.bh.pojo.User;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @Description:测试反射
 * @Author: WWT
 * @Date: 2021/3/8
 * @Time: 14:48
 */
public class ReflectTest {

    /**
     * 给ArrayList<Integer> 的一个对象
     * 在这个集合中添加一个字符串数据，如何实现
     */
    @Test
    public void test() throws Exception{
        // 创建集合对象
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(100);

        //添加字符串
        //通过实体类对象获取反射对象
        Class<?> aClass= arrayList.getClass(); // 集合ArrayList的class文件对象
        //获取方法对象
        Method method = aClass.getMethod("add",Object.class);
        //调用方法完成功能   原来：对象.方法(参数)   ---> 反射  方法.invoke(对象,参数);
        method.invoke(arrayList,"hello"); // 调用array的add方法，传入的值是hello

        System.out.println(arrayList);
        for (Object a : arrayList){
            System.out.println(a);
        }
    }

    /**
     * 反射：
     *      是通过class文件对象，获取该文件中的成员变量，构造方法，成员方法。
     * 方式：
     *      1.Object类的getClass()方法
     *      2.数据类型的静态属性class
     *      3.带包的类的全路径名---字符串
     *          public static Class forName(String className)
     *
     * 获取对象：
     *      获取构造方法(定义私有的)
     *      属性-----公有，私有
     *      方法-----公有，私有，带参，不带参
     *
     * 首先得到class文件对象，是得到Class类的对象
     * Class类：
     *      成员变量	Field
     *      构造方法	Constructor
     *      成员方法	Method
     */
    @Test
    public void testReflect() throws Exception {
        //方式一
        User user = new User();
        User user2 = new User();

        Class<?> aClass= user.getClass();
        Class<?> aClass2= user.getClass();

//        System.out.println(user==user2); //false
//        System.out.println(aClass==aClass2); //true

        //方式二
        Class<User> aClass_= User.class;
        Class<User> aClass2_= User.class;
//        System.out.println(aClass_==aClass2_); //true

        //方式三
        Class<?> aClass3= Class.forName("com.bh.pojo.User");
        Class<?> aClass4= Class.forName("com.bh.pojo.User");
        System.out.println(aClass3==aClass4); //true
    }

    /**
     * 通过反射获取构造方法
     */
    @Test
    public void testReflectDemo() throws Exception {
        //获取字节码文件对象
        Class c = Class.forName("com.bh.pojo.Reflect");

        // 获取构造方法
        // public Constructor[] getConstructors():所有公共构造方法
        // public Constructor[] getDeclaredConstructors():所有构造方法
        /*Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }*/

        // 获取单个构造方法
        // public Constructor<T> getConstructor(Class<?>... parameterTypes)
        // 参数表示：要获取的构造方法的构造参数个数及数据类型的class字节码文件对象
        Constructor constructor = c.getConstructor(); // 返回构造方法对象

       /* Reflect reflect = new Reflect();
        System.out.println(reflect);*/

        // public T newInstance(Object... initargs)
        // 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
        Object object = constructor.newInstance();
        System.out.println(object);

        /*Reflect reflect = (Reflect) object;
        reflect.show();*/
    }

    /**
     *需求：通过反射获取构造方法并使用：
     *  public Person(String name, int age, String address)
     * @throws Exception
     */
    @Test
    public void testReflectDemo2() throws Exception {
        //获取字节码文件对象
        Class c = Class.forName("com.bh.pojo.Reflect");

        // 获取带参构造方法对象
        // public Constructor<T> getConstructor(Class<?>... parameterTypes)
        Constructor constructor = c.getConstructor(
                String.class,int.class,String.class
        );

        // 通过带参构造方法对象创建对象
        // public T newInstance(Object... initargs)
        Object object = constructor.newInstance("杨新奇", 21, "济南");

        System.out.println(object);
    }

    /**
     * 通过反射获取私有构造方法
     * @throws Exception
     */
    @Test
    public void testReflectDemo3() throws Exception {
        //获取字节码文件对象
        Class c = Class.forName("com.bh.pojo.Reflect");

        //获取私有构造方法对象
        // 使用的方法只能获取公共的
        Constructor constructor = c.getDeclaredConstructor(String.class);

        // 用该私有构造方法创建对象
        // IllegalAccessException:非法的访问异常。
        // 暴力访问
        constructor.setAccessible(true);// 值为true则指示反射对象在使用时应该取消Java语言访问检查。
        Object object = constructor.newInstance("杨新奇");

        System.out.println(object);
    }

    /**
     * 通过反射获取私有构造方法
     * @throws Exception
     */
    @Test
    public void testReflectDemo4() throws Exception {
        //获取字节码文件对象
        Class c = Class.forName("com.bh.pojo.Reflect");

        //获取所有的成员变量
        //Field[] fields = c.getFields();  //public java.lang.String com.bh.pojo.Reflect.address
        /*Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }*/

        /**
         *  Reflect reflect =new Reflect(); reflect.address = "济南";System.out.println(address);
         */

        // 通过无参构造方法创建对象
        Constructor constructor = c.getConstructor();
        Object object = constructor.newInstance();
        System.out.println(object);

        // 获取单个的成员变量
        // 获取address并对其赋值
        Field addressField = c.getField("address");
        // public void set(Object obj,Object value)
        // 将指定对象变量上此 Field 对象表示的字段设置为指定的新值。
        addressField.set(object,"济南");
        System.out.println(object);

        // 获取name并对其赋值
        // NoSuchFieldException
        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(object,"杨新奇");
        System.out.println(object);

        //获取age并对其赋值
        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(object,21);
        System.out.println(object);
    }

    /**
     * 实现过程
     *      1.读取配置文件
     *         class.txt
     *      2.获取数据
     *      key---value
     *      class.forName("")
     */
    // 创建一个Properties对象,加载配置文件的对象
    private static Properties properties;
    public static String getFile(String key) throws Exception {
        return properties.getProperty(key);
    }
    @Test
    public void testFile() throws Exception{
        //读取配置文件class.txt
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\class.txt")));
        // 创建一个Properties对象,加载配置文件的对象
        properties = new Properties();
        //调用集合方法load，传递流对象
        properties.load(br);

        //获取字节码文件对象
        String className = getFile("className");
        Class aClass = Class.forName(className);
        //获取无参构造方法
        Constructor constructor = aClass.getConstructor();
        //通过构造方法实例化对象
        Object object = constructor.newInstance();
        //获取method方法
        String methodName = getFile("methodName");
        Method method = aClass.getMethod(methodName);
        // 调用方法
        method.invoke(object);
        System.out.println(methodName);
    }
}
