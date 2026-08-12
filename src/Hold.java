
public class Hold {
	private int holdDiff;
	private String imagePath;

	public Hold(int holdDiff, String imagePath) {
		 this.holdDiff = holdDiff;
	     this.imagePath = imagePath;
	}
	public void setHoldDiff(int holdDiff) {
		this.holdDiff = holdDiff;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getHoldDiff() {
		return this.holdDiff;
	}
	public String getImagePath() {
		return this.imagePath;
	}
}
