package com.example.demo.controllers;

import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")

public class ClientController {
    private ClientService clientService;

    @Autowired
    public void ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("")
    public List<ClientResponseDto> getClient(){
        return clientService.findAll();
    }

    @PostMapping("")
    public ClientResponseDto save(@RequestBody ClientRequestDto clientRequestDto){
        return clientService.save(clientRequestDto);
    }

    @GetMapping("/id/{id_client}")
    public ClientResponseDto findById(@PathVariable("id_client") Integer id) {
        return clientService.findById(id);
    }

    @GetMapping("/name/{last_name}")
    public ClientResponseDto findByName(@PathVariable("name") String name) {
        return clientService.findByName(name);
    }

    @DeleteMapping("/id/{id_client}")
    public void delete(@PathVariable("id_client") Integer id) {
        clientService.delete(id);
    }

    @PutMapping("/id/{id_client}")
    public ClientResponseDto update(@RequestBody ClientRequestDto clientRequestDto,@PathVariable("id_client") Integer id) throws RuntimeException {
        return clientService.update(clientRequestDto, id);
    }
}
