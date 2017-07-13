package GenericGraph;

/*
* This will used when Data passed is not a primitive type I am trying to male
* code as generic as possible
*/

public class DATA_TYPE {
	public String type;
	public int rating;

	public DATA_TYPE(String t, int r) {
		type = t;
		rating = r;
	}

	public String toString() {
		return type + " - " + rating;
	}
}
