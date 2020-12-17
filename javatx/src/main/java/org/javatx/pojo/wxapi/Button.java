/**
  * Copyright 2020 bejson.com 
  */
package org.javatx.pojo.wxapi;
import java.util.List;

/**
 * Auto-generated: 2020-08-22 9:47:45
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Button {

    private String name;
    private List<Sub_button> sub_button;
    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setSub_button(List<Sub_button> sub_button) {
         this.sub_button = sub_button;
     }
     public List<Sub_button> getSub_button() {
         return sub_button;
     }

}