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

import org.lwjgl.examples.spaceinvaders.Texture;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author yew_mentzaki
 */
public abstract class Block {
    /*
     STATIC
     */

    public static int block_size; // size of blocks in that game.

    public static enum IwE /*Interaction with entities*/ {

        PHANTOM, SOLID, LIQUID, OTHER
    };
    public static final IwE PHANTOM = IwE.PHANTOM, //Entities go trough it without any collision
            SOLID = IwE.SOLID, //Entities can not go trough it
            LIQUID = IwE.LIQUID, //Entities may sweam in it
            OTHER = IwE.OTHER;   //You will handle collision youself

    //List of all block types in that game.
    private static final Block[] blocks = new Block[256];
    /*
     PARAMS
     */
    protected IwE iwe = PHANTOM;
    protected byte id = (byte) 0;
    protected String name;
    protected Texture texture;
    /*
     METHODS
     */
    
    /*
     @original constructor. Register block in game with it. 
     */
    public Block(int id) {
        this.id = (byte) id;
        blocks[(byte) id] = this;
    }
    
    /*
    @Original initialization. Will be called from render thread - load texture here.
    */
    public void init(){
        
    }
    
    /*
     @original render method. May be overrided.
     */
    public void render(int x, int y, int z) {
        texture.bind();
        glBegin(GL_QUADS);
        glVertex2i(x - block_size / 2, y - block_size / 2);
        glTexCoord2f(0f, 0f);
        glVertex2i(x + block_size / 2, y - block_size / 2);
        glTexCoord2f(texture.getWidth(), 0f);
        glVertex2i(x + block_size / 2, y + block_size / 2);
        glTexCoord2f(texture.getWidth(), texture.getHeight());
        glEnd();
    }
    /*
     @collision hadler, do not touch. Use next method if you want to do anything.
     */

    public final void entityIsTouch_collision(Entity e, int x, int y, int z) {
        switch (iwe) {
            case SOLID:
                if(e.getX() < x){
                    int a = (int) ((e.getWidth() + block_size)/2 - (x - e.getX()));
                    e.setX(e.getX() - a);
                }else if(e.getX() > x){
                    int a = (int) ((e.getWidth() + block_size)/2 - (e.getX() - x));
                    e.setX(e.getX() + a);
                }
                break;
            default:

        }
        entityIsTouch(e, x, y, z);
    }
    /*
     @entity's touch handler. May be owerrided.
     */

    public void entityIsTouch(Entity e, int x, int y, int z) {

    }
}
