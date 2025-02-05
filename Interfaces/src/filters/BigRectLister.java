package filters;

import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(4, 2));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(6, 2));
        rectangles.add(new Rectangle(3, 4));
        rectangles.add(new Rectangle(1, 5));
        rectangles.add(new Rectangle(7, 1));
        rectangles.add(new Rectangle(2, 6));

        BigRectangleFilter filter = new BigRectangleFilter();
        System.out.println("Rectangles with a perimeter > 10:");

        for (Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                System.out.println("Rectangle: Width=" + rect.width + ", Height=" + rect.height);
            }
        }
    }
}
