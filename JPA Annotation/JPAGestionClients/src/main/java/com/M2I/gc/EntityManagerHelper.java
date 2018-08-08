package com.M2I.gc;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {//singleton
    private static EntityManagerFactory entityManagerFactory;//singleton par factory

    static //charger dès que tu lance l'application (implicitement hager
    {
        try {
        	//Chargement de persistence.xml avec <persistence-unit name="hsql" ..>
            entityManagerFactory= Persistence.createEntityManagerFactory("hsql");// va chercher la configuration
																				//	dans le xml dans le load

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
}