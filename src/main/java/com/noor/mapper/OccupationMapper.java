package com.noor.mapper;

import com.noor.dto.OccupationDTO;
import com.noor.entity.Occupation;


public class OccupationMapper {

    public static Occupation convertDtoToEntity(OccupationDTO occupationDTO){
        Occupation occupation=new Occupation();
        occupation.setName(occupationDTO.name());
        occupation.setCode(occupationDTO.code());
        return occupation;
    }
}
