/**
 * 测试引用传递
 */

class Demo{
	public static void main(String[] args){
		String str = "hello";
		System.out.println("before fun():str="+str);
		fun(str);
		System.out.println("after fun():str="+str);	
	}

	public static void fun(String str){
		str = "world";
	}
}
