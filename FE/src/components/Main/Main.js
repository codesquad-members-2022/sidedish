import { useEffect, useState } from 'react';
import styled from 'styled-components';

import subContents from '../../mocks/subContents';
import MainContent from './MainContent';
import MoreContentButton from './MoreContentButton';
import SubContents from './SubContents';

const MainWrap = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 200px;
`;

const Main = () => {
  const [moreButtonDisplay, setMoreButtonDisplay] = useState('block');
  const [subContentsList, setSubContentsList] = useState(
    subContents.slice(0, 1),
  );

  const handleMoreButtonClick = () => {
    setMoreButtonDisplay('none');
  };

  useEffect(() => {
    if (moreButtonDisplay === 'none') {
      setSubContentsList(subContents);
    }
  }, [moreButtonDisplay]);

  return (
    <MainWrap>
      <MainContent />
      <SubContents subContents={subContentsList} />
      <MoreContentButton
        moreButtonDisplay={moreButtonDisplay}
        onButtonClick={handleMoreButtonClick}
      />
    </MainWrap>
  );
};

export default Main;
