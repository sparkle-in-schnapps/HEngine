/*
 * Copyright (C) 2014 yew_mentzaki
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package hengine;

/**
 *
 * @author yew_mentzaki
 */
public final class Entity extends Data{

    public double x, y;
    public double width, height;
    public EntityType et;
    public boolean phantom;
    public World w;

    public Entity(EntityType et, World w) {
        this.w = w;
        this.et = et;
    }

    public void remove(){
        w.removeEntity(this);
    }
    
    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the phantom
     */
    public boolean isPhantom() {
        return phantom;
    }

    /**
     * @param phantom the phantom to set
     */
    public void setPhantom(boolean phantom) {
        this.phantom = phantom;
    }

    /**
    * Will be called 10 times per second when game isn't paused.
    */
    void tick() {
        et.tick(this);
    }

    /*
    * Will be called from render-thread. Use it to 
    */
    void render() {
        et.render(this);
    }
    
    
    
    
}
