package POJO;

public class createNewRepo {
	

private String name;
private String description;
private String homepage;

public createNewRepo(String name, String description, String homepage) {
	this.name = name;
	this.description = description;
	this.homepage = homepage;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getHomepage() {
	return homepage;
}
public void setHomepage(String homepage) {
	this.homepage = homepage;
}

}
