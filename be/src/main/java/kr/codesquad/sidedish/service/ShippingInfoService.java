package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.repository.ShippingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingInfoService {

	private final ShippingInfoRepository shippingInfoRepository;

	public ShippingInfoDTO findById(Integer id) {

		return shippingInfoRepository.findById(id).get().createDTO();
	}


}
