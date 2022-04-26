package kr.codesquad.sidedish.service;

import java.util.List;
import kr.codesquad.sidedish.domain.Theme;
import kr.codesquad.sidedish.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeRepository themeRepository;

    public List<Theme> readAll() {
        return themeRepository.findAll();
    }
}
