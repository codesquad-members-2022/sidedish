import { categoryData } from '../../../helper/mock';
import { ProductCard } from '../../../components/productCard/ProductCard';
import { buttonIcons } from '../../../helper/constants';
import { CategoryWrapper, CategoryTitle, CategoryCardWrapper, LeftButton, RightButton } from './category.styled';

export function Category() {
  return (
    <CategoryWrapper>
      <CategoryTitle>식탁을 풍성하게 하는 정갈한 밑반찬</CategoryTitle>
      <CategoryCardWrapper flex>
        <LeftButton>{buttonIcons.left}</LeftButton>
        {categoryData.map((product, idx) => {
          return <ProductCard product={product} size="medium" key={idx}></ProductCard>;
        })}
        <RightButton>{buttonIcons.right}</RightButton>
      </CategoryCardWrapper>
    </CategoryWrapper>
  );
}
