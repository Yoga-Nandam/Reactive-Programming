package com.example.springwebflux.mapper;

import com.example.springwebflux.dto.EmployeeDto;
import com.example.springwebflux.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    public EmployeeDto mapToEmployeeDto(Employee employee);

    public Employee mapTOEmployee(EmployeeDto employeeDto);
}
