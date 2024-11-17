package staticmethods;


import patterns.bridge.ObjText;
import patterns.bridge.Text;

public class StringUtils {
	public static String capitalize(String name) {
		return name.toUpperCase();
	}
	

	public static String lowercase(String name) {
		return name.toLowerCase();
	}
	
	static class LowerText implements Text{
		Text origin;
		
		public LowerText(Text origin){
			this.origin = origin;
		}

		@Override
		public String text() {
			return this.origin.text().toLowerCase();
		}
	}
	
	 static class Capital implements Text{
		Text origin;
		
		public Capital(Text origin){
			this.origin = origin;
		}

		@Override
		public String text() {
			return this.origin.text().toUpperCase();
		}
	}
	public static void main(String args[]) {
		String name = "Glenn";
		System.out.println(capitalize(name));
		System.out.println(lowercase(name));
		
		Text txt = new LowerText(new Capital(new ObjText(name)));
		System.out.println(txt.text());
		
	}
 }
