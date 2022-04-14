package BusinessLogic;

import BusinessLogic.Validators.ClientYearValidator;
import Exception.InvalidAttributeException;
import BusinessLogic.Validators.Validator;
import DataAccess.ClientDAO;
import Model.Client;

import java.util.List;


public class ClientBLL {

    private ClientDAO clientDAO;
    private Validator<Client> validator;

    public ClientBLL(){
        clientDAO = new ClientDAO();
        validator = new ClientYearValidator();
    }

    public Client findClientById(int id){
        Client client = clientDAO.findById(id);
        return client;
    }

    public List<Client> findAllClients()
    {
        List<Client> clients = clientDAO.findAll();
        return clients;
    }

    public void insertClient(String name, int year, String address) throws InvalidAttributeException
    {
        Client client = new Client(name, year, address);
        validator.validate(client);
        clientDAO.insert(client);
    }

    public void updateClient(int id, String name, int year, String address) throws InvalidAttributeException {
        Client client = findClientById(id);
        if(client == null) return;
        if(!name.equals(""))
            client.setName(name);
        if(year!=-1)
            client.setYear(year);
        if(!address.equals(""))
            client.setAddress(address);
        validator.validate(client);
        clientDAO.update(client);
    }

    public void deleteClient(int id) {
        clientDAO.deleteById(id);
    }
}
