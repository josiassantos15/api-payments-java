package br.com.josiassantos.apipaymentsjava.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.josiassantos.apipaymentsjava.model.Payment;
// import br.com.josiassantos.apipaymentsjava.model.Status;
import br.com.josiassantos.apipaymentsjava.repository.PaymentRepository;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  private PaymentRepository paymentRepository;

  @GetMapping("/list")
  public List<Payment> list() {
    return this.paymentRepository.findAll();
  }

  @GetMapping("/{id}")
  public Payment payment(@PathVariable("id") Long id) {
    
    Optional<Payment> paymentFind = this.paymentRepository.findById(id);

    if(paymentFind.isPresent()) {
      return (Payment) paymentFind.get();
    }

    return null;
  }

  @GetMapping("/findByCpf/{cpf}")
  public List<Payment> findByCpf(@PathVariable("cpf") String cpf) {
    return this.paymentRepository.findByCpf(cpf);
  }

  // @GetMapping("/findByStatus/{status}")
  // public Payment payment(@PathVariable("status") Status status) {
  //   Optional<Payment> paymentFind = this.paymentRepository.findByStatusIgnoreCase(status);

  //   if(paymentFind.isPresent()) {
  //     return (Payment) paymentFind.get();
  //   }

  //   return null;
  // }
  
  @PostMapping("/")
  public Payment payment(@RequestBody Payment payment) {
    return this.paymentRepository.save(payment);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Payment> updatePayment(@PathVariable long id,@RequestBody Payment paymentDetails) {
    Payment updatePayment = paymentRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id: " + id));

      updatePayment.setStatus(((Payment) paymentDetails).getStatus());

      paymentRepository.save(updatePayment);

      return ResponseEntity.ok(updatePayment);
  }

  @DeleteMapping("/{id}") 
  // public Object deleteClient(@PathVariable Long id){
  public void deleteClient(@PathVariable Long id){
    Optional<Payment> paymentFind = this.paymentRepository.findById(id);

    if(paymentFind.isPresent()) {
      this.paymentRepository.deleteById(id);
    } 
    // return null;
    // return "successfully deleted payment with id " + id;
  }
}