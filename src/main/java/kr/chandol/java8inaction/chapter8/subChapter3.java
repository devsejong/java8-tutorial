package kr.chandol.java8inaction.chapter8;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class subChapter3 {

    public static class Point {
        public final static Comparator<Point> compareByXAndThenY
                = comparing(Point::getX).thenComparing(Point::getY);

        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Point moveRightBy(int x) {
            return new Point(this.x + x, this.y);
        }

        public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
            return points.stream().map(p -> new Point(p.getX() + x, p.getY())).collect(toList());
        }
    }

}
