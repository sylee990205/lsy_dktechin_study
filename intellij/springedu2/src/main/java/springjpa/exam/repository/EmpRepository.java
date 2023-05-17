package springjpa.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springjpa.exam.entity.Emp;


public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
