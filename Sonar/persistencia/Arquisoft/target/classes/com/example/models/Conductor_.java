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

    public static final SingularAttribute<Conductor, String> nombre;
    public static final SingularAttribute<Conductor, Mobibus> mobibus;
    public static final SingularAttribute<Conductor, Tranvia> tranvia;
    public static final SingularAttribute<Conductor, ArrayList> tiempos;
    public static final SingularAttribute<Conductor, Double> promedio;
    public static final SingularAttribute<Conductor, Ruta> ruta;
    public static final SingularAttribute<Conductor, Long> cc;

}