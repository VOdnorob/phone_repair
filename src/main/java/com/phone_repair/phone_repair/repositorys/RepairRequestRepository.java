package com.phone_repair.phone_repair.repositorys;

import com.phone_repair.phone_repair.domain.RepairRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRequestRepository extends JpaRepository<RepairRequest, Long> {
}
