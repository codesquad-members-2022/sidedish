package kr.codesquad.sidedish.repository;

import kr.codesquad.sidedish.domain.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT DISTINCT p.* FROM product p LEFT JOIN product_theme pt on p.id = pt.product_id " +
            "WHERE IF(ISNULL(:categoryId), true, p.category_id = :categoryId) " +
            "AND IF(ISNULL(:themeId), true, pt.theme_id = :themeId) " +
            "ORDER BY (CASE WHEN :sort = 'RAND()' THEN RAND() ELSE p.id END) " +
            "LIMIT :offset, :pageSize")
    List<Product> findAllByCategoryIdAndThemeId(Long categoryId, Long themeId,
                                                String sort, Long offset, Integer pageSize);
}
