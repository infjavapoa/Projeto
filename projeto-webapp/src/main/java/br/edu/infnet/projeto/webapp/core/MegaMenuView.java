package br.edu.infnet.projeto.webapp.core;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MegaMenuView {
  
    private String orientation = "horizontal";
 
    public String getOrientation() {
        return orientation;
    }
 
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
