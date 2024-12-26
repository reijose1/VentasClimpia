package com.climpia.ventasclimpia.service.impl;

import com.climpia.ventasclimpia.model.entities.Cliente;
import com.climpia.ventasclimpia.repository.persistence.ClienteCrudRepository;
import com.climpia.ventasclimpia.service.ClienteService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Reinaldo Carrillo
 */
@Stateless
public class ClienteServiceImpl implements ClienteService {

    @Inject
    private ClienteCrudRepository clienteRepository;

    @Override
    @Transactional
    public void createCustomer(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente getCustomer(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public void updateCustomer(Cliente cliente) {
        clienteRepository.update(cliente);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer id) {
        Cliente cliente = getCustomer(id);
        if (cliente != null) {
            clienteRepository.delete(cliente);
        }
    }

    @Override
    public List<Cliente> getAllCustomers() {
        return clienteRepository.findAll(new Cliente());
    }

    @Override
    public List<Cliente> searchCustomersByName(String name) {
        return clienteRepository.findByNombre(name);
    }

    @Override
    public Cliente findCustomerByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}