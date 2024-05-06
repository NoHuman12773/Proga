package com.example.buysell.controllers;

import com.example.buysell.models.*;
import com.example.buysell.services.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/service-center")
public class ServiceCenterController {

    @Autowired
    private ServiceCenterService serviceCenterService;

    // 1. Выдать список предоставляемых услуг (название, цена)
    @GetMapping("/services")
    public List<Service> getServices() {
        return serviceCenterService.getServices();
    }

    // 2. Вывести список всех клиентов, с персональными данными
    @GetMapping("/clients")
    public List<Client> getClients() {
        return serviceCenterService.getClients();
    }

    // 3. Сформировать карточку клиента с отражением всех обращений в сервисный центр
    @GetMapping("/clients/{clientId}/card")
    public ClientCard getClientCard(@PathVariable Long clientId) {
        return serviceCenterService.getClientCard(clientId);
    }

    // 4. Рассчитать стоимость всех выполненных услуг за заданный период времени
    @GetMapping("/services/cost/{startDate}/{endDate}")
    public List<SparePart> calculateServicesCost(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return serviceCenterService.calculateServicesCost(startDate, endDate);
    }

    // 5. Рассчитать стоимость ремонтов, выполненных заданным мастером
    @GetMapping("/masters/{masterId}/repairs/cost")
    public List<Master> calculateRepairsCostByMaster(@PathVariable Long masterId) {
        return serviceCenterService.calculateRepairsCostByMaster(masterId);
    }

    // 6. Сформировать справку по заданному ремонту
    @GetMapping("/repairs/{repairId}/report")
    public RepairReport getRepairReport(@PathVariable Long repairId) {
        return serviceCenterService.getRepairReport(repairId);
    }

    // 7. Выдать список запчастей, которые использовались в ремонтах за заданный период времени
    @GetMapping("/spare-parts/{startDate}/{endDate}")
    public List<SparePart> getSparePartsUsed(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                             @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return serviceCenterService.getSparePartsUsed(startDate, endDate);
    }

    // 8. Рассчитать стоимость запчастей для заданного ремонта
    @GetMapping("/repairs/{repairId}/spare-parts/cost")
    public List<SparePart> calculateSparePartsCostForRepair(@PathVariable Long repairId) {
        return serviceCenterService.calculateSparePartsCostForRepair(repairId);
    }

    // 10. Выдать список всех мастеров с персональными данными
    @GetMapping("/masters")
    public List<Master> getMasters() {
        return serviceCenterService.getMasters();
    }
}