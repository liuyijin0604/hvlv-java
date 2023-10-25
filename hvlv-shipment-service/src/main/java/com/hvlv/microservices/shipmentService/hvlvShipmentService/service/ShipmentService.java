package com.hvlv.microservices.shipmentService.hvlvShipmentService.service;

import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.ImportChargeCode;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Org;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Shipment;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.entity.Addr;
import com.hvlv.microservices.shipmentService.hvlvShipmentService.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ShipmentService implements EntityServiceInterface<Shipment>{
    @Autowired
    ShipmentMapper shipmentMapper;
    @Autowired
    AddrMapper addrMapper;
    @Autowired
    OrgMapper orgMapper;
    @Autowired
    ImportChargeCodeMapper importChargeCodeMapper;

    public void setupAllRelations(Shipment shipment){
        int cnor_id = shipment.getCnorId();
        int cnee_id = shipment.getCneeId();
        int receiver_id = shipment.getReceiverId();
        int notify_id = shipment.getNotifyId();
        int agent_id = shipment.getAgentId();

        if (cnor_id > 0) {
            Addr cnorAddress = addrMapper.selectByPrimaryKey(cnor_id);
            if (cnorAddress != null) {
                shipment.setCnor(cnorAddress);
            }
        }
        if (cnee_id > 0) {
            Addr cneeAddress = addrMapper.selectByPrimaryKey(cnee_id);
            if (cneeAddress != null) {
                shipment.setCnee(cneeAddress);
            }
        }
        if (receiver_id > 0) {
            Addr receiverAddress = addrMapper.selectByPrimaryKey(receiver_id);
            if (receiverAddress != null) {
                shipment.setReceiver(receiverAddress);
            }
        }
        if (notify_id > 0) {
            Addr notifierAddress = addrMapper.selectByPrimaryKey(notify_id);
            if (notifierAddress != null) {
                shipment.setNotifier(notifierAddress);
            }
        }
        if (agent_id > 0) {
            Org agentOrg = orgMapper.selectByPrimaryKey(agent_id);
            if (agentOrg != null) {
                shipment.setAgent(agentOrg);
            }
        }
    }

    public Addr getShipmentCnor(Shipment shipment) {
        Addr cnorAddress = shipment.getCnor();
        if (cnorAddress == null){
            int cnor_id = shipment.getCnorId();
            if (cnor_id > 0) {
                cnorAddress = addrMapper.selectByPrimaryKey(cnor_id);
                if (cnorAddress != null) {
                    shipment.setCnor(cnorAddress);
                }
            }
        }
        return cnorAddress;
    }

    public Addr getShipmentCnee(Shipment shipment) {
        Addr cneeAddress = shipment.getCnee();
        if (cneeAddress == null){
            int cnee_id = shipment.getCneeId();
            if (cnee_id > 0) {
                cneeAddress = addrMapper.selectByPrimaryKey(cnee_id);
                if (cneeAddress != null) {
                    shipment.setCnee(cneeAddress);
                }
            }
        }
        return cneeAddress;
    }

    public Addr getShipmentReceiver(Shipment shipment) {
        Addr receiverAddress = shipment.getReceiver();
        if (receiverAddress == null){
            int receiver_id = shipment.getReceiverId();
            if (receiver_id > 0) {
                receiverAddress = addrMapper.selectByPrimaryKey(receiver_id);
                if (receiverAddress != null) {
                    shipment.setReceiver(receiverAddress);
                }
            }
        }
        return receiverAddress;
    }

    public Addr getShipmentNotifier(Shipment shipment) {
        Addr notifierAddress = shipment.getNotifier();
        if (notifierAddress == null){
            int notifier_id = shipment.getNotifyId();
            if (notifier_id > 0) {
                notifierAddress = addrMapper.selectByPrimaryKey(notifier_id);
                if (notifierAddress != null) {
                    shipment.setNotifier(notifierAddress);
                }
            }
        }
        return notifierAddress;
    }

    public Org getShipmentAgent(Shipment shipment) {
        Org AgentOrg = shipment.getAgent();
        if (AgentOrg == null){
            int agent_id = shipment.getAgentId();
            if (agent_id > 0) {
                AgentOrg = orgMapper.selectByPrimaryKey(agent_id);
                if (AgentOrg != null) {
                    shipment.setAgent(AgentOrg);
                }
            }
        }
        return AgentOrg;
    }

    public void setCubeWeight(Shipment shipment) {
        BigDecimal totalCbm = shipment.getCbm().multiply(shipment.getPkg() > 0 ? BigDecimal.valueOf(shipment.getPkg()) : BigDecimal.ONE);
        BigDecimal cubWeight = totalCbm.multiply(new BigDecimal("250"));
        shipment.setCubeWeight(shipment.getWeight().max(cubWeight).setScale(2, RoundingMode.HALF_UP));
    }

    public void setCourierWeight(Shipment shipment) {
        if (shipment.getCubeWeight()== null || shipment.getCubeWeight().compareTo(BigDecimal.ZERO)<=0){
            setCubeWeight(shipment);
        }

        if (shipment.getMdata().containsKey("manifest_weight") && shipment.getMdata().getBigDecimal("manifest_weight").compareTo(BigDecimal.ZERO)>0){
            shipment.setCourierWeight(shipment.getMdata().getBigDecimal("manifest_weight"));
        } else if (shipment.getMdata().containsKey("chargecode") && !shipment.getMdata().getString("chargecode").isEmpty()) {
            String chargecode = shipment.getMdata().getString("chargecode");
            // ImportChargeCode chargeCodeInfo = importChargeCodeMapper.findByChargeCode("6970");
            ImportChargeCode chargeCodeInfo = importChargeCodeMapper.findByChargeCode(chargecode);
            if (chargeCodeInfo != null){
                if (chargeCodeInfo.getChargeWt()>0){
                    shipment.setCourierWeight(shipment.getWeight());
                }
                else {
                    shipment.setCourierWeight(shipment.getCubeWeight());
                }
            }
        }else {
            shipment.setCourierWeight(shipment.getCubeWeight());
        }
    }

    public void setupWeights(Shipment shipment){
        setCubeWeight(shipment);
        setCourierWeight(shipment);
    }

}
