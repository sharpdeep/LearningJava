/*
 * 测试断言assert
 */
class Demo{
	public static void main(String[] args){
		int[] x = {1,2,3};
//		assert x.length == 0;
		assert x.length == 1:"x的长度不为1";
	}
}
