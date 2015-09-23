/*
 * 测试数组的声明和开辟空间
 */

class Demo{
	public static void main(String[] args){
		Integer num1s[] = null;	//声明数组1,数组名在栈内
	      	int[] num2s = null;	//声明数组2，数组名在栈内
		num1s = new Integer[100];//分配空间，分配的空间在堆中
		num2s = new int[100];
		int num3s[] = new int[100]; //声明同时分配空间
		Integer[] num4s = new Integer[100];
		System.out.println("num1s length is:"+num1s.length);
	}
}
