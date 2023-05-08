package com.example.demo.service;

import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    ClientResponseDto save(ClientRequestDto clientRequestDto);
    ClientResponseDto findById(Integer id);
    ClientResponseDto findByName(String name);
    void delete(Integer id);
    ClientResponseDto update(ClientRequestDto clientRequestDto,Integer id);
    List<ClientResponseDto> findAll();

}
