import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';
import Slider from 'components/Slider';

export default function MenuSlider() {
  return (
    <Wrap>
      <Title>
        <Text size="TITLE_3" weight="MEDIUM" value="식탁을 풍성하게 하는 정갈한 밑반찬" />
      </Title>
      <Slider />
    </Wrap>
  );
}

const Wrap = styled.div({
  padding: '56px 80px',
  borderTop: ({ theme }) => `1px solid ${theme.COLOR.GREY[400]}`
});

const Title = styled.h3({
  paddingBottom: '40px'
});
