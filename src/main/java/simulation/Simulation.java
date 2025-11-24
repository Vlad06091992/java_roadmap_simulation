package simulation;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public static void main(String[] args) {
//        Field field = new Field(20, 20);
//
//        field.showMap();


        System.out.println(generateCoordinates(new Point(2,16), new Point(2,1)));

    }

    public static int findPathLength(int start, int end) {

        int count = 0;

        if (start == end) {
            count++;
        }

        if (start == end - 1) {
            count++;
        }

        if (end == start - 1) {
            count++;
        }

        if (start < end) {
            for (int i = start + 1; i < end; i++) {
                count++;

            }
        } else if (start > end) {
            for (int i = start - 1; i > end; i--) {
                count++;
            }
        }

        return count;
    }
    public static int findPathLengthSSS(Point start, Point end) {
        int x = findPathLength(start.getX(),end.getX());
        int y = findPathLength(start.getY(),end.getY());

        return Math.max(x,y);
    }
    public static void findPath(int start, int end, List<Integer> coordinates) {

        if (start == end) {
            coordinates.add(start);
        }

        if (start == end - 1) {
            coordinates.add(end);
        }

        if (end == start - 1) {
            coordinates.add(start);
        }

        if (start < end) {
            for (int i = start + 1; i < end; i++) {
                coordinates.add(i);

            }
        } else if (start > end) {
            for (int i = start - 1; i > end; i--) {
                coordinates.add(i);
            }
        }
    }
    public static List<Point> generateCoordinates(Point start, Point end) {
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        List<Point> pointList = new ArrayList<>();

        int xStart = start.getX();
        int yStart = start.getY();

        int xEnd = end.getX();
        int yEnd = end.getY();



        findPath(xStart, xEnd, xList);
        findPath(yStart, yEnd, yList);

        int stepsLength = Math.max(xList.size(), yList.size());
        int findPathLengthSSS = findPathLengthSSS(start, end);

        System.out.println(stepsLength == findPathLengthSSS);
        System.out.println("Количество шагов:" + stepsLength + "дубль " + findPathLengthSSS);


        for(int i = 0; i < stepsLength; i++){
            int x = i > xList.size() -1 ?  xList.get(xList.size() -1) : xList.get(i);
            int y = i > yList.size() -1 ?  yList.get(yList.size() -1) : yList.get(i);

            pointList.add(new Point(x,y ));
        }

//        pointList.add(end);
//        pointList.add(0,start);

        return pointList;

    }
}

//x  x1 x2 x3 x4 x5 x6 x7 x8
//y1
//y2
//y3
//y4
//y5
//y6
//y7 x
//y8      x



//package simulation;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Simulation {
//
//    public static void main(String[] args) {
////        Field field = new Field(20, 20);
////
////        field.showMap();
//
//
//        System.out.println(findPath(new Point(10,4), new Point(1,8)));
//
//    }
//
//    public static List<Point> generateCoordinates(Point start, Point end) {
//        List<Point> path = new ArrayList<>();
//
//        List<Integer> xList = new ArrayList<>();
//        List<Integer> yList = new ArrayList<>();
//
//
//        List<Point> pointList = new ArrayList<>();
//
//        int xStart = start.getX();
//        int yStart = start.getY();
//
//        int xEnd = end.getX();
//        int yEnd = end.getY();
//
//
//
//        if (xStart < xEnd) {
//            for (int i = xStart + 1; i < xEnd; i++) {
//                xList.add(i);
//
//            }
//        } else if (xStart > xEnd) {
//            for (int i = xStart - 1; i > xEnd; i--) {
//                xList.add(i);
//            }
//        }
//
//        if (yStart < yEnd) {
//            for (int i = yStart + 1; i < yEnd; i++) {
//                yList.add(i);
//
//            }
//        } else if (yStart > yEnd) {
//            for (int i = yStart - 1; i > yEnd; i--) {
//                yList.add(i);
//            }
//        }
//
//        int stepsLength = Math.max(xList.size(), yList.size());
//
//
//        for(int i = 0; i < stepsLength; i++){
//            int x = i > xList.size() -1 ?  xList.get(xList.size() -1) : xList.get(i);
//            int y = i > yList.size() -1 ?  yList.get(yList.size() -1) : yList.get(i);
//
//            pointList.add(new Point(x,y ));
//        }
//
//        return pointList;
//
//    }
//
//    public static List<Point> findPath(Point start, Point end) {
//        List<Point> path = new ArrayList<>();
//
//        List<Integer> xList = new ArrayList<>();
//        List<Integer> yList = new ArrayList<>();
//
//
//        List<Point> pointList = new ArrayList<>();
//
//        int xStart = start.getX();
//        int yStart = start.getY();
//
//        int xEnd = end.getX();
//        int yEnd = end.getY();
//
//
//
//        if (xStart < xEnd) {
//            for (int i = xStart + 1; i < xEnd; i++) {
//                xList.add(i);
//
//            }
//        } else if (xStart > xEnd) {
//            for (int i = xStart - 1; i > xEnd; i--) {
//                xList.add(i);
//            }
//        }
//
//        if (yStart < yEnd) {
//            for (int i = yStart + 1; i < yEnd; i++) {
//                yList.add(i);
//
//            }
//        } else if (yStart > yEnd) {
//            for (int i = yStart - 1; i > yEnd; i--) {
//                yList.add(i);
//            }
//        }
//
//        int stepsLength = Math.max(xList.size(), yList.size());
//
//
//        for(int i = 0; i < stepsLength; i++){
//            int x = i > xList.size() -1 ?  xList.get(xList.size() -1) : xList.get(i);
//            int y = i > yList.size() -1 ?  yList.get(yList.size() -1) : yList.get(i);
//
//            pointList.add(new Point(x,y ));
//        }
//
//        return pointList;
//
//    }
//}
//
////x  x1 x2 x3 x4 x5 x6
////y1
////y2       e
////y3           3  2
////y4                 s
////y5
////y5