import React from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';

export default function MoreButton({ value }) {
  return (
    <Wrap>
      <Text size="X_LARGE" weight="REGULAR" value={value} />
    </Wrap>
  );
}

MoreButton.defaultProps = {
  value: ''
};

const Wrap = styled.button({
  margin: '0 auto',
  padding: '16px 24px',
  backgroundColor: ({ theme }) => theme.COLOR.WHITE[100],
  border: `1px solid #000`,
  borderColor: ({ theme }) => theme.COLOR.GREY[400]
  // TODO: botder 속성 적용이 왜 안되는지 알아보기.
  // 임시로 border, borderColor 속성으로 대체한다.
  // 아래의 주석처리 된 border 속성이 적용되지 않는다.
  // border: `1px solid ${({ theme }) => theme.COLOR.GREY[400]}`,
});
