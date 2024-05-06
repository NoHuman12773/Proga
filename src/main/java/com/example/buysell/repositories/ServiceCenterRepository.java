package com.example.buysell.repositories;

import com.example.buysell.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {

    List<Service> findAllServices();

    List<Client> findAllClients();

    List<SparePart> getSpareParts(Date startDate, Date endDate);

    List<SparePart> findSparePartsByRepairId();

    List<Master> findAllMasters();

    ClientCard findClientById();
}
