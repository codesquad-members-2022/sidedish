package team14.sidedish.exhibition;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExhibitionService {
	private final ExhibitionRepository exhibitionRepository;

	public ExhibitionDto readOngoing() {
		Exhibition exhibitionInfo = exhibitionRepository.findByLatestStartAt();
		return new ExhibitionDto(exhibitionInfo);
	}
}
