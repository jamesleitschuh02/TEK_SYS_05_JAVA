package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

}
