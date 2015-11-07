package com.example.models;

import com.example.models.Mobibus;
import com.example.models.Ruta;
import com.example.models.Tranvia;
import java.util.ArrayList;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Conductor.class)
public class Conductor_ { 

    public static volatile SingularAttribute<Conductor, String> nombre;
    public static volatile SingularAttribute<Conductor, Mobibus> mobibus;
    public static volatile SingularAttribute<Conductor, Tranvia> tranvia;
    public static volatile SingularAttribute<Conductor, ArrayList> tiempos;
    public static volatile SingularAttribute<Conductor, Double> promedio;
    public static volatile SingularAttribute<Conductor, Ruta> ruta;
    public static volatile SingularAttribute<Conductor, Long> cc;

}