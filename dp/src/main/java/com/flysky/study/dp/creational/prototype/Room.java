package com.flysky.study.dp.creational.prototype;

import com.flysky.study.dp.creational.abstract_factory.em.Direction;

public class Room implements MapSite {

    public Room(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public boolean enter() {
        return false;
    }

    public void setSide(Direction direction, MapSite side) {
        sides[direction.getIndex()] = side;
    }

    @Override
    protected Room clone() {
        try {
            return (Room) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\nRoom{" + this.getClass().getCanonicalName() + "\n");
        sb.append("房间号为：" + no + "\n");
        for (int i = 0; i < sides.length; i++) {
            MapSite side = sides[i];
            Direction direction = Direction.ofByIndex(i);
            sb.append("[" + direction + "方向上的边为" + side + "]\n");
        }

        sb.append("}");
        return sb.toString();
    }

    private MapSite[] sides = new MapSite[4];

    private int no;
}
