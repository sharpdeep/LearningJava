/*
 * 测试可变参数
 */
class Demo{
	public static void main(String[] args){
		func();
		func(1);
		func(1,2,3,4);
	}
	
	public static void func(int... x){
		System.out.println("输入值是：");
//		for(int i = 0; i < x.length; i++){
//			System.out.println(x[i]+",");
//		}
		for(int i:x){
			System.out.println(i+",");
		}
	}
}
