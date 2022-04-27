import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';

export default function Logo({ size, family, value }) {
  return (
    <Wrap>
      <Text size={size} family={family} value={value} />
    </Wrap>
  );
}

Logo.defaultProps = {
  size: '1rem',
  family: 'LOGO',
  value: 'Ordering'
};

const Wrap = styled.h1({
  lineHeight: 1.1
});
