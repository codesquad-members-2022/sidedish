import React from 'react';
import styled from 'styled-components';
import Text from './Text';
import COLOR from '../variable/color';

export default function MoreButton(props) {
  const { value } = props;
  return (
    <Wrap>
      <Text size="LARGE" weight="REGULAR" value={value} />
    </Wrap>
  );
}

MoreButton.defaultProps = {
  value: '',
};

const Wrap = styled.button({
  width: 'fit-contents',
  padding: '16px 24px 16px 24px',
  border: `1px solid ${COLOR.GREY4}`,
  'background-color': COLOR.WHITE,
  cursor: 'pointer',
});
