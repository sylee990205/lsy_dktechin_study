package com.example.springedu.dao;

import com.example.springedu.domain.EmpVO;
import com.example.springedu.domain.PageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface EmpMapperDAO {
    @Select("select count(*) from emp")
    public int getAllDataNum();

    @Select("select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, sal  from emp")
    public List<EmpVO> listAll();

    @Select("select empno, ename, job, date_format(hiredate, '%Y년 %m월 %d일') hiredate, sal from emp order by sal limit #{startNum}, #{countNum}")
    public List<EmpVO> listPart(PageDTO vo);
}