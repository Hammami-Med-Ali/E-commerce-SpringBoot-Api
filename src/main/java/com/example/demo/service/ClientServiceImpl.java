package com.example.demo.service;

import com.example.demo.dao.ClientDao;
import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.models.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private ClientDao clientDao;

    private ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        ClientEntity  clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()->new RuntimeException("client not found "));
        return modelMapper.map(clientEntity,ClientResponseDto.class);

    }

    @Override
    public ClientResponseDto findByName(String name) {
        ClientEntity clientEntity = clientDao.findByName(name);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
    clientDao.deleteById(id);
    //ClientEntity clientEntity = clientDao.findById(id).get();
    //clientDao.delete(clientEntity);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id)  {
        Optional <ClientEntity> clientEntityOptional = clientDao.findById(id);
        if (clientEntityOptional.isPresent()){
        ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
            clientEntity.setId(id);
        ClientEntity updated = clientDao.save(clientEntity);
        return modelMapper.map(updated,ClientResponseDto.class);
        }else {
            throw new RuntimeException("Client not found");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll().stream().map(el->modelMapper.map(el,ClientResponseDto.class)).collect(Collectors.toList());

    }
}
