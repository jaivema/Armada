package com.armada.armadacider.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Detail {

    @Id
    private String detailId;
    private Date date;
    private String productName;
    private int quantity; //Actualizable
    private float price; //Actualizable
    private int discount; //Actualizable
    private int taxes; //Actualizable
    private float total; //Actualizable
    private boolean isPaid; //Actualizable


   /* idDetalle: int
        - cantidad: int
        - precio: float
        - descuento: int
        - iva: int
        - subtotal (cantidad * precio unitario - descuento + impuestos): float
        - estado (pagado, NOpagado):boolean
        - producto: Producto
        - pedido: Pedido*/

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Product_FK")
    private Product product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PurchaseOrder_FK")
    private PurchaseOrder purchaseOrder;

    /*@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Customer_FK")
    private Customer customer;*/
}
