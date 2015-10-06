/*
 * 测试引用传递2
 */
class Demo{
	public static void main(String[] args){
		Person p = new Person();
		p.age = 10;
		System.out.println("before func(),Person.age="+p.age);
		func(p);
		System.out.println("after func(),Person.age="+p.age);
	}

	public static void func(Person p){
		p.age = 20;
	}
}
