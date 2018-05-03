/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import java.io.Serializable;

/**
 *
 * @author janus
 */
public class Credentials implements Serializable {
    private String username;
    private String password;
    
    protected String getUsername(){
        return this.username;
    }
    protected String getPassword(){
        return this.password;
    }
    
}
