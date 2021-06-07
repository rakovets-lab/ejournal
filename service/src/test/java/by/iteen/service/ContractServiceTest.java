package by.iteen.service;

import by.iteen.dao.ContractDao;
import by.iteen.entity.Contract;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ContractServiceTest extends BaseServiceTest {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDao contractDao;

    @Test
    public void save() {
        Contract contract = new Contract();
        contract.setTitle("f123456789");
        contractService.save(contract);

        assertEquals(contract, contractDao.findOne(1L));
    }
}
