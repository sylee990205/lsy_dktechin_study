package jpamvcexam.mainview;

import jpamvcexam.model.dao.EmpDAO;
import jpamvcexam.model.vo.EmpFreqVO;
import jpamvcexam.model.vo.EmpVO;
import java.util.List;

public class EmpApp1 {
	public static void hr() {
		for(int i=1; i < 100; i++)
			System.out.print("-");
		System.out.println();
	}
	public static void main(String[] args)  {
		EmpDAO dao = new EmpDAO();
		System.out.printf("emp 테이블의 데이터 갯수 : %d개 \n",dao.getAllDataNum());
		hr();
		int inputNum = 7499;
		System.out.printf("사번이 %d인 직원의 성명 : %s%n", inputNum, dao.getEmpNum(inputNum));
		hr();
		List<EmpVO> r1 = dao.findByJob("SALESMAN");
		for(EmpVO vo : r1)
			System.out.println(vo);
		hr();
		List<EmpVO> r2 = dao.findByPartEname("T");
		for(EmpVO vo : r2)
			System.out.println(vo);
		hr();
		List<EmpVO> r3 = dao.findByGreaterThanSal(2000);
		for(EmpVO vo : r3)
			System.out.println(vo);
		hr();
		List<EmpVO> r4 = dao.findByEnameAndJob1("MARTIN", "SALESMAN");
		for(EmpVO vo : r4)
			System.out.println(vo);
		hr();
		EmpVO evo = dao.findByEnameAndJob2("MARTIN", "SALESMAN");
		System.out.println(evo);
		hr();
		List<EmpFreqVO> r5 = dao.findByEmpFreqVO();
		for(EmpFreqVO vo : r5)
			System.out.println(vo);
		hr();
		List<EmpVO> r6 = dao.listPart(0, 14);
		for(EmpVO vo : r6)
			System.out.println(vo);
		hr();
		List<EmpVO> r7 = dao.listPart(0, 3);
		for(EmpVO vo : r7)
			System.out.println(vo);
		hr();
		List<EmpVO> r8 = dao.listPart(3, 2);
		for(EmpVO vo : r8)
			System.out.println(vo);
		hr();
		
		Object[] r9 = dao.getGroupFunc();
		System.out.println("급여 총액 : "+r9[0]);
		System.out.println("최대 급여 : "+r9[1]);
		System.out.println("최소 총액 : "+r9[2]);
		hr();
		
		dao.close();	
	}
}
