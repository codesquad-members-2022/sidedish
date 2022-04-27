package codesquad.sidedish.domain.item;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @DisplayName("id로 findById()를 호출하면 아이템이 나와야 한다.")
    void findByIdTest() {
        Item findItem = itemRepository.findById(1L).get();
        log.info("findItem: {}", findItem);

        assertThat(findItem.getItemId()).isEqualTo(1);
        assertThat(findItem.getName()).isEqualTo("땃쥐고기");
        assertThat(findItem.getPrice()).isEqualTo(10000);
        assertThat(findItem.getItemImages().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("섹션명으로 findBySectionName()을 호출하면 해당 섹션의 아이템 리스트가 리턴된다.")
    void findBySectionNameTest() {
        List<Item> findItems = itemRepository.findByItemSectionName("main");
        log.info("findItems: {}", findItems);
    }

}
