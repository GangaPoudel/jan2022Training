package solid.openclosed;

public class Circle implements Shape {

	public Double radius;

	@Override
	public Double calculateArea() {
		return (22 / 7) * radius * radius;
	}

}
