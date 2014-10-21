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
public class Var<T> {
    Data d;
    String name;

    public Var(Data d, String name) {
        this.d = d;
        this.name = name;
    }
    public T g(){
        return (T) d.go(name);
    }
    public void s(Object value){
        d.s(name, value);
    }
    
}
