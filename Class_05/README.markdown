# 面向对象（基础篇）

##面向对象三大特性：
**封装性，继承性，多态性**

##封装性
- 把属性和行为看成一个整体
- 把一些细节隐藏起来，对属性或行为设置权限

##继承性
子类(派生类)得到父类(超类)的所有方法和属性，提高了代码复用率，**Java中只允许单继承**

##多态性
两种形式：  
- 方法重载
- 对象多态：子类对象和父类对象可以相互转换

##对象创建
```Java
类名 对象名 = null; //声明，在栈中
对象名 = new 类();  //创建，在堆中
```
或者
```Java
类名 对象名 = new 类();
```

##构造方法
```java
访问权限 方法名(同类名)(参数){

}
```
- 构造方法没有返回值，不用声明返回类型；
- 构造方法与类名必须相同；
- 理论上构造方法的访问权限也可以为private，但是一般时在单例模式中使用。

##匿名对象
只在堆中创建了对象，而没有在栈中创建对象的引用。
```java
class Demo{
        public static void main(String[] args){
                new Person("sharpdeep",22).tell();
        }
}
```

##引用传递
对象作为函数参数传入时，本质上传递的是对象的引用。所以主要记住对象引用在栈上，对象在堆上就可以理解以下几种情况。
1. 
```java
class Demo{
        public static void main(String[] args){
                String str = "hello";
                System.out.println("before fun():str="+str);//"hello"
                fun(str);
                System.out.println("after fun():str="+str);//"hello"
        }

        public static void fun(String str){
                str = "world";
        }
}
```
对String直接赋值，其实是在堆中再新建一个对象，然后再指向该对象，所以当函数调用结束后，原来的str并没有改变.(所以平时应该尽量避免直接堆String类改变值，可以使用相应的buffer类)。  
2. 传递对象引用，改变对象属性(属性是对象也一样)
```java
class Demo{
        public static void main(String[] args){
                Person p = new Person();
                p.age = 10;
                System.out.println("before func(),Person.age="+p.age);//10
                func(p);
                System.out.println("after func(),Person.age="+p.age);//20
        }

        public static void func(Person p){
                p.age = 20;
        }
}
```
##This关键字
1. 使用this调用本类的属性，一般比较多用在构造方法中，如：
```java
class Demo{
    private String name;
    public Demo(String name){
        this.name = name;
    }
}
```
此处传入参数与属性同名，所以必须用this强调是否是类中属性，如果没有将会出现访问name出现null的情况。
2. 使用this调用构造方法，在类中如果有多个构造方法，可以使用this调用。如：
```java
class Demo{
    private String name;
    public Demo(){
        ....
    }
    
    public Demo(String name){
        this();//这里调用无参构造方法
        this.name = name;
    }
}
```
使用this调用构造方法有几个需要注意的地方：
 至少有一个没有用this调用其他构造方法的构造方法，防止出现循环；
`this()`必须出现在第一行，因为构造函数是新建一个对象优先执行的方法，所以不能在其他地方执行。  
3. this表示对象本身，比较常用的是比较对象，传入一个对象，利用this跟传入对象对比是否是相同的对象。

##Java中常用的内存区域

1. 栈内存空间：保存所有的对象名称(引用的堆内存空间的地址)；
2. 堆内存空间：保存每个对象的具体属性内容；
3. 全局数据区：保存static类型的属性；
4. 全局代码区：保存所有的方法定义。

**非static类型声明的属性或方法可以用static属性和方法，但是static类型声明的属性和方法不能用非static的属性和方法**。因为非static类型必须在对象创建的时候初始化，而static类型在对象未被实例化的时候就已经存在。

##代码块
代码块就是用大括号包起来的代码，如平常在方法中的代码就是一种代码块。除此之外，还可以直接用{}定义代码块。
```java
class Demo{
        {
                System.out.println("运行代码块1");
        }
        static{
                System.out.println("运行静态代码块");
        }
        public static void main(String[] args){
                System.out.println("运行主方法");
                Demo demo = new Demo();
        }

        public Demo(){
                System.out.println("运行构造方法");
        }

        {
                System.out.println("运行代码块2");
        }
}
```
输出：
> 
运行静态代码块
运行主方法
运行代码块1
运行代码块2
运行构造方法

说明执行顺序是：静态代码块-->主方法-->代码块-->构造方法

##内部类
在一个类中可以定义另一个类，这个类就是内部类，外部的就叫外部类。内部类可以是private也可以是public(因为内部类是作为一个内部属性存在的，所以public的内部类不破坏一个java文件只有一个public类的约定)

内部类的好处是可以方便的调用外部类的私有属性，如：
```java
class Outter{
    private String str = "Hello";
    class Inner{
        public void print(){
            System.out.println(str);
        }
    }
    
    public static void main(Strng[] args){
        Outter outter = new Outter();
        outter.Inner.print();//"Hello"
    }
}
```

###在外部访问内部类
内部类编译后的class文件是Outter$Inner.class，其在外部访问的创建方式是：
```java
Outter out = new Outter();//先创建外部类实例
Outter.Inner in = out.new Inner();//创建内部类对象
```

###在方法内创建内部类
在外部类的方法内也可以创建内部类，但是不能直接访问方法内的参数，除非参数加上`final`。
```java
class Outer{
    private String str = "Hello";
    public void func(final int temp){
        class Inner{
            public void print(){
                System.out.println(str);
                System.out.println(temp);
            }
        }
        new Inner().print();
    }
}
```
















