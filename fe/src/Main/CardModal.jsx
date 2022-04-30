import styled from 'styled-components';
import { FlexDiv } from 'common/FlexDiv';
import DishTogatherContainer from 'Modal/ModalTogatherContainer';
import ModalDetailContainer from 'Modal/ModalDetailContainer';
import ModalImgWrapper from 'Modal/ModalImgWrapper';

const ModalTogetherContainer = styled.article`
  padding: 48px 0;

  h3 {
    ${({ theme }) => theme.fontStyles.largeBold};
  }
`;

const CardModal = ({ item }) => {
  return (
    <>
      <FlexDiv>
        {item.length !== 0 && <ModalImgWrapper title={item.name} images={item.images} />}
        {item.length !== 0 && <ModalDetailContainer item={item} />}
      </FlexDiv>
      <ModalTogetherContainer>
        <DishTogatherContainer></DishTogatherContainer>
      </ModalTogetherContainer>
    </>
  );
};

export default CardModal;
