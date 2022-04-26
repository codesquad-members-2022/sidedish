import React from 'react';
import styled from 'styled-components';
import theme from 'variable/theme';
import Text from 'components/utils/Text';

export default function Tag({ type }) {
  return (
    <PillShape type={type}>
      <Text size="SMALL" color="WHITE_100" value={type} />
    </PillShape>
  );
}

Tag.defaultProps = {
  type: '이벤트특가'
};

const PillShape = styled.div({
  width: 'fit-content',
  padding: '6px 16px 6px 16px',
  borderRadius: '15px',
  backgroundColor: props => getColorByType(props.type)
});

function getColorByType(type) {
  if (type === '이벤트특가') {
    return theme.COLOR.GREEN[100];
  }
  if (type === '런칭특가') {
    return theme.COLOR.ORANGE[100];
  }
  throw new Error('태그의 타입이 올바르지 않습니다.');
}
