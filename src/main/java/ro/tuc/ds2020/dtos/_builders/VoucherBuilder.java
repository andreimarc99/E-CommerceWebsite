package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.voucherDTOs.VoucherDTO;
import ro.tuc.ds2020.entities.Voucher;

public class VoucherBuilder {

    public static Voucher toVoucher(VoucherDTO voucherDTO) {
        return new Voucher(voucherDTO.getVoucherId(),
                voucherDTO.getStartDate(),
                voucherDTO.getEndDate(),
                voucherDTO.isOneTimeOnly());
    }

    public static VoucherDTO toVoucherDTO(Voucher voucher) {
        return new VoucherDTO(voucher.getVoucherId(),
                voucher.getStartDate(),
                voucher.getEndDate(),
                voucher.isOneTimeOnly());
    }
}
