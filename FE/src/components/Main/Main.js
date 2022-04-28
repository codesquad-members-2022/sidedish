import { useEffect, useState } from 'react';
import styled from 'styled-components';

import categoriesApi from '../../apis/categoriesApi';
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
  const [subContents, setSubContents] = useState([]);

  const handleMoreButtonClick = () => {
    setMoreButtonDisplay('none');
  };
  useEffect(() => {
    const fetchInitSubContents = async () => {
      const { data: initContents } = await categoriesApi.getFoodsByCategory({
        type: 'main',
        pageId: 1,
      });

      setSubContents([initContents]);
    };
    fetchInitSubContents();
  }, []);

  useEffect(() => {
    const fetchMoreSubContents = async () => {
      const getSoupContents = categoriesApi.getFoodsByCategory({
        type: 'soup',
        pageId: 1,
      });
      const getSideContents = categoriesApi.getFoodsByCategory({
        type: 'side',
        pageId: 1,
      });
      const [{ data: soupContents }, { data: sideContents }] =
        await Promise.all([getSoupContents, getSideContents]);

      setSubContents([...subContents, soupContents, sideContents]);
    };
    if (moreButtonDisplay === 'none') {
      fetchMoreSubContents();
    }
  }, [moreButtonDisplay]);

  return (
    <MainWrap>
      <MainContent />
      <SubContents subContents={subContents} />
      <MoreContentButton
        moreButtonDisplay={moreButtonDisplay}
        onButtonClick={handleMoreButtonClick}
      />
    </MainWrap>
  );
};

export default Main;
