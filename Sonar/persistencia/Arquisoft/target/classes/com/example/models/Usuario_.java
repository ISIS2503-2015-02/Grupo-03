package com.example.models;

import com.example.models.Vcub;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-19T15:24:58")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static final SingularAttribute<Usuario, String> nombre;
    public static final SingularAttribute<Usuario, String> direccion;
    public static final SingularAttribute<Usuario, Long> telefono;
    public static final SingularAttribute<Usuario, String> notificacion;
    public static final SingularAttribute<Usuario, Long> documento;
    public static final SingularAttribute<Usuario, String> tipoDocumento;
    public static final SingularAttribute<Usuario, Vcub> bicicleta;
    public static final SingularAttribute<Usuario, String> correo;
    public static final SingularAttribute<Usuario, Long> tarjeta;

}