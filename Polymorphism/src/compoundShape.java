import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class compoundShape implements Shape{
	private ArrayList<Shape> shapes = new ArrayList<>();
	
	public compoundShape() {
		shapes.add(new Rectangle2D.Double(10,10,50,30));
		shapes.add(new Ellipse2D.Double(30, 30, 40, 40));
		shapes.add(new Line2D.Double(0, 0, 60, 60));
		
	}
	
	public void addShape(Shape s) {
		shapes.add(s);
	}

	@Override
	public Rectangle getBounds() {
		return getBounds2D().getBounds();
	}

	@Override
	public Rectangle2D getBounds2D() {
		if (shapes.isEmpty()) return new Rectangle2D.Double();
		
		Rectangle2D bounds = null;
		for (Shape s : shapes) {
			if (bounds == null) {
				bounds = (Rectangle2D) s.getBounds2D().clone();
			}else {
				bounds.add(s.getBounds2D());
			}
		}
		return bounds;
	}

	@Override
	public boolean contains(double x, double y) {
		for (Shape s : shapes) {
			if (s.contains(x, y))return true;
		}
		return false;
	}

	@Override
	public boolean contains(Point2D p) {
		return contains(p.getX(), p.getY());
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		for (Shape s : shapes) {
			if (s.intersects(x, y, w, h)) return true;
		}
	
		return false;	
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		for (Shape s : shapes) {
			if (s.intersects(r))return true;
		}
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		for (Shape s : shapes) {
			if (s.contains(x, y, w, h))return true;
		}
		return false;
	}

	@Override
	public boolean contains(Rectangle2D r) {
		for (Shape s : shapes) {
			if (s.contains(r)) return true;
		}
		return false;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return new compoundShapeIterator(shapes, at);
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return new compoundShapeIterator(shapes, at);
	}
	

}
