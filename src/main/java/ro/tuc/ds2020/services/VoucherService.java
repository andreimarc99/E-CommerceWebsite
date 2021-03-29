package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.VoucherBuilder;
import ro.tuc.ds2020.dtos.voucherDTOs.VoucherDTO;
import ro.tuc.ds2020.entities.Voucher;
import ro.tuc.ds2020.repositories.VoucherRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoucherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoucherService.class);
    private final VoucherRepository voucherRepository;

    @Autowired
    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public List<VoucherDTO> findVouchers() {
        List<Voucher> vouchers = voucherRepository.findAll();
        return vouchers.stream()
                .map(VoucherBuilder::toVoucherDTO)
                .collect(Collectors.toList());
    }

    public Long insertVoucher(VoucherDTO voucherDTO) {
        Voucher voucher = VoucherBuilder.toVoucher(voucherDTO);
        voucher = voucherRepository.save(voucher);
        LOGGER.debug("Voucher with ID {} was inserted in db", voucher.getVoucherId());
        return voucher.getVoucherId();
    }

    public void deleteVoucher(Long voucherId) throws ResourceNotFoundException {
        Optional<Voucher> voucher = voucherRepository.findById(voucherId);
        if (!voucher.isPresent()) {
            throw new ResourceNotFoundException("Voucher with id " + voucherId + " not found.");
        }
        voucherRepository.deleteById(voucherId);
    }

    public VoucherDTO updateVoucher(VoucherDTO voucherDTO) throws ResourceNotFoundException {
        Optional<Voucher> voucher = voucherRepository.findById(voucherDTO.getVoucherId());
        if (!voucher.isPresent()) {
            throw new ResourceNotFoundException("Voucher with ID " + voucherDTO.getVoucherId() + " not found.");
        }
        Voucher updatedVoucher = VoucherBuilder.toVoucher(voucherDTO);
        VoucherDTO updatedVoucherDTO = VoucherBuilder.toVoucherDTO(voucherRepository.save(updatedVoucher));
        return updatedVoucherDTO;
    }
}
