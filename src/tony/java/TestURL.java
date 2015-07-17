package tony.java;

import org.junit.Test;

public class TestURL {

	@Test
	public void test1(){
		int [][]a  = new int [10][3];
		System.out.println(a[1][0]);
		
	}



class Primive{
	boolean [] t = new boolean[3];
	
	
}

	@Test
	public void Array(){
		Primive d = new Primive();
		System.out.println(d.t);
		d.t[0] = true;
		d.t[1] =  true;
		d.t[2] = true;
		
		for(boolean s:d.t){
			System.out.println(s);
		}
		
	}
	
	
	class Student{
		int number;
		int state;
		int score;
	public Student(int number, int state, int score){
		this.number = number;
		this.state = state;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [number=" + number + ", state=" + state + ", score="
				+ score + "]";
	}
	
	}
	
	@Test
	public void Array2(){
	
		
		Student [] a = new Student[20];
//		System.out.println(a[0].number);
		for(int i = 0;i<20;i++){
			a[i]= new Student(i+1, (int)(Math.random()*6), (int)(Math.random()*100));
		
			
		}
		
		for(Student q:a ){
			if(q.state == 3){
				System.out.println(q);
			}
		}
		

	}
	
	
	/*
	 * 使用二维数组打印一个 10 行杨辉三角.
1
1 1
1 2 1
1 3 3  1
1 4 6  4  1
1 5 10 10 5 1
	 * 
	 */
	
	@Test
	public void test3(){
		int y[][] = new int[10][];
		for(int i = 1;i<11;i++){
			y[i-1] = new int [i];
			y[i-1][0]=1;
			if(i>1){
				y[i-1][y[i-1].length-1] = 1;
			}
		}
		
		for(int i = 1;i<y.length;i++){
			for(int o = 0; o<y[i].length;o++){
				if(i>= 2 && o != 0 && o != y[i].length-1){
					y[i][o] = y[i-1][o-1]+y[i-1][o];
				}
				
			}
			
		}
		
		for(int i = 0; i< y.length;i++){
			for(int k = 0; k<y[i].length;k++){
				System.out.print(y[i][k]+"\t");
			}
			System.out.println();
		}
		
		
	}
	
	/*
	 * 
	 * 定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素的最大值，最小值，平均值，和值，并输出出来
	 * 
	 * 
	 */
	@Test
	public void test4(){
		int total = 0;
		
		int [] a = new int[10];
		for(int i = 0; i< 10;i++){
			a[i] =  (int)(Math.random()*100);
			total+= a[i];
		}
		int max = a[0];
		int min =a[0];
		for(int i = 1; i<10;i++){
			if(max < a[i]){
				max = a[i];
			}
			
			if(min > a[i]){
				min = a[i];
			}
			
		}
		for(int s: a){
			System.out.print(s+" ");
		}
		System.out.println();
		int ave = total/a.length;
		System.out.println("The max number is "+ max+"\nThe min number is "+ min+"\nThe average is "+ave+"\nThe total result is "+ total);
		
		
	}
	
	
}