package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Arrange;
import com.example.demo.entity.Audit;
import com.example.demo.vo.AuditVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ArrangeMapper extends BaseMapper<Arrange> {

    List<Arrange> queryArrangeByEventId(@Param("eventId") String eventId);
}
