package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.usedVouchersDTOs.UsedVoucherDTO;
import ro.tuc.ds2020.entities.UsedVoucher;

public class UsedVouchersBuilder {

    public static UsedVoucher toUsedVoucher(UsedVoucherDTO usedVoucherDTO) {
        return new UsedVoucher(usedVoucherDTO.getUsedVoucherId(),
                CustomerBuilder.toCustomer(usedVoucherDTO.getCustomer()),
                VoucherBuilder.toVoucher(usedVoucherDTO.getVoucher())
        );
    }

    public static UsedVoucherDTO toUsedVoucherDTO(UsedVoucher usedVoucher) {
        return new UsedVoucherDTO(usedVoucher.getUsedVoucherId(),
                CustomerBuilder.toCustomerDTO(usedVoucher.getCustomer()),
                VoucherBuilder.toVoucherDTO(usedVoucher.getVoucher())
        );
    }
}
