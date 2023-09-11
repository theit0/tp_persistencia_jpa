package com.dds.tp_persistencia_jpa.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;
    private Date fecha;
    private String tipoEnvio;
    private double total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "DetallePedido_id")
    @Builder.Default
    private List<DetallePedido> detalles_pedido = new ArrayList<>();
    public void agregarDetalle(DetallePedido det){
        detalles_pedido.add(det);
    }
}
