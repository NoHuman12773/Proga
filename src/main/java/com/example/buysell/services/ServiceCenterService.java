package com.example.buysell.services;

import com.example.buysell.models.*;
import com.example.buysell.repositories.ServiceCenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
@RequiredArgsConstructor
public class ServiceCenterService {

    @Autowired
    private ServiceCenterRepository serviceCenterRepository;

    public List<Service> getServices() {
        return serviceCenterRepository.findAllServices();
    }

    public List<Client> getClients() {
        return serviceCenterRepository.findAllClients();
    }

    public ClientCard getClientCard(Long clientId) {
        return serviceCenterRepository.findClientById();
    }

    public List<SparePart> calculateServicesCost(Date startDate, Date endDate) {
        return  serviceCenterRepository.getSpareParts(startDate, endDate);
    }

    public List<Master> calculateRepairsCostByMaster(Long masterId) {
        return serviceCenterRepository.findAllMasters();
    }

    public RepairReport getRepairReport(Long repairId) {
        return (RepairReport) serviceCenterRepository.findSparePartsByRepairId();
    }

    public List<SparePart> getSparePartsUsed(Date startDate, Date endDate) {
        return serviceCenterRepository.getSpareParts(startDate, endDate);
    }

    public List<SparePart> calculateSparePartsCostForRepair(Long repairId) {
        return serviceCenterRepository.findSparePartsByRepairId();
    }

    public List<Master> getMasters() {
        return serviceCenterRepository.findAllMasters();
    }
}