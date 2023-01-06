package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import com.codegym.model.dto.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<IContractDto> listContract();

    void save(Contract contract);

}
