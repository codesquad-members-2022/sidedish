import {CategoryContainer, CategoryList, MainCategory, SubCategoryList, SubCategory} from './Category.styled';
import {category} from 'data';

function Category({isOpen, setIsOpen}) {
  const handleMouseOver = () => {
    setIsOpen(true);
  };
  const handleMouseOut = () => {
    setIsOpen(false);
  };

  return (
    <CategoryContainer onMouseOver={handleMouseOver} onMouseOut={handleMouseOut}>
      <CategoryList>
        {category.map(({id, mainCategory}) => (
          <MainCategory key={id}>
            {mainCategory.title}
            <SubCategoryList>
              {isOpen &&
                mainCategory.subCategory.map(({id, title}) => <SubCategory key={id}>{title}</SubCategory>)}
            </SubCategoryList>
          </MainCategory>
        ))}
      </CategoryList>
    </CategoryContainer>
  );
}
export {Category};
