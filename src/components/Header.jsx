import React, { useState } from 'react';
import styled from 'styled-components';
import Text from './Text';
import IconButton from './IconButton';

const GNB_INFO = [
  { GNB_NAME: '든든한 메인요리', SUB_GNB: ['육류 요리', '해산물 요리'] },
  { GNB_NAME: '뜨뜬한 국물요리', SUB_GNB: ['국/탕/찌개'] },
  { GNB_NAME: '정갈한 밑반찬', SUB_GNB: ['나물/무침', '조림/볶음', '절임/장아찌'] }
];
const iconButtons = {
  search: {
    width: '24px',
    height: '24px'
  },
  user: {
    width: '22px',
    height: '22px'
  },
  cart: {
    width: '27px',
    height: '28px'
  }
};

export default function Header() {
  const [subGnbVisible, setSubGnbVisible] = useState(false);

  return (
    <Wrap>
      <Logo>
        <Text size="2.857rem" family="LOGO" value="Ordering" />
      </Logo>
      <GnbWrap>
        <GnbList onMouseEnter={() => setSubGnbVisible(true)} onMouseLeave={() => setSubGnbVisible(false)}>
          {GNB_INFO.map(({ GNB_NAME }, gnbIndex) => (
            <Gnb key={`${GNB_NAME}_${gnbIndex}`}>
              <Text size="MEDIUM" value={GNB_NAME} />
              <SubGnbList subGnbVisible={subGnbVisible}>
                {GNB_INFO[gnbIndex].SUB_GNB.map((subGnbName, index) => (
                  <SubGnb key={`${subGnbName}_${index}`}>
                    <a href="http://localhost:3000/">
                      <Text value={subGnbName} />
                    </a>
                  </SubGnb>
                ))}
              </SubGnbList>
            </Gnb>
          ))}
        </GnbList>
      </GnbWrap>
      <MyUtils>
        {Object.keys(iconButtons).map(iconName => (
          <li>
            <IconButton icon={iconName} width={iconButtons[iconName].width} height={iconButtons[iconName].hieght} />
          </li>
        ))}
      </MyUtils>
    </Wrap>
  );
}

Header.defaultProps = {
  value: '',
  disabled: false
};

const Wrap = styled.header({
  display: 'flex',
  gap: '40px',
  padding: '30px 80px 16px',
  borderBottom: `1px solid ${({ theme }) => theme.COLOR.BLACK[100]}`
});

const Logo = styled.h1({
  marginTop: '-14px',
  lineHeight: 1.1
});

const GnbWrap = styled.nav({
  flex: '1 0 0'
});

const GnbList = styled.ul({
  display: 'flex',
  gap: '24px'
});

const Gnb = styled.li({
  cursor: 'pointer'
});

const MyUtils = styled.ul({
  display: 'flex',
  gap: '15px'
});

const SubGnbList = styled.ul({
  maxHeight: props => (props.subGnbVisible ? '100%' : 0),
  transition: 'max-height .15s ease-in-out',
  overflow: 'hidden'
});

const SubGnb = styled.li`
  margin-top: 8px;
  line-height: 1.5;
  &:last-child {
    margin-bottom: 24px;
  }
`;
