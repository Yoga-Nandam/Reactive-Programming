package com.example.springwebflux.service;

import com.example.springwebflux.dto.EmployeeDto;
import com.example.springwebflux.entity.Employee;
import com.example.springwebflux.mapper.EmployeeMapper;
import com.example.springwebflux.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapTOEmployee(employeeDto);
        Mono<Employee> employeeResponse = employeeRepository.save(employee);
        return employeeResponse.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> response = employeeRepository.findById(employeeId);
        return response.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {
        Flux<Employee> employeeFlux  = employeeRepository.findAll();
        return employeeFlux
                .map(EmployeeMapper::mapToEmployeeDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {
        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);

        return employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            existingEmployee.setEmail(employeeDto.getEmail());
            return employeeRepository.save(existingEmployee);
        }).map((EmployeeMapper::mapToEmployeeDto));
    }

    @Override
    public Mono<Void> deleteEmployee(String employeeId) {
        return employeeRepository.deleteById(employeeId);
    }
}
