package com.example.clinica.adapter.controller;

import com.example.clinica.adapter.dto.RecepcionistaDTO;
import com.example.clinica.application.service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recepcionistas")
public class RecepcionistaController {

    @Autowired
    private RecepcionistaService recepcionistaService;

    @PostMapping
    public ResponseEntity<Void> cadastrarRecepcionista(@RequestBody RecepcionistaDTO recepcionistaDTO) {
        recepcionistaService.cadastrarRecepcionista(recepcionistaDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecepcionistaDTO> consultarPorId(@PathVariable int id) {
        Optional<RecepcionistaDTO> recepcionistaDTO = recepcionistaService.consultarPorId(id);
        return recepcionistaDTO.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<RecepcionistaDTO>> listarRecepcionistas() {
        List<RecepcionistaDTO> recepcionistas = recepcionistaService.listarRecepcionistas();
        return ResponseEntity.ok(recepcionistas);
    }

    @PutMapping
    public ResponseEntity<Void> atualizarRecepcionista(@RequestBody RecepcionistaDTO recepcionistaDTO) {
        recepcionistaService.atualizarRecepcionista(recepcionistaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRecepcionista(@PathVariable int id) {
        recepcionistaService.excluirRecepcionista(id);
        return ResponseEntity.ok().build();
    }
}
