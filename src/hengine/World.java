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

import java.util.ArrayList;

/**
 *
 * @author yew_mentzaki
 */
public class World {
     private final ArrayList<Entity> entities = new ArrayList<Entity>();
     public Entity addEntity(EntityType e){
         Entity i = new Entity(e, this);
         entities.add(i);
         return i;
     }
     Entity removeEntity(Entity e){
         entities.remove(e);
         return e;
     }
     public Entity[] getEntities(){
         Object[] o = entities.toArray();
         Entity[] e = new Entity[o.length];
         for (int i = 0; i < o.length; i++) {
             e[i] = (Entity)o[i];
         }
         return e;
     }
     public void tick(){
         for (Entity e : getEntities()) {
             e.tick();
         }
     }
     public void render(){
         for (Entity e : getEntities()) {
             e.render();
         }
     }
     
     
}
