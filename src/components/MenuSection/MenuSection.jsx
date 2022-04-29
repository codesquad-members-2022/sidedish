import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';
import MenuSlider from 'components/MenuSection/MenuSlider';

export default function MenuSection({ setClickedCard, setCardHash }) {
  return (
    <Wrap>
      <Title>
        <Text size="TITLE_3" weight="MEDIUM" value="식탁을 풍성하게 하는 정갈한 밑반찬" />
      </Title>
      <MenuSlider setClickedCard={setClickedCard} setCardHash={setCardHash} />
    </Wrap>
  );
}

const Wrap = styled.div({
  padding: '56px 80px'
});

const Title = styled.h3({
  paddingBottom: '40px'
});
