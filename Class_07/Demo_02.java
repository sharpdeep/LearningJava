/*
 * 测试throw关键字
 */
class Demo{
	public static void main(String[] args){
		try{
			throw new Exception("新建的一个异常");
		}catch(Exception e){
			System.out.println(e);	
		}
	}
}
