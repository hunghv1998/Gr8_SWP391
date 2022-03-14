/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Feature {
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return "Feature{" + "id=" + id + ", url=" + url + '}';
    }
    String id;
    String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    

    public Feature(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public Feature() {
    }

}
