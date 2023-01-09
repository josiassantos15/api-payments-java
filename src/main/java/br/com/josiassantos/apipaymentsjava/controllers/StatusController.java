package br.com.josiassantos.apipaymentsjava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.josiassantos.apipaymentsjava.model.Status;
import br.com.josiassantos.apipaymentsjava.repository.StatusRepository;

@RestController
@RequestMapping("/status")
public class StatusController {

  @Autowired
  private StatusRepository statusRepository;

  @GetMapping("/list")
  public List<Status> list() {
    return this.statusRepository.findAll();
  }

  @GetMapping("/{id}")
  public Status status(@PathVariable("id") Long id) {
    
    Optional<Status> statusFind = this.statusRepository.findById(id);

    if(statusFind.isPresent()) {
      return (Status) statusFind.get();
    }

    return null;
  }

  // @GetMapping
  // public ResponseEntity<Status> findAll() {
  //   Status s = new Status(1L, "Pendente de Processamento");
  //   // Status s1 = new Status(2L, "Pendente de Processamento");
  //   return ResponseEntity.ok().body(s);   
  // }

  @GetMapping("/findByName/{name}")
  public List<Status> findByCpf(@PathVariable("name") String name) {
    return this.statusRepository.findByNameIgnoreCase(name);
  }
  
  @PostMapping("/")
  public Status status(@RequestBody Status status) {
    return this.statusRepository.save(status);
  }
}
