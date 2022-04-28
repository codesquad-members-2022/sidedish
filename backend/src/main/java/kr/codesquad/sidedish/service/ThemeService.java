package kr.codesquad.sidedish.service;

import kr.codesquad.sidedish.controller.dto.ThemeListResponse;
import kr.codesquad.sidedish.domain.Theme;
import kr.codesquad.sidedish.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeRepository themeRepository;

    public List<ThemeListResponse.Element> readAll() {
        return themeRepository.findAll()
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private ThemeListResponse.Element entityToDTO(Theme theme) {
        return new ThemeListResponse.Element(theme.getId(), theme.getName());
    }
}
