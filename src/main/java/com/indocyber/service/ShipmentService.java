package com.indocyber.service;

import com.indocyber.dto.ShipmentDto;
import com.indocyber.entity.Shipment;

import java.util.List;

public interface ShipmentService {
    List<Shipment> getAllShipment();
    Shipment getShipmentById(int id);

    void saveShipment(ShipmentDto shipmentDto);
    void updateShipment(Shipment shipment);

    void deleteShipment(int id);
}
