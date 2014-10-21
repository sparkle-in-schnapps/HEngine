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
public class Data {
    private ArrayList<Object> values = new ArrayList<Object>();
    private ArrayList<String> names = new ArrayList<String>();

    public Data() {
    }
    
    /*
    * @Setting parameter's value.
    */
    public void s(String name, Object value){
        names.add(name);
        values.add(value);
    }
    /*
    * @Getting value as Object. If value isn't exists, return default value.
    */
    
    public Object go(String name, Object default_value){
        int i = names.indexOf(name);
        if(i!=-1){
            return values.get(i);
        }else{
            return default_value;
        }  
    }
    /*
    * @Getting value as Object.
    */
    public Object go(String name){
        return go(name, null);
    }
    /*
    * @Getting value as Object. If value isn't exists, return default value.
    */
    public int gi(String name, int default_value){
        return (Integer)(go(name, default_value));
    }
    public int gi(String name){
        return (Integer)(go(name, 0));
    }
    public double gd(String name, double default_value){
        return (Double)(go(name, default_value));
    }
    public double gd(String name){
        return (Double)(go(name, 0));
    }
    
}
