package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.exception.CustomException;
import kr.codesquad.sidedish.repository.ShippingInfoRepository;
import kr.codesquad.sidedish.response.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingInfoService {

	private final ShippingInfoRepository shippingInfoRepository;

	public ShippingInfoDTO findByDeliveryType(Integer deliveryType) {

		return shippingInfoRepository.findByDeliveryType(deliveryType)
			.orElseThrow(() -> new CustomException(
				ErrorCode.DELIVERY_INFORMATION_NOT_ALLOWED)).createDTO();
	}


}
