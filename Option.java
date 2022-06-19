package objects;

public class Option {
		
		private String id;
		private String Text;
		
		public Option () {
			super();
		}
		
		public Option(String text, String id) {
			super();
			Text = text;
			this.id = id;
		}

		public String getText() {
			return Text;
		}

		public void setText(String text) {
			Text = text;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		
		
}
