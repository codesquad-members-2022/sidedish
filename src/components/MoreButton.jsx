import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';

export default function MoreButton({ value, setClikedMoreBtn }) {
  return (
    <Wrap onClick={handleClickMoreBtn}>
      <Text size="X_LARGE" weight="REGULAR" value={value} />
    </Wrap>
  );
  function handleClickMoreBtn() {
    setClikedMoreBtn(true);
  }
}

MoreButton.defaultProps = {
  value: ''
};

const Wrap = styled.button({
  margin: '0 auto',
  padding: '16px 24px',
  backgroundColor: ({ theme }) => theme.COLOR.WHITE[100],
  border: ({ theme }) => `1px solid ${theme.COLOR.GREY[400]}`
});
