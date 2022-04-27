import React, { useState } from 'react';
import styled from 'styled-components';
import Text from 'components/utils/Text';
import SubGNB from 'components/Header/SubGNB';

const GNB_INFO = [
  { GNB_NAME: '든든한 메인요리', SUB_GNB: ['육류 요리', '해산물 요리'] },
  { GNB_NAME: '뜨뜬한 국물요리', SUB_GNB: ['국/탕/찌개'] },
  { GNB_NAME: '정갈한 밑반찬', SUB_GNB: ['나물/무침', '조림/볶음', '절임/장아찌'] }
];

export default function GNB() {
  const [subGnbVisible, setSubGnbVisible] = useState(false);

  return (
    <Wrap>
      <GNBItems>
        {GNB_INFO.map(({ GNB_NAME }, gnbIndex) => (
          <GNBItem
            key={`${GNB_NAME}_${gnbIndex}`}
            onMouseEnter={() => setSubGnbVisible(true)}
            onMouseLeave={() => setSubGnbVisible(false)}
          >
            <Text size="MEDIUM" value={GNB_NAME} />
            <SubGNB visible={subGnbVisible} SUB_GNB_INFO={GNB_INFO[gnbIndex]} gnbIndex={gnbIndex} />
          </GNBItem>
        ))}
      </GNBItems>
    </Wrap>
  );
}

const Wrap = styled.nav({
  flex: '1 0 0',
  marginTop: '4px'
});

const GNBItems = styled.ul({
  display: 'flex'
});

const GNBItem = styled.li`
  padding: 10px 12px 0;
  cursor: pointer;
`;
