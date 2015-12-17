/*
 * 测试打包
 */
package com.sharpdeep.demo08;

class Demo{
	public String printInfo(){
		return "Hello world";
	}

}

class MainClass{
	public static void main(String[] args){
		System.out.println(new Demo().printInfo());
	}
}
