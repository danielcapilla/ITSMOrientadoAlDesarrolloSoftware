package com.tuempresa.itsmorientadoaldesarrollosoftware.modelo;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@MappedSuperclass // Marcada como una superclase mapeada en vez de como una entidad
@Getter @Setter
public class Identificable {
 
    @Id @GeneratedValue(generator="system-uuid") @Hidden
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid; // oid para la clase maestra
 
    @Column(length=50)
    String nombre;
}
