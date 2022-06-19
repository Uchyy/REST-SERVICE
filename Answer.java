package objects;

public class Answer {
	
	private String id;
	private Long count;
	
	public Answer () {
		super();
	}

	public Answer(String id, Long count) {
		super();
		this.id = id;
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCount() {
		return Long.toString(count);
	}

	public void setCount(Long count) {
		this.count = count;
	}
		
}
