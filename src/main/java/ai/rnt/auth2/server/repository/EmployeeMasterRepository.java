package ai.rnt.auth2.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.rnt.auth2.server.entity.EmployeeMaster;

public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Integer>{

	EmployeeMaster findByUserId(String userId);
}
