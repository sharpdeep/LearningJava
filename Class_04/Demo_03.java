/*
 *  测试数组作为参数和返回值
 */
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
