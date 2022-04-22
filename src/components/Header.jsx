import React, { useState } from 'react';
import styled from 'styled-components';
import Text from './Text';
import COLOR from '../variable/color';
import IconButton from './IconButton';

export default function Header() {
  const [subGnbVisible, setSubGnbVisible] = useState(false);
  const gnbNames = ['든든한 메인요리', '뜨뜬한 국물요리', '정갈한 밑반찬'];
  const subGnbNames = [['육류 요리', '해산물 요리'], ['국/탕/찌개'], ['나물/무침', '조림/볶음', '절임/장아찌']];
  const iconButtons = {
    search: {
      width: '24px',
      height: '24px',
    },
    user: {
      width: '22px',
      height: '22px',
    },
    cart: {
      width: '27px',
      height: '28px',
    },
  };

  return (
    <Wrap>
      <Logo>
        <Text size="2.857rem" family="LOGO" value="Ordering" />
      </Logo>
      <GnbWrap>
        <GnbList onMouseEnter={() => setSubGnbVisible(true)} onMouseLeave={() => setSubGnbVisible(false)}>
          {gnbNames.map((gnbName, gnbIndex) => (
            <Gnb>
              <Text size="MEDIUM" value={gnbName} />
              <SubGnbList subGnbVisible={subGnbVisible}>
                {subGnbNames[gnbIndex].map((subGnbName) => (
                  <SubGnb>
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
        {Object.keys(iconButtons).map((iconName) => (
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
  disabled: false,
};

const Wrap = styled.header({
  display: 'flex',
  gap: '40px',
  padding: '30px 80px 16px',
  borderBottom: `1px solid ${COLOR.BLACK}`,
});

const Logo = styled.h1({
  marginTop: '-14px',
  lineHeight: 1.1,
});

const GnbWrap = styled.nav({
  flex: '1 0 0',
});

const GnbList = styled.ul({
  display: 'flex',
  gap: '24px',
});

const Gnb = styled.li({
  cursor: 'pointer',
});

const MyUtils = styled.ul({
  display: 'flex',
  gap: '15px',
});

const SubGnbList = styled.ul({
  maxHeight: (props) => (props.subGnbVisible ? '100%' : 0),
  transition: 'max-height .15s ease-in-out',
  overflow: 'hidden',
});

const SubGnb = styled.li`
  margin-top: 8px;
  line-height: 1.5;
  &:last-child {
    margin-bottom: 24px;
  }
`;
