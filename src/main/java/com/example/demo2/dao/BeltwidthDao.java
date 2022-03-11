package com.example.demo2.dao;

import com.example.demo2.entity.Beltwidth;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BeltwidthDao extends Mapper<Beltwidth> {
    @Select(" select min(id),beltwidthValue,min(beltwidthName),min(productmodelId) from beltwidth where productmodelId=#{productmodelId} group by beltwidthValue order by beltwidthValue")
    public List<Beltwidth> beltwidthListByProductmodelId(@Param("productmodelId") String productmodelId);
    @Select(" select min(id),beltwidthValue,min(beltwidthName),min(productmodelId) from beltwidth where productmodelId=#{productmodelId} and materialId=#{materialId} group by beltwidthValue order by beltwidthValue")
    public List<Beltwidth> beltwidthListByProductmodelIdAndmaterialId(@Param("productmodelId") String productmodelId,@Param("materialId") String materialId);
    @Select(" select min(id),beltwidthValue,min(beltwidthName),min(productmodelId) from beltwidth where productmodelId=#{productmodelId} and surfacetreatmentId=#{surfacetreatmentId} group by beltwidthValue order by beltwidthValue")
    public List<Beltwidth> beltwidthListByProductmodelIdAndsurfacetreatmentId(@Param("productmodelId") String productmodelId,@Param("surfacetreatmentId") String surfacetreatmentId);
}
