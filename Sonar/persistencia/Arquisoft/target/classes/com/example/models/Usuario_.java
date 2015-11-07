package com.example.models;

import com.example.models.Vcub;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, Long> telefono;
    public static volatile SingularAttribute<Usuario, String> notificacion;
    public static volatile SingularAttribute<Usuario, Long> documento;
    public static volatile SingularAttribute<Usuario, String> tipoDocumento;
    public static volatile SingularAttribute<Usuario, Vcub> bicicleta;
    public static volatile SingularAttribute<Usuario, String> correo;
    public static volatile SingularAttribute<Usuario, Long> tarjeta;

}