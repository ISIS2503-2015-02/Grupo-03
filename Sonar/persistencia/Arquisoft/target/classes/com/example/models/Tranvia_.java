package com.example.models;

import com.example.models.Emergencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Tranvia.class)
public class Tranvia_ { 

    public static volatile SingularAttribute<Tranvia, Integer> id;
    public static volatile SingularAttribute<Tranvia, Integer> panico;
    public static volatile SingularAttribute<Tranvia, String> coordenada;
    public static volatile SingularAttribute<Tranvia, Integer> choque;
    public static volatile SingularAttribute<Tranvia, String> linea;
    public static volatile SingularAttribute<Tranvia, Integer> tempatura;
    public static volatile SingularAttribute<Tranvia, Integer> kilometraje;
    public static volatile SingularAttribute<Tranvia, Emergencia> emergencia;

}