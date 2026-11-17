import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.util.ArrayList;

public class compoundShapeIterator implements PathIterator{
	private ArrayList<Shape> shapes;
	private int currentIndex = 0;
	private PathIterator currentIterator;
			
	public compoundShapeIterator(ArrayList<Shape> shapes, AffineTransform at) {
		this.shapes = shapes;
		if (!shapes.isEmpty()) {
			currentIterator = shapes.get(0).getPathIterator(at);
		}
	}

	@Override
	public int getWindingRule() {
	  return PathIterator.WIND_NON_ZERO;
	}

	@Override
	public boolean isDone() {
		return currentIndex >= shapes.size();
	}

	@Override
	public void next() {
		if (currentIterator == null) return;
		
		currentIterator.next();
		if (currentIterator.isDone()) {
			currentIndex++;
			if (currentIndex < shapes.size()) {
				currentIterator = shapes.get(currentIndex).getPathIterator(null);
			}
		}
	}

	@Override
	public int currentSegment(float[] coords) {
		return currentIterator.currentSegment(coords);
	}

	@Override
	public int currentSegment(double[] coords) {
		return currentIterator.currentSegment(coords);
	}

}
