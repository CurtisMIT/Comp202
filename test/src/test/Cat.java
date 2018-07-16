package test;

public class Cat {
	// attribute
	private String name;
	private double age;
	
	
	
	// constructors
	public Cat(String name) {
		this.name = name;
	}
	
	public Cat(String n, double a) {
		this.name = n;
		this.age = a;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAge() {
		return this.age;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	// all other methods
	public String toString() {
		return this.name + ", " + this.age;
	}
	
	public boolean isOlderThan(Cat c) {
		if(this.age > c.age) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	// main method
	public static void main(String[] args) {
		Cat grumpy = new Cat("Grumpy Cat", 7);
		Cat small = new Cat("Small Cat");
		System.out.println(grumpy.isOlderThan(small));
	}
}
