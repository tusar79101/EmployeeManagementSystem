package myproject;

public final class Point {

    private static final int GAP = 20;
    private int x;
    private int y;

    public Point() {
    }

    public Point shiftXAxis(int width) {
        this.x += width + GAP;
        return this;
    }

    public Point shiftYAxis(int height) {
        this.y += height + GAP;
        return this;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
