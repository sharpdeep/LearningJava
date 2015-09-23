/*
 * 方法重载
 */
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
