package simulation.data;

import java.util.*;

public class Helpers {

    Set<Integer> xSet = new HashSet<>();
    Set<Integer> ySet = new HashSet<>();

    public Integer getRandomInt(Integer to, String type) {
        Set<Integer> targetSet = "x".equals(type) ? xSet : ySet;
        Random random = new Random();

        Integer result;
        do {
            result = random.nextInt(to - 1);
        } while (targetSet.contains(result)); // Генерируем, пока не найдем уникальное

        targetSet.add(result);
        return result + 1;
    }

    public int findPathLength(int start, int end) {

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

    public  int findPathLength(Point start, Point end) {
        int x = findPathLength(start.getX(), end.getX());
        int y = findPathLength(start.getY(), end.getY());

        return Math.max(x, y);
    }

    private void findPath(int start, int end, List<Integer> coordinates) {

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

    public List<Point> generateCoordinates(Point start, Point end) {
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
        int findPathLength = findPathLength(start, end);

        for (int i = 0; i < stepsLength; i++) {
            int x = i > xList.size() - 1 ? xList.get(xList.size() - 1) : xList.get(i);
            int y = i > yList.size() - 1 ? yList.get(yList.size() - 1) : yList.get(i);

            pointList.add(new Point(x, y));
        }

//        pointList.add(end);
//        pointList.add(0,start);

        return pointList;

    }

    public Point generateNextStepCoordinates(Point start, Point end) {
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
        int findPathLength = findPathLength(start, end);

        for (int i = 0; i < 1; i++) {
            int x = i > xList.size() - 1 ? xList.get(xList.size() - 1) : xList.get(i);
            int y = i > yList.size() - 1 ? yList.get(yList.size() - 1) : yList.get(i);

            pointList.add(new Point(x, y));
        }

//        pointList.add(end);
//        pointList.add(0,start);

        return pointList.get(0);

    }
}
