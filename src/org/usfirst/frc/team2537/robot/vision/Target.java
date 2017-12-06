package org.usfirst.frc.team2537.robot.vision;

public class Target {
	private Point[] points;
	public Target(Point[] points) {
		this.points=points;
	}
	public Point[] getPoints() {
		return points;
	}
	public Point[] getBoundingBox() {
		//must be run with at least 4 points in the target for no duplicates to occur
		Point mostLeft=new Point(0, 0);
		Point mostRight=new Point(0, 0);
		Point mostUp=new Point(0, 0);
		Point mostDown=new Point(0,0);
		Point[] extremaArr=new Point[4];
		int leftX=Integer.MAX_VALUE;
		int rightX=Integer.MIN_VALUE;
		int upY=Integer.MIN_VALUE;
		int downY=Integer.MAX_VALUE;
		for (int i=0; i < points.length; i++) {
			if (points[i].getX() < leftX) {
				mostLeft=new Point(points[i].getX(),points[i].getY());
				leftX=points[i].getX();
			}
			if (points[i].getX() > rightX) {
				mostRight=new Point(points[i].getX(),points[i].getY());
				rightX=points[i].getX();
			}
			if (points[i].getY() > upY) {
				mostUp=new Point(points[i].getX(),points[i].getY());
				upY=points[i].getY();
			}
			if (points[i].getY() < downY) {
				mostDown=new Point(points[i].getX(),points[i].getY());
				downY=points[i].getY();
			}
		}
		extremaArr[0]=mostLeft;
		extremaArr[1]=mostRight;
		extremaArr[2]=mostUp;
		extremaArr[3]=mostDown;
		return extremaArr;
	}
}
