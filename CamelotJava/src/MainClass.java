import com.storygraph.*;

// hello


public class MainClass {
	public static void main(String[] args) {
		try {
		System.out.println("Kevin");
		var story = new ShortStory();
		var graph = new Graph();
		var currentNode = story.getRoot();
		var map = story.getMap();
		while(true) {
			currentNode = graph.traverse(currentNode, map);
			if(currentNode==null)
				break;
		}
		System.out.println("Bye");
		}
		catch(Exception e) {
			System.out.println("Bruh");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
}
