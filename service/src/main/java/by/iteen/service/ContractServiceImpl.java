package by.iteen.service;

import by.iteen.dao.ContractDao;
import by.iteen.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContractServiceImpl implements ContractService {

    private final ContractDao contractDao;

    @Autowired
    public ContractServiceImpl(ContractDao contractDao) {
        this.contractDao = contractDao;
    }

    @Override
    public void save(Contract contract) {
        contractDao.save(contract);
    }
}
