package com.example.missions;

import java.util.*;

public class AffichageArraylist {

    public static void main (String[] args)
    {
        // créer un objet de la classe ArrayList
        ArrayList<String> array_L=new ArrayList<String>();

        // Ajouter des élément dans le ArrayList
        array_L.add("Lundi");
        array_L.add("Mardi");
        array_L.add("Mecredi");

        // Affichage à l'aide d'une boucle forEach
        for(String elem: array_L)
        {
            System.out.println (elem);
        }

    }

}
