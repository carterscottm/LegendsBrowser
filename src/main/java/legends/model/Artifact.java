package legends.model;

import legends.helper.EventHelper;

public class Artifact {
	private int id;
	private String name;
	private String item;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return EventHelper.name(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "["+id+"] "+name+" ("+item+")";
	}
	
	public String getLink() {
		return "<a href=\"/artifact/" + id + "\" class=\"artifact\">" + getName() + "</a>";
	}

}