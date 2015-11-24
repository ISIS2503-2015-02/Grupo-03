package com.example.models;

import com.example.models.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-23T22:28:39")
@StaticMetamodel(Reporte.class)
public class Reporte_ { 

    public static volatile SingularAttribute<Reporte, Integer> id;
    public static volatile SingularAttribute<Reporte, Date> fecha;
    public static volatile SingularAttribute<Reporte, Vehiculo> vehiculo;

}