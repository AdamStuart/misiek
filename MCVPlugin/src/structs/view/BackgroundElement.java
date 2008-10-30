package structs.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

import ding.view.DGraphView;
import ding.view.InnerCanvas;
import ding.view.ViewportChangeListener;

public abstract class BackgroundElement extends JComponent implements ViewportChangeListener {

    protected DGraphView view;
    private double scaleFactor = 1;
    private int XCenter;
    private int YCenter;
    private int Rwidth;
    private int Rheight;

    public BackgroundElement(DGraphView view, int XCenter, int YCenter, int width, int height) {
        this.view = view;
        this.XCenter = XCenter;
        this.YCenter = YCenter;
        this.Rwidth = width;
        this.Rheight = height;

        setBounds(getStartX(), getStartY(), width, height);

        view.addViewportChangeListener(this);
    }

    public void setBounds(double x, double y, double width, double height) {
        setBounds((int) x, (int) y, (int) width, (int) height);
    }

    @Override
    public final void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        doPaint(g2d);
    }

    protected abstract void doPaint(Graphics2D g2d);

    protected java.awt.Shape relativeToBounds(java.awt.Shape s) {
        Rectangle r = getBounds();
        AffineTransform f = new AffineTransform();
        f.translate(-r.x, -r.y);
        return f.createTransformedShape(s);
    }

    protected java.awt.Shape viewportTransform(java.awt.Shape s) {
        InnerCanvas canvas = view.getCanvas();

        AffineTransform f = canvas.getAffineTransform();
        if (f != null) {
            return f.createTransformedShape(s);
        } else {
            return s;
        }
    }

    protected double getCurrentScaleFactor() {
        return scaleFactor;
    }

    public void viewportChanged(int w, int h, double newXCenter, double newYCenter, double newScaleFactor) {
        InnerCanvas canvas = view.getCanvas();

        AffineTransform f = canvas.getAffineTransform();

        if (f == null) {
            return;
        }

        Point2D pstart = f.transform(new Point2D.Double(getStartX(), getStartY()), null);
        setBounds(pstart.getX(), pstart.getY(), Rwidth * newScaleFactor, Rheight * newScaleFactor);
        scaleFactor = newScaleFactor;
    }

    public int getRheight() {
        return Rheight;
    }

    public void setRheight(int Rheight) {
        this.Rheight = Rheight;
    }

    public int getRwidth() {
        return Rwidth;
    }

    public void setRwidth(int Rwidth) {
        this.Rwidth = Rwidth;
    }

    public int getXCenter() {
        return XCenter;
    }

    public void setXCenter(int XCenter) {
        this.XCenter = XCenter;
    }

    public int getYCenter() {
        return YCenter;
    }

    public void setYCenter(int YCenter) {
        this.YCenter = YCenter;
    }

    public int getStartX() {
        return XCenter - Rwidth / 2;
    }

    public int getStartY() {
        return YCenter - Rheight / 2;
    }

    public int getEndX() {
        return XCenter + Rwidth / 2;
    }

    public int getEndY() {
        return YCenter + Rheight / 2;
    }
}
