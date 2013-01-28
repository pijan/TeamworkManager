package cz.uhk.teamworkmanager.model;

import java.io.Serializable;
import javax.persistence.*;
 
/**
 * The persistent class for the AUTHORITIES database table.
 *
 */
@Entity
@Table(name="authorities")
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    private String username;
    private String authority;  //Spring Security demands them to start with "ROLE_"
 
    //bi-directional one-to-one association to User
    @OneToOne(mappedBy="authority")
    private User user;
 
    public Authority() {
    }
    
    public Authority(String username, String authority){
    
    	this.username = username;
    	this.authority = authority;
    
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getAuthority() {
        return this.authority;
    }
 
    public void setAuthority(String authority) {
        this.authority = authority;
    }
 
    public User getUser() {
        return this.user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
}
