package com.climpia.ventasclimpia.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Reinaldo Carrillo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcli", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcli", nullable = false)
    private Cliente cliente;

    @Size(max = 30)
    @NotNull
    @Column(name = "usuario", nullable = false, length = 30)
    private String usuario;

    @Size(max = 40)
    @NotNull
    @Column(name = "clave", nullable = false, length = 40)
    private String clave;

    @NotNull
    @Column(name = "estado", nullable = false, precision = 2)
    private BigDecimal estado;

}