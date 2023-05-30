package robomouse;

public class Click {
    private int xpos;
    private int ypos;
    private int times;
    private boolean rightClick;
    private int delay;

    public Click(int xpos, int ypos, int times, boolean rightClick, int delay) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.times = times;
        this.rightClick = rightClick;
        this.delay = delay;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public boolean isRightClick() {
        return rightClick;
    }

    public void setRightClick(boolean rightClick) {
        this.rightClick = rightClick;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Click{" +
                "xpos=" + xpos +
                ", ypos=" + ypos +
                ", times=" + times +
                ", rightClick=" + rightClick +
                ", delay=" + delay +
                '}';
    }
}
