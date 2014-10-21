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

package tw.examples.entities;

import hengine.*;
/**
 *
 * @author yew_mentzaki
 */
public class Box extends EntityType{

    public Box() {
        super(0, "box");
    }

    @Override
    public void tick(Entity e) {
        Var<Double> vy = new Var<Double>(e, "vy");
        vy.s(vy.g()+0.5);
        e.y += vy.g();
    }
    
}
