#面向对象(高级篇）

##继承

1. Java只允许单继承；
2. 私有成员不被子类继承，所以子类不能直接访问父类的私有成员；
3. 子类覆写父类的方法，不能使用比父类还小的权限，如父类是public，子类只能是public。(来自里氏替换原则:`父类出现的地方能用子类替换，而相反则不信`）,覆写方法常在覆写的方法之上写`@override`作为标示;
4. super关键字，与this关键字很相似，super能调用父类的构造方法，普通属性和方法。

##final关键字

1. 使用final修饰的类不能被继承；
2. 使用final修饰的方法不能被覆写；
3. 使用final修饰的变量不可修改(常量).

##抽象类
一个专门用来被继承的类，本身并不能实例化。
抽象类有以下规定：
> 
- 包含一个抽象方法的类必须是抽象类；
- 抽象类和抽象方法都使用`abstract`关键字修饰；
- 抽象方法只需要声明而不用实现；
- 抽象类必须被继承，子类可以是抽象类也可以是普通类，如果不是抽象类，则必须覆写抽象类中的所有抽象方法。

注意：抽象类不能用final修饰，因为必须被继承；抽象方法不能用private修饰，因为必须被覆写。

##接口
接口是由**全局常量(public static final)和抽象方法(public abstract)组成的。**(Java8中允许接口出现default方法。)，其属性必须是`public static final`，方法必须是`public abstract`(都使用public是从接口设计出发的，接口是面向使用者的;而变量采用常量是为了避免多接口实现出现混乱),有时没有显式声明也是可以的。

接口使用有以下几个规则：
>  
- 接口采用`implements`实现，一个类允许实现多个接口。
- 抽象类也一样允许实现一个或者多个接口，这样如果继承了这个抽象类，那么就要实现抽象类的抽象方法和所有接口的抽象方法；
- 接口不允许继承类或抽象类，但是允许实现一个或者多个接口。

##抽象类和接口区别
|区别点|抽象类|接口 |
|:----:|:----:|:---:|
|定义|包含一个抽象方法的类|抽象方法和全局常量的集合|
|组成|构造方法/抽象方法/普通方法/常量/变量|`public static final`常量和`public abstract`方法(Java8中允许出现default方法)|
|使用|子类继承抽象类(extends)|子类实现接口(implements)|
|关系|抽象类可以实现多个接口|接口不能继承抽象类，但是允许继承多个接口|
|常见设计模式|模板模式|工厂模式/代理模式|
|对象|都通过对象的多态性产生实例对象|
|局限|抽象类只能单继承|接口没有此局限|
|用途|作为一个模板|作为一个标准或者表示一种能力|
|选择|如果抽象类和接口都可以使用，优先使用接口，避免单继承的局限|
|特殊|一个抽象类可以包含多个接口，一个借口可以包含多个抽象类|


##多态

两种体现：
1. 方法的重载(一个类内)和覆写(父子类之间）
2. 对象的多态：
> 
 - 向上转型：子类对象-->父类对象；(安全，自动)
 - 向下转型: 父类对象-->子类对象；(不一定安全)

###向上转型
```java
class A{
    public void func1(){
        ......
    }
    
    public void func2(){
        ......
    }
}

class B extends A{
    @override
    public void func1(){
        ......
    }
    
    public void func3(){
        
    }
}

class C{
    public static void main(String[] args){
        A a = new B();
        a.func1();//执行的是B的func1方法。
        a.func3();//错误，无法调用子类方法
    }
}
```
**向下转型必须先有向上转型的过程，否则将会出错**

##instanceof关键字
```java
class A{
    public void func1(){
        ......
    }
    public void func2(){
        ......
    }
}

class B extends A{
    @override
    public void func1(){
        .......
    }
    publc void func3(){
        ......
    }
}

class C extends A{
    @override
    public void func1(){
        ......
    }
    
    public void func4(){
        ......
    }
}

class Demo{
    public static void main(Sting[] args){
        /*
        B->func1();
        B->func3();
        */
        func(new B());
        
        /*
        C->func1();
        C->func4();
        */
        func(new C());
    }
    
    public void func(A a){
        a.fun1();
        if(a instanceof B){
            B b = (B)a;
            b.func3();
        }
        if(a instanceof C){
            C c = (C)a;
            c.func4();
        }
    }
}
```
向上转型后，对象即是子类的实例也是父类的实例。执行覆写方法时执行的是子类的方法，向上转型后只有再向下转型才可以调用子类方法。用instanceof能够查询对象是那个类的实例。

**尽量不要继承已经实现好的类，最好继承抽象类或者实现接口，因为当发生向上转型时，调用的方法是被子类覆写的方法，而不能调用父类原方法**

##内部类拓展
抽象类中也可以有接口或其他抽象类内部类，但是继承了这个抽象类后，也必须实现内部类。接口也相同。

##Object类
所有的类都是Object类的子类，Object类中有许多常用的方法，如：
|方法|说明|
|:--:|:--:|
|hashCode|获取对象hash码|
|equals|对象比较|
|toString|打印对象时调用|

##装箱与拆箱操作
每一个基本数据类型都有一个类与之对应，这个类称为包装类。如int对应Integer，具体可以看[Class_03 基本数据类型和运算符](../Class_03).

其中

- Integer/Byte/Float/Double/Short/Long都属于Number类的子类；
- Character是Object的直接子类；
- Boolean是Object的直接子类。

将基本数据类型转为对应的包装类称为**装箱**,而将对应的包装类转为基本数据类型则称为**拆箱**。JDK1.5后可以自动装箱和拆箱，比较方便，如：
```java
Integer i = 30；//自动装箱
Float f = 30.3f;//自动装箱
int x = i;//自动拆箱
float y = f;//自动拆箱
```

##匿名内部类
是在接口和抽象类的应用上发展起来的，使用于实现类用处不多的地方。在Android的监听中比较常用。如：
```java
interface A{
    public void printInfo();
}
class X{
    public void func1(){
        this.func2(new A(){
            public void printInfo(){
                System.out.println("Hello");
            }
        });
    }

    public void func2(A a){
        a.printInfo;
    }
}

class Demo{
    public static void main(String[] args){
        X x = new X();
        x.func1();
    }
}
```
