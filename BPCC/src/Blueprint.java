public class Blueprint {
	private String item;

	private Icons[] icons;

	private Entities[] entities;

	private String version;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Icons[] getIcons() {
		return icons;
	}

	public void setIcons(Icons[] icons) {
		this.icons = icons;
	}

	public Entities[] getEntities() {
		return entities;
	}

	public void setEntities(Entities[] entities) {
		this.entities = entities;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ClassPojo [item = " + item + ", icons = " + icons + ", entities = " + entities + ", version = "
				+ version + "]";
	}
}
