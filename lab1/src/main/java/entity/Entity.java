package entity;

import java.io.Serializable;

public class Entity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String title;
	private int age;
	private float width;
	
	public Entity(String title, int age, float width) {
		super();
		this.title = title;
		this.age = age;
		this.width = width;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "{\"title\": \""+title+"\", \"age\":"+ age+", \"width\":"+width+"}";
	}
	
	
	
	

}