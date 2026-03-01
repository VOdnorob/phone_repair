package com.phone_repair.phone_repair.services;


import com.phone_repair.phone_repair.domain.RepairRequest;
import com.phone_repair.phone_repair.repositories.RepairRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RepairRequestService {


    private final RepairRequestRepository repairRequestRepository;

    public List<RepairRequest> getAllRequest() {
        return repairRequestRepository.findAll();
    }

    public void save(RepairRequest repairRequest) {}
}
