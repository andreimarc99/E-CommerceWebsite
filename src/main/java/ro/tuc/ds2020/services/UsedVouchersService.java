package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.UsedVouchersBuilder;
import ro.tuc.ds2020.dtos.usedVouchersDTOs.UsedVoucherDTO;
import ro.tuc.ds2020.entities.UsedVoucher;
import ro.tuc.ds2020.repositories.UsedVoucherRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsedVouchersService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsedVouchersService.class);
    private final UsedVoucherRepository usedVoucherRepository;

    @Autowired
    public UsedVouchersService(UsedVoucherRepository usedVoucherRepository) {
        this.usedVoucherRepository = usedVoucherRepository;
    }

    public List<UsedVoucherDTO> findUsedVouchers() {
        List<UsedVoucher> vouchers = usedVoucherRepository.findAll();
        return vouchers.stream()
                .map(UsedVouchersBuilder::toUsedVoucherDTO)
                .collect(Collectors.toList());
    }

    public Long insertUsedVoucher(UsedVoucherDTO voucherDTO) {
        UsedVoucher voucher = UsedVouchersBuilder.toUsedVoucher(voucherDTO);
        voucher = usedVoucherRepository.save(voucher);
        LOGGER.debug("UsedVoucher with ID {} was inserted in db", voucher.getUsedVoucherId());
        return voucher.getUsedVoucherId();
    }

    public void deleteUsedVoucher(Long voucherId) throws ResourceNotFoundException {
        Optional<UsedVoucher> voucher = usedVoucherRepository.findById(voucherId);
        if (!voucher.isPresent()) {
            throw new ResourceNotFoundException("UsedVoucher with id " + voucherId + " not found.");
        }
        usedVoucherRepository.deleteById(voucherId);
    }

    public UsedVoucherDTO updateUsedVoucher(UsedVoucherDTO voucherDTO) throws ResourceNotFoundException {
        Optional<UsedVoucher> voucher = usedVoucherRepository.findById(voucherDTO.getUsedVoucherId());
        if (!voucher.isPresent()) {
            throw new ResourceNotFoundException("UsedVoucher with ID " + voucherDTO.getUsedVoucherId() + " not found.");
        }
        UsedVoucher updatedUsedVoucher = UsedVouchersBuilder.toUsedVoucher(voucherDTO);
        UsedVoucherDTO updatedUsedVoucherDTO = UsedVouchersBuilder.toUsedVoucherDTO(usedVoucherRepository.save(updatedUsedVoucher));
        return updatedUsedVoucherDTO;
    }
}
