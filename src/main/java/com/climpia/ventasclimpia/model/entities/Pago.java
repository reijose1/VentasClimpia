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
@Table(name = "pago")
public class Pago implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpago", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idventa", nullable = false)
    private com.climpia.ventasclimpia.model.entities.Venta idventa;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idmedio", nullable = false)
    private MedioPago idmedio;

    @Size(max = 100)
    @NotNull
    @Column(name = "detalle", nullable = false, length = 100)
    private String detalle;

    @NotNull
    @Column(name = "importe", nullable = false, precision = 10, scale = 2)
    private BigDecimal importe;

    @Size(max = 1000)
    @NotNull
    @Column(name = "observaciones", nullable = false, length = 1000)
    private String observaciones;

}