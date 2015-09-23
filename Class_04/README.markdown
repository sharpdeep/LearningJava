# 数组和方法重载

##数组：
*存放相同类型的数据的集合*
```Java
class Demo{
        public static void main(String[] args){
                Integer num1s[] = null; //声明数组1,数组名在栈内
                int[] num2s = null;     //声明数组2，数组名在栈内
                num1s = new Integer[100];//分配空间，分配的空间在堆中
                num2s = new int[100];
                
                int num3s[] = new int[100]; //声明同时分配空间
                Integer[] num4s = new Integer[100];
                
                System.out.println("num1s length is:"+num1s.length);
                
                int num5s[] = {1,2,3,4,5}; //静态初始化
        }
}
```
多维数组同样适用

##方法重载
```Java
class Demo{
        public static void main(String[] args){
                System.out.println("10+3="+add(10,3));
                System.out.println("10+3+4="+add(10,3,4));
                System.out.println("10.3+3.5="+add(10.3f,3.5f));
        }

        public static int add(int x, int y){
                return x+y;
        }

        public static int add(int x, int y, int z){
                return x+y+z;
        }

        public static float add(float x, float y){
                return x+y;
        }
}
```
**参数类型/参数数量不同都可以算是重载，返回类型不同不算重载(因为返回值可以被类型转换)**

##数组作为参数与返回值
```Java
class Demo{
        public static void main(String[] args){
                int x1[] = {1,2,3,4,5};
                int x2[] = {6,7,8,9,10};
                func_01(x1);
                func_02(x2);
                int x[] = func_03();
                System.out.println("数组作为返回值");
                for(int i = 0; i < x.length; i++)
                        System.out.println(x[i]);
        }

        public static void func_01(int[] x){
                System.out.println("数组作为参数传入，传入值为：");
                for(int i = 0; i < x.length; i++){
                        System.out.println(x[i]);
                }
        }

        public static void func_02(int x[]){
                System.out.println("数组作为参数传入，传入值为：");
                for(int i = 0; i < x.length; i++){
                        System.out.println(x[i]);
                }

        }

        public static int[] func_03(){
                int x[] = new int[]{1,2,3,4,5};
                return x;
        }
}
```

##可变参数
```Java
class Demo{
        public static void main(String[] args){
                func();
                func(1);
                func(1,2,3,4);
        }

        public static void func(int... x){
                System.out.println("输入值是：");
                for(int i = 0; i < x.length; i++){
                        System.out.println(x[i]+",");
                }
        }
}
```

##foreach
形式如下：
```
for(数据类型 变量名:数组名)
```

```Java
class Demo{
        public static void main(String[] args){
                func();
                func(1);
                func(1,2,3,4);
        }

        public static void func(int... x){
                System.out.println("输入值是：");
                for(int i:x){
                        System.out.println(i+",");
                }
        }
}
```




