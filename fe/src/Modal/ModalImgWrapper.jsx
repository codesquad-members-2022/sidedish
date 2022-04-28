import { useState } from 'react';
import styled from 'styled-components';

const ImgWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-right: 32px;

  .first {
    ${({ theme }) => theme.modalImgSize.main};
    margin-bottom: 8px;
  }
`;

const SubImage = styled.img`
  display: inline-block;
  ${({ theme }) => theme.modalImgSize.side};
  background: ${({ theme }) => theme.colors.gray3};
  cursor: pointer;
`;

const Grid = styled.div`
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-column-gap: 8px;
`;

const ModalImgWrapper = ({ images }) => {
  const [dishes, setDishes] = useState(images);

  const handleSubImageClick = ({ currentTarget }) => {
    const newImages = [...dishes];
    const clickedImage = newImages.filter((dish) => dish.id === Number(currentTarget.id))[0];
    const clickedImageIdx = newImages.indexOf(clickedImage);
    newImages.splice(clickedImageIdx, 1);
    const mainImage = newImages.shift();
    newImages.push(mainImage);
    newImages.unshift(clickedImage);
    setDishes(newImages);
  };

  const main = dishes[0];
  const mainImage = (
    <img key={main.id} id={main.id} src={main.path} alt={main.name} className="first" />
  );

  const subImages = dishes.map((image, index) => {
    return (
      index !== 0 && (
        <SubImage
          key={image.id}
          src={image.path}
          alt={image.name}
          id={image.id}
          onClick={handleSubImageClick}
        />
      )
    );
  });

  return (
    images && (
      <ImgWrapper>
        {mainImage}
        <Grid>{subImages}</Grid>
      </ImgWrapper>
    )
  );
};

export default ModalImgWrapper;
