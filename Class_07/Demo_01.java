/*
 * 测试throws关键字
 */
class Math{
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
		}catch(Exception e){
			System.out.println(e);
		}finally{
			System.out.println("一定会执行到的代码");
		}
	}
}
