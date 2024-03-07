package fileIO;

import entity.Entity;

public class Main {

	public static void main(String[] args) {
		Entity entity = new Entity("Mock2", 23, 3.3f);
		
		FileIOInterface fio = new FileIO();
		
		fio.saveToFile(entity);
		
		System.out.println((Entity)fio.loadFromFile());
	}

}
