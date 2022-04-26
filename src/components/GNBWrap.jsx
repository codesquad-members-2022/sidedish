import React, { useState } from 'react';
import styled from 'styled-components';
import Text from 'components/Text';
import SubGNBList from 'components/SubGNBList';

const GNB_INFO = [
  { GNB_NAME: '든든한 메인요리', SUB_GNB: ['육류 요리', '해산물 요리'] },
  { GNB_NAME: '뜨뜬한 국물요리', SUB_GNB: ['국/탕/찌개'] },
  { GNB_NAME: '정갈한 밑반찬', SUB_GNB: ['나물/무침', '조림/볶음', '절임/장아찌'] }
];

export default function GNBWrap() {
  const [subGnbVisible, setSubGnbVisible] = useState(false);

  return (
    <Wrap>
      <GnbList onMouseEnter={() => setSubGnbVisible(true)} onMouseLeave={() => setSubGnbVisible(false)}>
        {GNB_INFO.map(({ GNB_NAME }, gnbIndex) => (
          <GNB key={`${GNB_NAME}_${gnbIndex}`}>
            <Text size="MEDIUM" value={GNB_NAME} />
            <SubGNBList subGnbVisible={subGnbVisible} GNB_INFO={GNB_INFO} gnbIndex={gnbIndex} />
          </GNB>
        ))}
      </GnbList>
    </Wrap>
  );
}

const Wrap = styled.nav({
  flex: '1 0 0'
});

const GnbList = styled.ul({
  display: 'flex',
  gap: '24px'
});

const GNB = styled.li({
  cursor: 'pointer'
});
