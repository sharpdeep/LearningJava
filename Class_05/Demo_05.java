/*
 * 测试代码块
 */

class Demo{
	{
		System.out.println("运行代码块1");
	}
	static{
		System.out.println("运行静态代码块");
	}
	public static void main(String[] args){
		System.out.println("运行主方法");
		Demo demo = new Demo();	
	}

	public Demo(){
		System.out.println("运行构造方法");
	}

	{
		System.out.println("运行代码块2");
	}
}
