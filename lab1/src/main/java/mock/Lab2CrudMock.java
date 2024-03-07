package mock;

import crud.Lab2CrudInterface;
import entity.Entity;

public class Lab2CrudMock implements Lab2CrudInterface {

	@Override
	public Entity readEntity() {
		// TODO Auto-generated method stub
		return new Entity("Mock1", 23, 3.3f);
	}

	@Override
	public void updateEntity(Entity entity) {
		// TODO Auto-generated method stub

	}

}
