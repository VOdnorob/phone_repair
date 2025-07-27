package com.phone_repair.phone_repair.Controller;

import com.phone_repair.phone_repair.Service.RepairRequestService;
import com.phone_repair.phone_repair.domain.RepairRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepairRequestController {
    @Autowired
    private RepairRequestService repairRequestService;

    @GetMapping("/request_repair")
    public List<RepairRequest> getAllRequests(){
        return repairRequestService.getAllRequest();
    }

}
