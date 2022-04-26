import { ProductCard } from '../../../../components/productCard/ProductCard';
import { buttonIcons } from '../../../../helper/constants';
import { CategoryWrapper, CategoryTitle, CategoryCardWrapper, LeftButton, RightButton } from './category.styled';

export function Category({ title, sideDishCardResponses }) {
  return (
    <CategoryWrapper>
      <CategoryTitle>{title}</CategoryTitle>
      <CategoryCardWrapper flex>
        <LeftButton>{buttonIcons.left}</LeftButton>
        {sideDishCardResponses.map((product, idx) => {
          return <ProductCard product={product} size="medium" key={idx}></ProductCard>;
        })}
        <RightButton>{buttonIcons.right}</RightButton>
      </CategoryCardWrapper>
    </CategoryWrapper>
  );
}
