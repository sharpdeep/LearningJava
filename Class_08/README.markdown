#包及访问控制权限(附Java命名规范)

##打包(package)

格式：
```java
package 包名;
```
**Example**
```java
package com.sharpdeep.demo08;

class Demo{
        public String printInfo(){
                return "Hello world";
        }

}

class MainClass{
        public static void main(String[] args){
                System.out.println(new Demo().printInfo());
        }
}
```

- 加上打包package关键字，编译时需加上一些参数，如：`javac -d . Demo_01.java`。其中`-d`表示生成目录，如上的打包就会生成一个`com/sharpdeep/demo08`的目录，存放生成的class文件；`.`表示在当前目录生成目录。
- 执行时也需注意，需指定完整包名+类名，如`java com.sharpdeep.demo08.MainClass`，注意这是在当前目录执行的命令，而不能进入./com/sharpdeep/demo08执行。

##引包(import)
用于导入不同包的类，有以下两种格式：
```
import 包名.类名;   //指定类导入
import 包名.*;      //导入包内所有类
```
**Example**
```java
/*
*  filename:Demo.java
*/
package com.sharpdeep.demo08.a;

public class Demo{
        public String getInfo(){
                return "I am in com.sharpdeep.demo08.a";
        }
}
```
```java
/*
*  filename:Demo_03.java
*/
package com.sharpdeep.demo08.b;
import com.sharpdeep.demo08.a.Demo;

class ImportDemo{
        public static void main(String[] args){
                System.out.println(new Demo().getInfo());
        }
}
```

- Demo类必须是public，因为要被不同包的类引用；
- 编译时应先编译Demo.java，再编译Demo_03.java；
- 用`import 包名.*;`的效率并不比单独导入低，因为这是自动导入，不需要的类是不会被导入的；
- 如果两个不同的包有同名类时(如a，b包中都有Demo类)，为了不引起混乱，使用时需要完整类名调用(如`com.sharpdeep.demo08.a.Demo demo = new com.sharpdeep.demo08.a.Demo();`)。

##静态导入

使用条件:如果一个类中**所有方法**都是static方法，使用静态导入后，可以直接使用方法名调用，而不需要用类名.静态方法名的形式调用。(JDK1.5后引入)
```java
基本形式：import static 包名.类名.*;
```

**Example:**

```java
package com.sharpdeep.demo08.c;

public class Demo_04{
        public static int add(int i, int j){
                return i+j;
        }
}
```
```java
import static com.sharpdeep.demo08.c.Demo_04.*;

class StaticImport{
        public static void main(String[] args){
                System.out.println("1+1="+add(1,1));
        }
}
```

##Jar命令
```
创建jar包
jar -cvf my.jar a.class b.class

查看jar包结构
jar -tvf my.jar

解压jar包
jar -xf my.jar
```

- jar包实际上是一个压缩包，跟普通rar和zip之类压缩包不同的是，jar包中还包含了清单文件：META-INF/MANIFEST.MF。
- 为了在程序中能够调用jar包中的class文件，应该将jar包的路径包含到CLASSPATH中。
- 关于jar命令和jar文件可以查看这篇博文：http://developer.51cto.com/art/200509/2770.htm

##访问控制权限

- **private**:只有本类成员可以访问；
- **default**:本类成员和同一个包的不同类可以访问；
- **protected**:本类成员和同一个包的不同类和不同包的子类可以访问；
- **public**:任何一个类都可以访问。

##Java命名规范
虽然命名没有一个硬性标准，不按规范命名也不会引起程序出错。但是为了阅读方便，Java行业中还是存在着大家都认可的标准。

1. 类的命名：首字母大写，如HelloTest；
2. 方法的命名：第一个单词小写，以后每个单词首字母大写，如getInfo；
3. 属性命名：普通属性同方法命名；
4. 包：所有单词小写；
5. 用static final修饰的常量用全大写命名，如NAME。






