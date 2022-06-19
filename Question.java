package objects;

import java.util.List;

public class Question  {
	
	private String id;
	private String Text;
	
	public Question () {
		super();
	}

	public Question(String id, String text) {
		super();
		this.id = id;
		Text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}
	
	

}
