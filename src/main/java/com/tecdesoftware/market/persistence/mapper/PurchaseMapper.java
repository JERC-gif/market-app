package com.tecdesoftware.market.persistence.mapper;

import com.tecdesoftware.market.domain.Purchase;
import com.tecdesoftware.market.persistence.entity.Compra;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clienteId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "productos", target = "items"),
            @Mapping(target = "state", expression = "java(compra.getEstado() != null && compra.getEstado() ? \"ACTIVE\" : \"INACTIVE\")")
    })
    Purchase toPurchase(Compra compra);

    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "estado", expression = "java(purchase.getState() != null && purchase.getState().equalsIgnoreCase(\"ACTIVE\"))")
    Compra toCompra(Purchase purchase);
}
