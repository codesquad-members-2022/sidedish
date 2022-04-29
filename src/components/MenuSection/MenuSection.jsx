import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';
import MenuSlider from 'components/MenuSection/MenuSlider';

export default function MenuSection({ title, menuName, setClickedCard, setCardHash }) {
  return (
    <Wrap>
      <Title>
        <Text size="TITLE_3" weight="MEDIUM" value={title} />
      </Title>
      <MenuSlider menuName={menuName} setClickedCard={setClickedCard} setCardHash={setCardHash} />
    </Wrap>
  );
}

const Wrap = styled.div({
  padding: '56px 80px'
});

const Title = styled.h3({
  paddingBottom: '40px'
});
