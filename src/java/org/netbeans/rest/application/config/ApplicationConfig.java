/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Maharjan
 */
@javax.ws.rs.ApplicationPath("api")
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
        resources.add(com.pagodalabs.app.mapase.api.AccidentLocation.class);
        resources.add(com.pagodalabs.app.mapase.api.CheckingLocation.class);
        resources.add(com.pagodalabs.app.mapase.api.FacebookLogin.class);
        resources.add(com.pagodalabs.app.mapase.api.GCMUsers.class);
        resources.add(com.pagodalabs.app.mapase.api.HelpLocation.class);
        resources.add(com.pagodalabs.app.mapase.api.JamLocation.class);
        resources.add(com.pagodalabs.app.mapase.api.PetrolLocation.class);
        resources.add(com.pagodalabs.app.mapase.api.ReportLocation.class);
        resources.add(com.pagodalabs.app.mapase.api.ServerIP.class);
        resources.add(com.pagodalabs.app.mapase.api.StrikeLocation.class);
        resources.add(com.pagodalabs.app.mapase.api.TestResource.class);
        resources.add(com.pagodalabs.app.mapase.api.WifiLocation.class);
    }
    
}
