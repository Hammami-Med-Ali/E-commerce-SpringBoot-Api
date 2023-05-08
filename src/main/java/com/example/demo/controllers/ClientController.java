package com.example.demo.controllers;

import com.example.demo.dto.ClientRequestDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientResponseDto>> getClients() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ClientResponseDto> save(@RequestBody() ClientRequestDto clientRequestDto) {
        ClientResponseDto clientResponseDto = clientService.save(clientRequestDto);
        return new ResponseEntity<>(clientResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) {
        ClientResponseDto clientResponseDto = clientService.findById(id);
        return ResponseEntity.ok(clientResponseDto);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable() String name) {
        ClientResponseDto clientResponseDto = clientService.findByName(name);
        return ResponseEntity.ok(clientResponseDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable() Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> update(
            @RequestBody() ClientRequestDto clientRequestDto, @PathVariable() Integer id) throws RuntimeException {
        ClientResponseDto clientResponseDto = clientService.update(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
    }
}
