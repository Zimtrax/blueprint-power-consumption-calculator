public class Entities {
	private EntityPosition position;

	private String entity_number;

	private String name;

	public EntityPosition getPosition() {
		return position;
	}

	public void setPosition(EntityPosition position) {
		this.position = position;
	}

	public String getEntity_number() {
		return entity_number;
	}

	public void setEntity_number(String entity_number) {
		this.entity_number = entity_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassPojo [position = " + position + ", entity_number = " + entity_number + ", name = " + name + "]";
	}
}