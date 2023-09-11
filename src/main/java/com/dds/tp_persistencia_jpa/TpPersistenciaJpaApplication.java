package com.dds.tp_persistencia_jpa;

import com.dds.tp_persistencia_jpa.entidades.*;
import com.dds.tp_persistencia_jpa.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class TpPersistenciaJpaApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	DetallePedidoRepositorio detallePedido;
	@Autowired
	DomicilioRepositorio domicilioRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;
	@Autowired
	private DetallePedidoRepositorio detallePedidoRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(TpPersistenciaJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepositorio clienteRepo) {
		return args -> {
			System.out.println("FUNCIONANDO");
			Cliente cliente = Cliente.builder()
					.nombre("Theo")
					.apellido("Pelegrina")
					.telefono("2615151699")
					.email("theopelegrina469@gmail.com")
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Los olivos")
					.numero("14")
					.localidad("Vistalba")
					.build();

			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(6)
					.subtotal(3000)
					.build();

			Producto producto= Producto.builder()
					.tipoProducto("Insumo")
					.tiempoEstimadoCocina(20)
					.denominacion("Pancho")
					.precioVenta(500)
					.precioCompra(200)
					.stockActual(100)
					.stockMinimo(0)
					.unidadMedida("Unidad")
					.receta("Salchicha, pan, condimento")
					.build();

			productoRepositorio.save(producto);

			detallePedido.setProducto(producto);

			Pedido pedido = Pedido.builder()
					.estado("Entregado")
					.fecha(new Date(2023,Calendar.JUNE,9))
					.tipoEnvio("Delivery")
					.total(500)
					.build();

			pedido.agregarDetalle(detallePedido);

			Factura factura = Factura.builder()
					.numero(1)
					.fecha(new Date(2023, Calendar.JUNE,9))
					.descuento(10)
					.formaDePago("Mercado pago")
					.total(3000)
					.build();

			pedido.setFactura(factura);


			Rubro rubro =  Rubro.builder()
					.denominacion("Comida rápida")
					.build();

			rubro.agregarProducto(producto);

			cliente.agregarDomicilio(domicilio);
			cliente.agregarPedido(pedido);

			clienteRepositorio.save(cliente);

		};
	}

}
