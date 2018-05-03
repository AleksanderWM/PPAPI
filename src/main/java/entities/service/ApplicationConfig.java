/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author aleks
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(auth.AuthenticationEndpoint.class);
        resources.add(auth.AuthenticationFilter.class);
        resources.add(entities.service.ProjectsFacadeREST.class);
        resources.add(entities.service.TasksFacadeREST.class);
        resources.add(entities.service.UsersFacadeREST.class);
        resources.add(entities.service.UsertasksFacadeREST.class);
    }
    
}
