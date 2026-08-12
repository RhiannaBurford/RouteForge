//Inheritance

public class VolumeHold extends Hold {
	//additional private attributes
    private String name;
    private String size;

    public VolumeHold(int holdDiff, String imagePath, String name, String size) {
    	//referencing the parent class and inheriting attributes
    	super(holdDiff, imagePath);
        this.name = name;
        this.size = size;
	}
    //getters
	public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }
    //setters
    public void setName(String name) {
		this.name = name;
	}
    public void setSize(String size) {
		this.size = size;
	}
}

