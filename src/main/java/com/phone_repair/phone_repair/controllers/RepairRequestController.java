package com.phone_repair.phone_repair.controllers;

import com.phone_repair.phone_repair.domain.RepairRequest;
import com.phone_repair.phone_repair.services.RepairRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepairRequestController {
    private final RepairRequestService repairRequestService;

    public RepairRequestController(RepairRequestService repairRequestService) {
        this.repairRequestService = repairRequestService;
    }

    @GetMapping("/request_repair")
    public List<RepairRequest> getAllRequests() {
        return repairRequestService.getAllRequest();
    }
}
