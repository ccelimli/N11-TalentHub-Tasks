package org.n11;


import org.n11.service.service.SystemService;
import org.n11.service.serviceImp.BuildingServiceImp;
import org.n11.service.serviceImp.SystemServiceImp;

public class Main {
    public static void main(String[] args) {

        new SystemServiceImp(new BuildingServiceImp()).start();
    }
}
