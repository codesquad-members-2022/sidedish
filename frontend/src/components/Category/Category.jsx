import {CategoryContainer, CategoryList, MainCategory, SubCategoryList, SubCategory} from "./Category.styled";
import {category} from "data";

function Category({isOpen, setIsOpen}) {
  const handleMouseEnter = () => {
    setIsOpen(true);
  };

  const handleMouseLeave = () => {
    setIsOpen(false);
  };

  return (
    <CategoryContainer onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
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
