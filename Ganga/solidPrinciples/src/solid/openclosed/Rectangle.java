package solid.openclosed;

public class Rectangle implements Shape {

	Double length;
	Double width;

	@Override
	public Double calculateArea() {
		return length * width;
	}

}
