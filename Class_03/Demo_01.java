/**
 * int最大值+1,变为最小值，+2变为次小值(以二进制思维思考)
 */
class Demo{
	public static void main(String[] args){
		int max = Integer.MAX_VALUE; //获取得最大int值
		System.out.println("Max:"+max); 
		System.out.println("Max+1:"+(max+1)); //溢出
		System.out.println("MAX+2:"+(max+2)); //溢出
		System.out.println("Max+1(to long type):"+(max+1L)); //转为long
		System.out.println("Max+2(force to long type):"+((long)max+2));	//强制转化为long
	}
}
