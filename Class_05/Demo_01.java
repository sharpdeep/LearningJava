/*
 * 测试对象引用传递
 */

class Person{
	String name;
	int age;
	public Person(){}
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public void tell(){
		System.out.println("name:"+name+",age:"+age);
	}
}

class Demo{

	public static void main(String[] args){
		Person p1 = new Person();
		Person p2 = p1;
		
		p1.name = "张三";
		p1.age = 23;

		p2.name = "赵四";
		p2.age = 33;

		p1.tell();
		p2.tell();
	}
}
