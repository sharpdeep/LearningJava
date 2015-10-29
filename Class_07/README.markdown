#Java异常的捕获与处理

##异常处理形式：
```java
try{
    //可能出现异常的代码    
}catch(异常类1 异常对象1){
    //异常处理代码1
}catch(异常类2 异常对象2){
    //异常处理代码2
}finally{
    //一定会执行到的代码
}
```
- catch异常中可以用Exception接收所有异常。
- 接收多个异常时，范围小的异常需要在前面，否则可能出现编译错误。

##两种异常
```
                Throwable
                   /\
                  /  \
                 /    \
           Exception  Error
```
Exception和Error都是Throwable的子类，其中： 

- **Exception:** 可以在程序中用try...catch处理
- **Error:** 一般指JVM错误，无法在程序中处理处理

##throws和throw关键字

1. throws用在方法声明定义时，表示本身不对异常做处理，而是将异常抛出，留给调用处（上级）处理。如果是main方法使用throws，则是抛出给JVM处理；
```java
class Math{
        //抛出给上级处理
        public int div(int i, int j) throws Exception{
                int temp = i/j;
                return temp;
        }
}

class Demo{
        public static void main(String[] args){
                Math m = new Math();
                try{
                        System.out.println(m.div(2,3));
                        //调用div方法必须抛出或者处理异常，否则将会编译错误。除非throws的异常是RuntimeException
                }catch(Exception e){
                        System.out.println(e);
                }finally{
                        System.out.println("一定会执行到的代码");
                }
        }
}

```
2. throw在方法内，用于抛出异常（新建的或者非新建都可以）
```java
class Demo{
        public static void main(String[] args){
                try{
                        throw new Exception("新建的一个异常");
                }catch(Exception e){
                        System.out.println(e);
                }
        }
}
```

##Exception和RuntimeException
- RuntimeException是Exception的子类；
- Exception若是被throws抛出，上级必须使用try...catch处理或者抛出；
- RuntimeException若是被throws抛出，上级可以不用try...catch处理或者抛出。

##断言
断言格式：
```java
assert boolean表达式；
assert boolean表达式:错误信息;
```
**Example**
```java
class Demo{
        public static void main(String[] args){
                int[] x = {1,2,3};
//              assert x.length == 0;
                assert x.length == 1:"x的长度不为1";
        }
}

```

- 当boolean表达式为true时，没有任何反应；
- 当boolean表达式为false时，如果开启断言(执行时用java -ea)，则输出错误信息；
- java执行时默认不开启断言(断言一般只用在测试)，如果需要执行时开启断言，用`java -ea`执行，如`java -ea Demo`
