package jpamvcexam.model.dao;

import jpamvcexam.model.vo.EmpFreqVO;
import jpamvcexam.model.vo.EmpVO;

import javax.persistence.*;
import java.util.List;

public class EmpDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");
    EntityManager em = factory.createEntityManager();
    public void close() {
    	em.close();
    	factory.close();
    }
	public Long getAllDataNum() {	
		TypedQuery<Long> q = em.createQuery("select count(t.empno) from EmpVO t", Long.class);
		return q.getSingleResult();   
	}
	
	public String getEmpNum(Integer numOfEmp) {
		EmpVO e = em.find(EmpVO.class, numOfEmp);
		if (e != null)
			return e.getEname();
		else
			return "없음";
	}

	public List<EmpVO> findByJob(String job) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.job = :job", EmpVO.class);
		q.setParameter("job", job); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpVO> findByPartEname(String partEname) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.ename like :pe", EmpVO.class);
		q.setParameter("pe", "%"+partEname+"%"); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}
	
	public List<EmpVO> findByGreaterThanSal(int sal) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.sal >= :sal", EmpVO.class);
		q.setParameter("sal", sal); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpVO> findByEnameAndJob1(String ename, String job) {
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t WHERE t.ename = :ename and t.job = :job", EmpVO.class);
		q.setParameter("ename", ename); 
		q.setParameter("job", job); 
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}

	public EmpVO findByEnameAndJob2(String ename, String job) {
		TypedQuery<EmpVO>  q = em.createQuery("SELECT t FROM EmpVO t WHERE t.ename = ?1 and t.job = ?2", EmpVO.class);
		q.setParameter(1, ename); 
		q.setParameter(2, job); 
		EmpVO result = q.getSingleResult();
		return result;
	}
	
	public List<EmpFreqVO> findByEmpFreqVO() {
		TypedQuery<EmpFreqVO>  q = em.createQuery("SELECT new jpamvcexam.model.vo.EmpFreqVO(t.empno, t.ename, t.hiredate, t.sal, t.deptno) FROM EmpVO t", EmpFreqVO.class);
		List<EmpFreqVO> resultList = q.getResultList();
		return resultList;
	}

	public List<EmpVO> listPart(int start, int num) {	
		TypedQuery<EmpVO> q = em.createQuery("SELECT t FROM EmpVO t ORDER BY t.sal DESC", EmpVO.class);
		q.setFirstResult(start);    // 조회 시작 위치
		q.setMaxResults(num);       // 조회할 데이터 수
		List<EmpVO> resultList = q.getResultList();
		return resultList;
	}
	
	public Object[] getGroupFunc() {	
		Query query = em.createQuery("SELECT sum(t.sal), max(t.sal), min(t.sal) FROM EmpVO t"); // 받아오는 query의 type을 지정할 수 없다면 Query
		Object[] result = (Object[])query.getSingleResult(); // Object[]로 return
		return result;
	}	
	
}
