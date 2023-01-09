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

import br.com.josiassantos.apipaymentsjava.model.Method;
import br.com.josiassantos.apipaymentsjava.repository.MethodRepository;

@RestController
@RequestMapping("/method")
public class PaymentMethodController {

  @Autowired
  private MethodRepository paymentMethodRepository;

  @GetMapping("/list")
  public List<Method> list() {
    return this.paymentMethodRepository.findAll();
  }

  @GetMapping("/{id}")
  public Method paymentMethod(@PathVariable("id") Long id) {
    
    Optional<Method> paymentMethodFind = this.paymentMethodRepository.findById(id);

    if(paymentMethodFind.isPresent()) {
      return (Method) paymentMethodFind.get();
    }

    return null;
  }
  
  @PostMapping("/")
  public Method paymentMethod(@RequestBody Method paymentMethod) {
    return this.paymentMethodRepository.save(paymentMethod);
  }
}
