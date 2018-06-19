/**
 * Description:
 * @author chenshiyang
 * @date Apr 4, 2016
 * @version version 1.0
 */
package csy.classloader;

/**
 *
 * Description:
 */
class FatherClass {

    private static FatherClass f = new FatherClass();
    static {
        b = 10;
        System.out.println("father static block");
    }

    {
        System.out.println("father object block");
    }

    static int b = 5;

    public FatherClass() {
        System.out.println("father constructor...");
        System.out.println( "b = " + b);

    }
}

public class ChildClass extends FatherClass {
    static int a = 5;
    static {
        a = 10;
        System.out.println("child static block");
    }

    {
        System.out.println("chid object block");
    }

    private static ChildClass t1 = new ChildClass();

    public ChildClass() {
        System.out.println("child constructor...");
        System.out.println("a = " + a);
    }

    public static void main(String[] args) {
        ChildClass test = new ChildClass();
    }
}


/*father object block
//加载父类执行f的初始化时激发了父类对象的初始化，对象的初始化块执行
father constructor...
//对象的构造器
b = 0
//未经初始化的属性的缺省值
father static block
//f的初始化完成，执行父类的静态初始化快，父类加载完毕
child static block
//子类初始化开始，执行子类的静态初始化块
father object block
//t1的初始化激发了子类对象的初始化，并进而激发了父类对象的初始化，执行父类对象初始化块
father constructor...
//执行父类的构造器
b = 5
//父类的域属性已经被初始化，父类对象初始化完成
chid object block
//子类对象开始初始化，对象初始化块执行
child constructor...
//子类对象的构造器执行
a = 10
//子类对象的域属性已被初始化，完成子类的加载
father object block
//执行父类对象的初始化
father constructor...
b = 5
chid object block
//执行子类对象的初始化
child constructor...
a = 10*/