package com.example.models;

import com.example.models.Emergencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Tranvia.class)
public class Tranvia_ { 

    public static final SingularAttribute<Tranvia, Integer> id;
    public static final SingularAttribute<Tranvia, Integer> panico;
    public static final SingularAttribute<Tranvia, String> coordenada;
    public static final SingularAttribute<Tranvia, Integer> choque;
    public static final SingularAttribute<Tranvia, String> linea;
    public static final SingularAttribute<Tranvia, Integer> tempatura;
    public static final SingularAttribute<Tranvia, Integer> kilometraje;
    public static final SingularAttribute<Tranvia, Emergencia> emergencia;

}