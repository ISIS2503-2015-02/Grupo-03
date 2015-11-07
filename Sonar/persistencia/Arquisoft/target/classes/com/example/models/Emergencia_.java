package com.example.models;

import com.example.models.Ubicacion;
import com.example.models.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Emergencia.class)
public class Emergencia_ { 

    public static volatile SingularAttribute<Emergencia, Integer> id;
    public static volatile ListAttribute<Emergencia, Vehiculo> VehiculosInvolucrados;
    public static volatile SingularAttribute<Emergencia, Date> fecha;
    public static volatile SingularAttribute<Emergencia, String> descripcion;
    public static volatile SingularAttribute<Emergencia, String> magnitud;
    public static volatile SingularAttribute<Emergencia, String> consecuencia;
    public static volatile SingularAttribute<Emergencia, Ubicacion> ubicacion;

}