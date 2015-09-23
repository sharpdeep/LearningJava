/**
 * 测试位运算符
 */
class Demo{
	public static void main(String[] args){
		int x = -3;
		System.out.println("-3的反码是:"+(~x));
		System.out.println("3左移2位："+(3<<2));
		System.out.println("-3左移2位:"+(-3<<2));
		System.out.println("12右移2位:"+(12>>2));
		System.out.println("-12右移2位："+(-12>>2));
		System.out.println("12无符号右移2位:"+(12>>>2));
		System.out.println("-12无符号右移2位:"+(-12>>>2));
	}
}
